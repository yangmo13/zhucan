package com.sloth.codegen.kit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.jfinal.kit.LogKit;

public class ResKit {
	// 将内容写入指定文件中
	public static void writeToFile(String content, String target) {
		File file = new File(target);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream(target), "UTF-8");
			osw.write(content);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					LogKit.error(e.getMessage(), e);
				}
			}
		}
	}
}