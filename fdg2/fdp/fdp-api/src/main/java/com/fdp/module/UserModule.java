package com.fdp.module;

import com.fdp.api.UserApi;
import com.fdp.model.Archive;
import com.fdp.model.EduExper;
import com.fdp.model.Resume;
import com.fdp.model.TrainExper;
import com.fdp.model.WorkExper;
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
		arp.addSqlTemplate("fdp/archive.sql");
		arp.addMapping("f_archive", "ID", Archive.class);
		arp.addSqlTemplate("fdp/resume.sql");
		arp.addMapping("f_resume", "ID", Resume.class);
		arp.addSqlTemplate("fdp/workExper.sql");
		arp.addMapping("f_work_exper", "ID", WorkExper.class);
		arp.addSqlTemplate("fdp/trainExper.sql");
		arp.addMapping("f_train_exper", "ID", TrainExper.class);
		arp.addSqlTemplate("fdp/eduExper.sql");
		arp.addMapping("f_edu_exper", "ID", EduExper.class);
	}
}