package com.sloth.sys.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.sloth.model.Data;
import com.sloth.model.Role;
import com.sloth.service.DataService;
import com.sloth.service.RoleService;

public class RoleController extends Controller {
	private RoleService roleService = Aop.get(RoleService.class);
	private DataService dataService = Aop.get(DataService.class);

	@RequiresPermissions("role:list")
	public void index() {
		render("role_list.html");
	}

	@RequiresPermissions("role:list")
	public void findAll(@Para("page") int pageNo, @Para("limit") int pageCount) {
		Page<Role> roles = roleService.findAll(pageNo, pageCount);
		renderJson(new TableData(roles.getTotalRow(), roles.getList()));
	}

	@RequiresPermissions(value = { "role:edit", "role:add" }, logical = Logical.OR)
	public void goAddOrEdit(String id) {
		if (id != null) {
			this.setAttr("role", roleService.findById(id));
		}
		render("role_edit.html");
	}

	@RequiresPermissions("role:edit")
	public void edit(Role role) {
		roleService.update(role);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("role:add")
	public void add(Role role) {
		roleService.add(role);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("role:del")
	public void del(String id) {
		roleService.del(id);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("role:func_auth")
	public void goSetFuncAuth(String roleId) {
		List<Map<String, Object>> datas = roleService.findTreeDataForSetPermission(roleId);
		this.setAttr("datas", datas);
		this.setAttr("roleId", roleId);
		render("func_auth.html");
	}

	@RequiresPermissions("role:func_auth")
	public void setFuncAuth(String roleId, String menuIds, String functions) {
		roleService.setFuncAuth(roleId, menuIds, functions);
		renderJson(new AjaxData());
	}
	
	@RequiresPermissions("role:data_auth")
	public void goSetDataAuth(String roleId) {
		List<Data> datas = dataService.findByRoleId(roleId);
		this.setAttr("datas", datas);
		this.setAttr("roleId", roleId);
		render("data_auth.html");
	}

	@RequiresPermissions("role:data_auth")
	public void setDataAuth(String roleId, String dataIds, String auths) {
		roleService.setDataAuth(roleId, dataIds, auths);
		renderJson(new AjaxData());
	}
}