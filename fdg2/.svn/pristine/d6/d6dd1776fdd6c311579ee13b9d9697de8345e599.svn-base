package com.fdp.module;

import com.fdp.model.Content;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class ContentModule implements Module {
	@Override
	public void configRoutes(Routes me) {
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/content.sql");
		arp.addMapping("f_content", "ID", Content.class);
	}
}