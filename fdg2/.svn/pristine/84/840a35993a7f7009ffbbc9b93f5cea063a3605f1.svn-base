package com.sloth.sys.shiro.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.jfinal.aop.Aop;
import com.sloth.model.Role;
import com.sloth.model.User;
import com.sloth.service.RoleService;

public class DevUserBiz implements IUserBiz {
	private RoleService roleService = Aop.get(RoleService.class);

	@Override
	public void handle(User user, SimpleAuthorizationInfo info) {
		List<Role> roles = roleService.findAll();
		List<String> roleids = new ArrayList<>();
		for (Role role : roles) {
			info.addRole(role.getCode());
			roleids.add(role.getId());
		}
		info.addRole("ROLE_DEV");
		List<String> permissions = roleService.findAllPermissions();
		info.addStringPermissions(permissions);
		info.addStringPermission("menu:list");
		info.addStringPermission("menu:add");
		info.addStringPermission("menu:edit");
		info.addStringPermission("menu:del");
		info.addStringPermission("menu:view");
		info.addStringPermission("menu:move");
		info.addStringPermission("data:list");
		info.addStringPermission("data:add");
		info.addStringPermission("data:edit");
		info.addStringPermission("data:del");
	}

	public List<Map<String, Object>> findMenusForMe() {
		List<Map<String, Object>> datas = menuService.findByUserid(null);
		Map<String, Object> devMenu = new HashMap<>();
		devMenu.put("id", "-1");
		devMenu.put("name", "开发管理");
		devMenu.put("icon", "fa fa-glass");
		devMenu.put("pid", 0);
		datas.add(0, devMenu);
		List<Map<String, Object>> children = new ArrayList<>();
		devMenu.put("children", children);
		Map<String, Object> menu = new HashMap<>();
		menu.put("id", "-2");
		menu.put("name", "菜单管理");
		menu.put("url", "menu");
		menu.put("icon", "fa fa-bars");
		menu.put("pid", -1);
		children.add(menu);
		Map<String, Object> dataMenu = new HashMap<>();
		dataMenu.put("id", "-3");
		dataMenu.put("name", "数据管理");
		dataMenu.put("url", "data");
		dataMenu.put("icon", "fa fa-database");
		dataMenu.put("pid", -1);
		children.add(dataMenu);
		return datas;
	}
}