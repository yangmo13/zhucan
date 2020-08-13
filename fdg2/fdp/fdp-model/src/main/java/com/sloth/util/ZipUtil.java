package com.sloth.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtil {
	public static void zipFolder(File srcFilePath, File zipFilePath, boolean zipTopDir) throws Exception {
//		java.util.zip.ZipOutputStream outZip = new java.util.zip.ZipOutputStream(
//				new java.io.FileOutputStream(zipFilePath));
		ZipOutputStream outZip = new ZipOutputStream(new FileOutputStream(zipFilePath));
//		java.io.File file = new java.io.File(srcFilePath);
		zipFiles(srcFilePath.getParent() + java.io.File.separator, srcFilePath.getName(), outZip, zipTopDir, true);
		outZip.finish();
		outZip.close();
	}

	private static void zipFiles(String folderPath, String filePath, java.util.zip.ZipOutputStream zipOut,
			boolean zipTopDir, boolean isFirstFile) throws Exception {
		if (zipOut == null) {
			return;
		}
		java.io.File file = new java.io.File(folderPath + filePath);
		if (file.isFile()) {
			java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry(filePath);
			java.io.FileInputStream inputStream = new java.io.FileInputStream(file);
			zipOut.putNextEntry(zipEntry);
			int len;
			byte[] buffer = new byte[100000];
			while ((len = inputStream.read(buffer)) != -1) {
				zipOut.write(buffer, 0, len);
			}
			inputStream.close();
			zipOut.closeEntry();
		} else {
			String fileList[] = file.list();
			if (fileList.length <= 0) {
				java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry(filePath + java.io.File.separator);
				zipOut.putNextEntry(zipEntry);
				zipOut.closeEntry();
			}
			for (int i = 0; i < fileList.length; i++) {
				if (!zipTopDir && isFirstFile) {
					zipFiles(folderPath + java.io.File.separator + filePath + File.separator, fileList[i], zipOut,
							zipTopDir, false);
				} else {
					zipFiles(folderPath, filePath + java.io.File.separator + fileList[i], zipOut, zipTopDir, false);
				}
			}
		}
	}

	public static void upZipFile(File zipFile, String folderPath, boolean includeZipFileName)
			throws ZipException, IOException {
		ZipFile zfile = new ZipFile(zipFile);
		String folderName = includeZipFileName ? zipFile.getName().substring(0, zipFile.getName().lastIndexOf("."))
				: "";
		Enumeration<?> zList = zfile.entries();
		byte[] buf = new byte[1024];
		while (zList.hasMoreElements()) {
			ZipEntry ze = (ZipEntry) zList.nextElement();
			String dirstr = folderPath + "/" + (includeZipFileName ? folderName : "") + "/" + ze.getName();
			File f = new File(dirstr);
			if (ze.isDirectory()) {
				f.mkdirs();
				continue;
			} else {
				if (!f.getParentFile().exists()) {
					f.getParentFile().mkdirs();
				}
			}
			OutputStream os = new BufferedOutputStream(new FileOutputStream(f));
			InputStream is = new BufferedInputStream(zfile.getInputStream(ze));
			int readLen = 0;
			while ((readLen = is.read(buf, 0, 1024)) != -1) {
				os.write(buf, 0, readLen);
			}
			is.close();
			os.close();
		}
		zfile.close();
	}

	/**
	 * 解压缩zip包
	 *
	 * @param zipFilePath        zip文件的全路径
	 * @param unzipFilePath      解压后的文件保存的路径
	 * @param includeZipFileName 解压后的文件保存的路径是否包含压缩文件的文件名。true-包含；false-不包含
	 */
	@SuppressWarnings("unchecked")
	public static void unzip(String zipFilePath, String unzipFilePath, boolean includeZipFileName) throws Exception {
		if (StringKit.isEmpty(zipFilePath) || StringKit.isEmpty(unzipFilePath)) {
			throw new Exception("文件不存在");
		}
		File zipFile = new File(zipFilePath);
		// 如果解压后的文件保存路径包含压缩文件的文件名，则追加该文件名到解压路径
		if (includeZipFileName) {
			String fileName = zipFile.getName();
			if (!StringKit.isEmpty(fileName)) {
				if (fileName.lastIndexOf(".") > 0) {
					fileName = fileName.substring(0, fileName.lastIndexOf("."));
				}
			}
			unzipFilePath = unzipFilePath + File.separator + fileName;
		}
		// 创建解压缩文件保存的路径
		File unzipFileDir = new File(unzipFilePath);
		if (!unzipFileDir.exists() || !unzipFileDir.isDirectory()) {
			unzipFileDir.mkdirs();
		}

		// 开始解压
		ZipEntry entry = null;
		String entryFilePath = null, entryDirPath = null;
		File entryFile = null, entryDir = null;
		int index = 0, count = 0, bufferSize = 1024;
		byte[] buffer = new byte[bufferSize];
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ZipFile zip = new ZipFile(zipFile);
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();
		// 循环对压缩包里的每一个文件进行解压
		while (entries.hasMoreElements()) {
			entry = entries.nextElement();
			// 构建压缩包中一个文件解压后保存的文件全路径
			entryFilePath = unzipFilePath + File.separator + entry.getName();
			// 构建解压后保存的文件夹路径
			index = entryFilePath.lastIndexOf(File.separator);
			if (index != -1) {
				entryDirPath = entryFilePath.substring(0, index);
			} else {
				entryDirPath = "";
			}
			entryDir = new File(entryDirPath);
			// 如果文件夹路径不存在，则创建文件夹
			if (!entryDir.exists() || entry.isDirectory()) {
				entryDir.mkdirs();
			}
			if (entry.isDirectory())
				continue;

			// 创建解压文件
			entryFile = new File(entryFilePath);
			if (entryFile.exists()) {
				// 检测文件是否允许删除，如果不允许删除，将会抛出SecurityException
				SecurityManager securityManager = new SecurityManager();
				securityManager.checkDelete(entryFilePath);
				// 删除已存在的目标文件
				entryFile.delete();
			}

			// 写入文件
			bos = new BufferedOutputStream(new FileOutputStream(entryFile));
			bis = new BufferedInputStream(zip.getInputStream(entry));
			while ((count = bis.read(buffer, 0, bufferSize)) != -1) {
				bos.write(buffer, 0, count);
			}
			bos.flush();
			bos.close();
		}
		zip.close();
	}

	/**
	 * 删除某个文件夹下的所有文件夹和文件
	 * 
	 * @param delpath
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static boolean deleteFile(String delpath) throws FileNotFoundException, IOException {
		try {
			File file = new File(delpath);
			if (!file.isDirectory()) {
				file.delete();
			} else if (file.isDirectory()) {
				File[] fileList = file.listFiles();
				for (int i = 0; i < fileList.length; i++) {
					File delfile = fileList[i];
					if (!delfile.isDirectory()) {
						delfile.delete();
					} else if (delfile.isDirectory()) {
						deleteFile(fileList[i].getPath());
					}
				}
				file.delete();
			}
		} catch (FileNotFoundException e) {
			System.out.println("deletefile()  Exception:" + e.getMessage());
		}
		return true;
	}
}
