package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.TinyWish;

import com.fdp.controller.TinyWishController;

public class TinyWishModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/tinyWish", TinyWishController.class, "/pages/fdp/tinyWish");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/tinyWish.sql");
		arp.addMapping("f_tiny_wish", "ID", TinyWish.class);
	}
}