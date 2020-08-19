package com.fdp.module;

import com.fdp.model.WorkExper;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class WorkExperModule implements Module {
	@Override
	public void configRoutes(Routes me) {
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/workExper.sql");
		arp.addMapping("f_work_exper", "ID", WorkExper.class);
	}
}