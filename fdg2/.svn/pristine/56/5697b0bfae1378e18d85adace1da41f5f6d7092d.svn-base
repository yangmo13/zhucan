package com.sloth.util;

import java.security.MessageDigest;

public final class MD5 {

	private MD5() {
	}

	public static String encrypt(String content) {
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(content.getBytes("UTF-8"));
			return getHasnString(digest);
		} catch (Exception e) {
		}
		return null;
	}

	private static String getHasnString(MessageDigest digest) {
		StringBuilder builder = new StringBuilder();
		for (byte b : digest.digest()) {
			builder.append(Integer.toHexString((b >> 4) & 0xf));
			builder.append(Integer.toHexString(b & 0xf));
		}
		return builder.toString();
	}
}
