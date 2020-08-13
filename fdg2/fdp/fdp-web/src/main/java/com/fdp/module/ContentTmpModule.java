package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.ContentTmp;

import com.fdp.controller.ContentTmpController;

public class ContentTmpModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/contentTmp", ContentTmpController.class, "/pages/fdp/contentTmp");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/contentTmp.sql");
		arp.addMapping("f_content_tmp", "ID", ContentTmp.class);
	}
}