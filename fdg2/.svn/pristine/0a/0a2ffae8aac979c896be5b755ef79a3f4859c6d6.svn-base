package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.TinyWishTmp;

import com.fdp.controller.TinyWishTmpController;

public class TinyWishTmpModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/tinyWishTmp", TinyWishTmpController.class, "/pages/fdp/tinyWishTmp");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/tinyWishTmp.sql");
		arp.addMapping("f_tiny_wish_tmp", "ID", TinyWishTmp.class);
	}
}