package com.sloth.sys.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.jfinal.core.Controller;
import com.sloth.sys.util.FileKit;

public class DownloadController extends Controller {
	public void index(String src, String filename) {
		try {
			src = URLDecoder.decode(src, "UTF-8");
			this.renderFile(new File(FileKit.getTmpFolder(), src), URLDecoder.decode(filename, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}