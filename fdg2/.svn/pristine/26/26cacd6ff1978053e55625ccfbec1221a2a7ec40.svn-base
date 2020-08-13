package com.sloth;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.sloth.model._MappingKit;

public class BaseMappingKit {
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addSqlTemplate("base/menu.sql");
		arp.addSqlTemplate("base/role.sql");
		arp.addSqlTemplate("base/user.sql");
		arp.addSqlTemplate("base/dept.sql");
		arp.addSqlTemplate("base/dict.sql");
		arp.addSqlTemplate("base/config.sql");
		arp.addSqlTemplate("base/data.sql");
		_MappingKit.mapping(arp);
	}
}