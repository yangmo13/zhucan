package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.Archive;

import com.fdp.controller.ArchiveController;

public class ArchiveModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/archive", ArchiveController.class, "/pages/fdp/archive");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/archive.sql");
		arp.addMapping("f_archive", "ID", Archive.class);
	}
}