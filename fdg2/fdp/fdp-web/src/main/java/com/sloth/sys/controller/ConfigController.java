package com.sloth.sys.controller;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.sloth.common.AjaxData;
import com.sloth.service.ConfigService;

public class ConfigController extends Controller {
	private ConfigService configService = Aop.get(ConfigService.class);

	@RequiresPermissions("config:list")
	public void index() {
		render("config_list.html");
	}

	@RequiresPermissions("config:save")
	public void save() {
		Map<String, String[]> maps = this.getParaMap();
		configService.saveAll(maps);
		renderJson(new AjaxData());
	}
}