package com.sloth.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.sloth.common.AjaxData;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Dept;
import com.sloth.service.DeptService;
import com.sloth.sys.util.CtxUtil;
import com.sloth.sys.util.DataFilterKit;

public class DeptController extends Controller {
	private DeptService deptService = Aop.get(DeptService.class);

	@RequiresPermissions("dept:list")
	public void index() {
		this.set("dataAuth", DataFilterKit.getDataAuth("dept"));
		render("dept_list.html");
	}

	@RequiresPermissions("dept:list")
	public void findAll() {
		List<Dept> datas = deptService.findAll(DataFilterKit.get("dept"));
		Map<String, Object> treeData = new HashMap<>();
		treeData.put("code", 0);
		treeData.put("data", datas);
		treeData.put("count", datas.size());
		renderJson(treeData);
	}

	@RequiresPermissions(value = { "dept:add", "dept:edit" }, logical = Logical.OR)
	public void goAddOrEdit(String id, String pid) {
		if (id != null) {
			this.setAttr("dept", deptService.findById(id));
		} else {
			Dept dept = new Dept();
			dept.setPid(pid);
			this.setAttr("dept", dept);
		}
		render("dept_edit.html");
	}

	@RequiresPermissions("menu:view")
	public void goView(String id) {
		this.setAttr("dept", deptService.findById(id));
		render("dept_view.html");
	}

	@RequiresAuthentication
	public void findForTreeSelect(String id) {
		List<Map<String, Object>> datas = deptService.findForTreeSelect(id, DataFilterKit.get("dept"));
		renderJson(datas);
	}

	@RequiresPermissions("dept:edit")
	public void edit(Dept dept) {
		deptService.update(dept);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("dept:add")
	public void add(Dept dept) {
		dept.setOpUserId(CtxUtil.getCurrentUser().getId());
		deptService.add(dept);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("dept:del")
	public void del(String id) {
		AjaxData ajaxData = new AjaxData();
		try {
			deptService.del(id);
		} catch (SlothException e) {
			ajaxData.setCode(50000);
			ajaxData.setMsg(e.getMessage());
		}
		renderJson(ajaxData);
	}

	@RequiresPermissions("dept:move")
	public void move(String id, int direct) {
		deptService.move(id, direct);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("dept:view")
	public void findById(String id) {
		renderJson(new AjaxData(deptService.findById(id)));
	}
}