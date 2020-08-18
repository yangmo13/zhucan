package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.TUser;

import com.fdp.controller.TUserController;

public class TUserModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/tUser", TUserController.class, "/pages/fdp/tUser");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/tUser.sql");
		arp.addMapping("t_user", "ID", TUser.class);
	}
}