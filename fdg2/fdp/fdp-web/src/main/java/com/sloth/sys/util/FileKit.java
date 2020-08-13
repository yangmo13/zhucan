package com.sloth.sys.util;

import java.io.ByteArrayOutputStream;
import java.io.File;

import com.jfinal.kit.Base64Kit;
import com.jfinal.kit.PathKit;

import net.coobird.thumbnailator.Thumbnails;

public class FileKit {
	public static File getTmpFolder() {
		return new File(PathKit.getWebRootPath(), "upload");
	}

	public static String base64(String path, String type) {
		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Thumbnails.of(path).size(220, 120).toOutputStream(out);
			String te = Base64Kit.encode(out.toByteArray()).replaceAll("\n", "").replaceAll("\r", "");
			return "data:image/" + type + ";base64," + te;
		} catch (Exception e) {
			return null;
		}
	}
}