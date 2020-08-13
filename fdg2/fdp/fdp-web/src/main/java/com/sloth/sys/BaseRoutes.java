package com.sloth.sys;

import com.jfinal.config.Routes;
import com.sloth.sys.controller.ConfigController;
import com.sloth.sys.controller.DataController;
import com.sloth.sys.controller.DeptController;
import com.sloth.sys.controller.DictController;
import com.sloth.sys.controller.IndexController;
import com.sloth.sys.controller.MenuController;
import com.sloth.sys.controller.RoleController;
import com.sloth.sys.controller.UserController;

public class BaseRoutes extends Routes {
	@Override
	public void config() {
		this.setBaseViewPath("/pages/base");
		this.add("/", IndexController.class);
		this.add("/menu", MenuController.class);
		this.add("/role", RoleController.class);
		this.add("/user", UserController.class);
		this.add("/dept", DeptController.class);
		this.add("/dict", DictController.class);
		this.add("/config", ConfigController.class);
		this.add("/data", DataController.class);
	}
}