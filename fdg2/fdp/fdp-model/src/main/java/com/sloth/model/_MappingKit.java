package com.sloth.model;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

public class _MappingKit {
	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("t_dept", "ID", Dept.class);
		arp.addMapping("t_function", "ID", Function.class);
		arp.addMapping("t_menu", "ID", Menu.class);
		arp.addMapping("t_role", "ID", Role.class);
		arp.addMapping("t_role_menu", "ID", RoleMenu.class);
		arp.addMapping("t_role_permission", "ID", RolePermission.class);
		arp.addMapping("t_role_user", "ID", RoleUser.class);
		arp.addMapping("t_user", "ID", User.class);
		arp.addMapping("t_dict", "ID", Dict.class);
		arp.addMapping("t_config", "ID", Config.class);
		arp.addMapping("t_data", "ID", Data.class);
		arp.addMapping("t_tmp_user", "ID", TmpUser.class);
	}
}