package com.sloth.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import com.jfinal.kit.Base64Kit;

import net.coobird.thumbnailator.Thumbnails;

public class StreamKit {
	public static String readFromJar(String path) throws Exception {
		String tmp = StreamKit.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		tmp = java.net.URLDecoder.decode(tmp, "UTF-8");
		URL url = new URL("jar:file:" + tmp + "!" + path);
		return readFromURL(url);
	}

	public static String readFromURL(URL url) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
		StringBuffer inputLine = new StringBuffer();
		String tmp = null;
		while ((tmp = in.readLine()) != null)
			inputLine.append(tmp).append("\n");
		return inputLine.toString().trim();
	}

	public static void save(InputStream in, File file) throws Exception {
		try (OutputStream out = new FileOutputStream(file)) {
			byte[] bytes = new byte[4096];
			int length;
			while ((length = in.read(bytes)) > 0) {
				out.write(bytes, 0, length);
			}
			out.flush();
		}
	}

	public static byte[] readBytes(InputStream in) throws Exception {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			byte[] bytes = new byte[4096];
			int length;
			while ((length = in.read(bytes)) > 0) {
				out.write(bytes, 0, length);
			}
			out.flush();
			return out.toByteArray();
		}
	}

	public static void writeBytes(OutputStream out, byte[] bytes) throws Exception {
		out.write(bytes);
		out.flush();
	}

	public static String base64(ByteArrayOutputStream out, String type) {
		try {
			String te = Base64Kit.encode(out.toByteArray()).replaceAll("\n", "").replaceAll("\r", "");
			return "data:image/" + type + ";base64," + te;
		} catch (Exception e) {
			return null;
		}
	}

	public static String base64(String path, String type) {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Thumbnails.of(path).scale(1).toOutputStream(out);
			String te = Base64Kit.encode(out.toByteArray()).replaceAll("\n", "").replaceAll("\r", "");
			return "data:image/" + type + ";base64," + te;
		} catch (Exception e) {
			return null;
		}
	}
}