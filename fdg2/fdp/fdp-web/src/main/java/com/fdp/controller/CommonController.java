package com.fdp.controller;

import java.io.File;

import com.fdp.common.CommonService;
import com.jfinal.core.Controller;

/**
 * 公共接口
 * @author 郭翔宇
 *
 */
public class CommonController extends Controller{

	/**
	 * 查看文件
	 * @param fileName
	 */
	public void showFile(String fileName) {
		File file = CommonService.findFileByFileName(fileName);
		renderFile(file);
	}
}
