package com.fdp.module;

import com.fdp.model.EduExper;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class EduExperModule implements Module {
	@Override
	public void configRoutes(Routes me) {
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/eduExper.sql");
		arp.addMapping("f_edu_exper", "ID", EduExper.class);
	}
}