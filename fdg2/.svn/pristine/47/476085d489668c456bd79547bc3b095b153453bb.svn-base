package com.fdp.module;

import com.fdp.model.TrainExper;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class TrainExperModule implements Module {
	@Override
	public void configRoutes(Routes me) {
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/trainExper.sql");
		arp.addMapping("f_train_exper", "ID", TrainExper.class);
	}
}