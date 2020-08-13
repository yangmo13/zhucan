package com.sloth.sys.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.sloth.model.User;
import com.sloth.service.ConfigService;
import com.sloth.service.DeptService;
import com.sloth.service.RoleService;
import com.sloth.service.UserService;
import com.sloth.sys.util.CtxUtil;
import com.sloth.sys.util.DataFilterKit;

public class UserController extends Controller {
	private UserService userService = Aop.get(UserService.class);
	private RoleService roleService = Aop.get(RoleService.class);
	private DeptService deptService = Aop.get(DeptService.class);
	private ConfigService configService = Aop.get(ConfigService.class);

	@RequiresPermissions("user:list")
	public void index() {
		this.setAttr("defaultPwd", configService.findValueByCode("user.defaultPwd"));
		this.setAttr("depts", deptService.findAll(DataFilterKit.get("dept")));
		render("user_list.html");
	}

	@RequiresPermissions("user:resetpwd")
	public void resetpwd(String id) {
		userService.resetpwd(id);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("user:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") User user) {
		Page<User> users = userService.find(user, pageNo, pageCount, DataFilterKit.get("user"));
		renderJson(new TableData(users.getTotalRow(), users.getList()));
	}

	@RequiresPermissions(value = { "user:edit", "user:add" }, logical = Logical.OR)
	public void goAddOrEdit(String id) {
		if (id != null) {
			this.setAttr("user_roles", roleService.findByUserId(id));
			this.setAttr("user", userService.findById(id));
		}
		this.setAttr("all_roles", roleService.findAll());
		render("user_edit.html");
	}

	@RequiresPermissions("user:edit")
	public void edit(User user, String roleids) {
		userService.update(user, roleids);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("user:add")
	public void add(User user, String roleids) {
		user.setOpUserId(CtxUtil.getCurrentUser().getId());
		userService.add(user, roleids);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("user:del")
	public void del(String id) {
		AjaxData data = new AjaxData();
		try {
			userService.del(id);
		} catch (Exception e) {
			data.setCode(50000);
			data.setMsg(e.getMessage());
		}
		renderJson(data);
	}

	@RequiresPermissions("user:lock")
	public void unlock(String id) {
		userService.unlock(id);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("user:lock")
	public void lock(String id) {
		userService.lock(id);
		renderJson(new AjaxData());
	}
}