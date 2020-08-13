package com.fdp.module;

import com.fdp.controller.ArticleTmpController;
import com.fdp.controller.ArticleTmpHrefController;
import com.fdp.model.ArticleTmp;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.common.Module;

public class ArticleTmpModule implements Module {
	@Override
	public void configRoutes(Routes me) {
		me.add("/articleTmp", ArticleTmpController.class, "/pages/fdp/articleTmp");
		me.add("/articleTmpHref", ArticleTmpHrefController.class, "/pages/fdp/articleTmp");
	}

	@Override
	public void configMappings(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("fdp/articleTmp.sql");
		arp.addMapping("f_article_tmp", "ID", ArticleTmp.class);
	}
}