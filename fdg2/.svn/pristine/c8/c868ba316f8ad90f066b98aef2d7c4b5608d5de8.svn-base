package com.fdp.module;

import com.fdp.model.Resume;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class ResumeModule implements Module {
	@Override
	public void configRoutes(Routes me) {
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/resume.sql");
		arp.addMapping("f_resume", "ID", Resume.class);
	}
}