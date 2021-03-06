package com.fdp.controller;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.fdp.common.CommonService;
import com.jfinal.core.Controller;
import com.sloth.model.Dict;
import com.sloth.service.DictService;

/**
 * 公共接口
 * @author 郭翔宇
 *
 */
public class CommonController extends Controller{
	
	private DictService dictService = new DictService();

	/**
	 * 查看文件
	 * @param fileName
	 */
	public void showFile(String fileName) {
		File file = CommonService.findFileByFileName(fileName);
		renderFile(file);
	}
	
	/**
	 * 类型字典数据
	 */
	public void findCategory() {
		Dict findByCode = dictService.findByCode("fdp.orgType");
		List<Dict> findListByPID = dictService.findListByPID("218");
		renderJson(findListByPID);
	}
}
