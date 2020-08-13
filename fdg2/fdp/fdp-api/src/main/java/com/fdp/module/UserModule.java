package com.fdp.module;

import com.fdp.api.UserApi;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class UserModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/user", UserApi.class);
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
	}
}