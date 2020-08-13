package com.fdp.common;

import java.io.File;

import com.jfinal.kit.PropKit;
import com.jfinal.upload.UploadFile;

/**
 * 公共业务类
 * @author 郭翔宇
 *
 */
public class CommonService {
	private static String PATH = PropKit.get("path")+"/common/showFile?fileName=";
	
	/**
	 * 文件上传
	 * @param file
	 * @return
	 */
	public static String uploadFile(UploadFile file) {
		//TODO 此处如有腾讯云接口可以直接覆盖以下代码
		String fileName=file.getFileName();
		String newPath = PATH+fileName;
		return newPath;
	}
	/**
	 * 根据文件名获取文件
	 * @param fileName
	 * @return
	 */
	public static File findFileByFileName(String fileName) {
		String path = PropKit.get("attachPath")+File.separator+fileName;
		File file = new File(path);
		return file;
	}
}
