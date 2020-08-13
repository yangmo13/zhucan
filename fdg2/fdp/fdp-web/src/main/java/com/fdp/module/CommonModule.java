package com.fdp.module;

import com.fdp.controller.CommonController;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class CommonModule  implements Module {

	@Override
	public void configRoutes(Routes me) {
		me.add("/common", CommonController.class);
		
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		// TODO Auto-generated method stub
		
	}

}
