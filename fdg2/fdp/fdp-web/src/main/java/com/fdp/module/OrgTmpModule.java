package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.OrgTmp;

import com.fdp.controller.OrgTmpController;

public class OrgTmpModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/orgTmp", OrgTmpController.class, "/pages/fdp/orgTmp");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/orgTmp.sql");
		arp.addMapping("f_org_tmp", "ID", OrgTmp.class);
	}
}