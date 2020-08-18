package com.fdp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.fdp.model.TUser;
import com.fdp.service.TUserService;
import com.sloth.sys.util.DataFilterKit;

public class TUserController extends Controller {
	private TUserService tUserService = Aop.get(TUserService.class);

	@RequiresPermissions("tUser:list")
	public void index() {
		render("tUser_list.html");
	}

	@RequiresPermissions("tUser:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") TUser tUser) {
		Page<TUser> tUsers = tUserService.find(tUser, pageNo, pageCount, DataFilterKit.get("tUser"));
		renderJson(new TableData(tUsers.getTotalRow(), tUsers.getList()));
	}

	@RequiresPermissions("tUser:add")
	public void goAdd() {
		render("tUser_edit.html");
	}
	
	@RequiresPermissions("tUser:edit")
	public void goEdit(String id) {
		if (id != null) {
			this.setAttr("tUser", tUserService.findById(id));
		}
		render("tUser_edit.html");
	}

	@RequiresPermissions("tUser:edit")
	public void edit(TUser tUser) {
		tUserService.update(tUser);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("tUser:add")
	public void add(TUser tUser) {
		tUserService.save(tUser);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("tUser:del")
	public void del(String id) {
		tUserService.del(id);
		renderJson(new AjaxData());
	}
}