package com.fdp.module;

import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;
import com.fdp.model.DocumentTmp;

import com.fdp.controller.DocumentTmpController;

public class DocumentTmpModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/documentTmp", DocumentTmpController.class, "/pages/fdp/documentTmp");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/documentTmp.sql");
		arp.addMapping("f_document_tmp", "ID", DocumentTmp.class);
	}
}