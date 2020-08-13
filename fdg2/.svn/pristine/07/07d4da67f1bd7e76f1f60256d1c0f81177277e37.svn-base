package com.sloth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jfinal.aop.Before;
import com.jfinal.aop.Duang;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.model.Function;
import com.sloth.model.Menu;
import com.sloth.model.Role;
import com.sloth.model.RoleMenu;
import com.sloth.model.RolePermission;
import com.sloth.util.StringKit;

public class RoleService {
	private Role roleDao = new Role();
	private RolePermission rolePermissionDao = new RolePermission();
	private MenuService menuService = Duang.duang(MenuService.class);
	private Function functionDao = new Function();

	public Page<Role> findAll(int pageNo, int pageSize) {
		Page<Role> roles = roleDao.paginate(pageNo, pageSize, roleDao.getSqlPara("role.findAll"));
		return roles;
	}

	public List<Role> findAll() {
		List<Role> roles = roleDao.find(roleDao.getSqlPara("role.findAll"));
		return roles;
	}

	public List<Role> findByUserId(String userId) {
		List<Role> roles = roleDao.find(roleDao.getSqlPara("role.findByUserId", Kv.by("userId", userId)));
		return roles;
	}

	public Role findById(String id) {
		return roleDao.findById(id);
	}

	public void update(Role role) {
		Role tmp = this.findById(role.getId());
		tmp.setCode(role.getCode());
		tmp.setName(role.getName());
		tmp.setUpdateTime(new Date());
		tmp.update();
	}

	public void add(Role role) {
		role.setId(UUID.randomUUID().toString());
		role.setEditable(1);
		role.setDeletable(1);
		role.setCreateTime(new Date());
		role.save();
	}

	@Before(Tx.class)
	public void del(String id) {
		Db.update(Db.getSqlPara("role.deleteRoleUserByRoleId", Kv.by("roleId", id)));
		Db.update(Db.getSqlPara("role.deleteRoleMenuByRoleId", Kv.by("roleId", id)));
		Db.update(Db.getSqlPara("role.deleteRolePermissionByRoleId", Kv.by("roleId", id)));
		Db.update(Db.getSqlPara("role.deleteRoleDataByRoleId", Kv.by("roleId", id)));
		roleDao.deleteById(id);
	}

	public List<RolePermission> findPermissionsByUserId(String userId) {
		List<RolePermission> permissions = rolePermissionDao.find(Db.getSqlPara("role.findPermissionsByUserId", Kv.by("userId", userId)));
		return permissions;
	}

	public List<Function> findPermissionsByRoleId(String roleId) {
		List<Function> permissions = functionDao.find(functionDao.getSqlPara("role.findFunctionByRoleId", Kv.by("roleId", roleId)));
		return permissions;
	}

	public List<Map<String, Object>> findTreeDataForSetPermission(String roleId) {
		List<Map<String, Object>> datas = new ArrayList<>();
		List<Menu> menus = menuService.findAll();
		List<Menu> myMenus = menuService.findMenuByRoleId(roleId);
		for (Menu menu : menus) {
			Map<String, Object> data = new HashMap<>();
			data.put("id", menu.getId());
			data.put("pId", menu.getPid());
			data.put("name", menu.getTitle());
			data.put("type", "M");
			for (Menu tmp : myMenus) {
				if (tmp.getId().intValue() == menu.getId().intValue()) {
					data.put("checked", true);
					break;
				}
			}
			datas.add(data);
		}
		List<Function> functions = menuService.findAllFunctions();
		List<Function> myFunctions = this.findPermissionsByRoleId(roleId);
		for (Function f : functions) {
			Map<String, Object> data = new HashMap<>();
			data.put("id", f.getId());
			data.put("pId", f.getMenuId());
			data.put("name", f.getName());
			data.put("type", "F");
			data.put("permission", f.getPermission());
			for (Function tmp : myFunctions) {
				if (tmp.getId().equals(f.getId())) {
					data.put("checked", true);
					break;
				}
			}
			datas.add(data);
		}
		return datas;
	}

	@Before(Tx.class)
	public void setDataAuth(String roleId, String dataIds, String auths) {
		Db.update(Db.getSqlPara("role.deleteRoleDataByRoleId", Kv.by("roleId", roleId)));
		String[] dataIdArr = dataIds.split(",");
		String[] authArr = auths.split(",");
		for (int i = 0; i < dataIdArr.length; i++) {
			Kv kv = Kv.by("id", UUID.randomUUID().toString());
			kv.set("roleId", roleId);
			kv.set("dataId", dataIdArr[i]);
			kv.set("dataAuth", authArr[i]);
			Db.template("role.insertRoleData", kv).update();
		}
	}

	@Before(Tx.class)
	public void setFuncAuth(String roleId, String menuIds, String functions) {
		Db.update(Db.getSqlPara("role.deleteRoleMenuByRoleId", Kv.by("roleId", roleId)));
		Db.update(Db.getSqlPara("role.deleteRolePermissionByRoleId", Kv.by("roleId", roleId)));
		String[] menuIdArray = menuIds.split(",");
		for (String menuId : menuIdArray) {
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setId(UUID.randomUUID().toString());
			roleMenu.setMenuId(Integer.parseInt(menuId));
			roleMenu.setRoleId(roleId);
			roleMenu.save();
		}
		if (StringKit.isNotEmpty(functions)) {
			String[] functionArray = functions.split(",");
			for (String function : functionArray) {
				String[] tmp = function.split("\\|");
				RolePermission rolePermission = new RolePermission();
				rolePermission.setId(UUID.randomUUID().toString());
				rolePermission.setMenuId(Integer.parseInt(tmp[0]));
				rolePermission.setPermission(tmp[1]);
				rolePermission.setRoleId(roleId);
				rolePermission.save();
			}
		}
		Role tmp = this.findById(roleId);
		tmp.setUpdateTime(new Date());
		tmp.update();
	}

	public List<String> findPermissions(List<String> roleids) {
		List<Record> permissions;
		if (roleids == null || roleids.size() == 0) {
			permissions = new ArrayList<>();
		} else {
			permissions = Db.find(Db.getSqlPara("role.findPermissions", Kv.by("roleids", roleids)));
		}
		List<String> results = new ArrayList<>();
		for (Record p : permissions) {
			results.add(p.getStr("PERMISSION"));
		}
		return results;
	}

	public List<String> findAllPermissions() {
		List<Record> permissions = Db.find(Db.getSqlPara("role.findAllPermissions"));
		List<String> results = new ArrayList<>();
		for (Record p : permissions) {
			results.add(p.getStr("PERMISSION"));
		}
		return results;
	}
}