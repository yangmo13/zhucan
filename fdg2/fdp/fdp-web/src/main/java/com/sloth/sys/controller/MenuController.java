package com.sloth.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.aop.Duang;
import com.jfinal.core.Controller;
import com.sloth.common.AjaxData;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Menu;
import com.sloth.service.MenuService;
import com.sloth.sys.shiro.biz.DevUserBiz;
import com.sloth.sys.shiro.biz.IUserBiz;
import com.sloth.sys.shiro.biz.NomalUserBiz;
import com.sloth.sys.util.CtxUtil;

public class MenuController extends Controller {
	private MenuService menuService = Duang.duang(MenuService.class);

	@RequiresPermissions("menu:list")
	public void index() {
		render("menu_list.html");
	}

	@RequiresAuthentication
	public void findMy() {
		AjaxData ajaxData = new AjaxData(0);
		IUserBiz userBiz;
		if (CtxUtil.isDevUser()) {
			userBiz = Aop.get(DevUserBiz.class);
		} else {
			userBiz = Aop.get(NomalUserBiz.class);
		}
		ajaxData.setData(userBiz.findMenusForMe());
		renderJson(ajaxData);
	}

	@RequiresPermissions("menu:list")
	public void findAll() {
		List<Menu> menus = menuService.findAll();
		Map<String, Object> treeData = new HashMap<>();
		treeData.put("code", 0);
		treeData.put("data", menus);
		treeData.put("count", menus.size());
		renderJson(treeData);
	}

	@RequiresPermissions("menu:edit")
	public void goAddOrEdit(Integer id) {
		IUserBiz userBiz;
		if (CtxUtil.isDevUser()) {
			userBiz = Aop.get(DevUserBiz.class);
		} else {
			userBiz = Aop.get(NomalUserBiz.class);
		}
		if (id != null) {
			this.setAttr("menu", menuService.findById(id));
			this.setAttr("functions", menuService.findFunctionsByMenuId(id));
		} else {
			Menu menu = new Menu();
			menu.setPid(0);
			this.setAttr("menu", menu);
			this.setAttr("functions", userBiz.getDefaultFunctions("menu"));
		}
		render("menu_edit.html");
	}

	@RequiresPermissions("menu:view")
	public void goView(int id) {
		this.setAttr("menu", menuService.findById(id));
		this.setAttr("functions", menuService.findFunctionsByMenuId(id));
		render("menu_view.html");
	}

	@RequiresPermissions(value = { "menu:add", "menu:edit" }, logical = Logical.OR)
	public void findForTreeSelect(int id) {
		List<Map<String, Object>> datas = menuService.findForTreeSelect(id);
		renderJson(datas);
	}

	@RequiresPermissions("menu:view")
	public void findById(String id) {
		renderJson(new AjaxData(menuService.findById(Integer.parseInt(id))));
	}

	@RequiresPermissions("menu:edit")
	public void edit(Menu menu, String functions) {
		menuService.update(menu, functions);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("menu:add")
	public void add(Menu menu, String functions) {
		menuService.add(menu, functions);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("role:del")
	public void del(int id) {
		AjaxData ajaxData = new AjaxData();
		try {
			menuService.del(id);
		} catch (SlothException e) {
			ajaxData.setCode(e.getCode());
		}
		renderJson(ajaxData);
	}

	@RequiresPermissions("menu:move")
	public void move(String id, int direct) {
		menuService.move(id, direct);
		;
		renderJson(new AjaxData());
	}
}