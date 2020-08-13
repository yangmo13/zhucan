package com.sloth.sys.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.sloth.model.Data;
import com.sloth.service.DataService;

public class DataController extends Controller {
	private DataService dataService = Aop.get(DataService.class);

	@RequiresPermissions("data:list")
	public void index() {
		render("data_list.html");
	}

	@RequiresPermissions("data:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, String name, String code) {
		Page<Data> datas = dataService.find(name, code, pageNo, pageCount);
		renderJson(new TableData(datas.getTotalRow(), datas.getList()));
	}

	@RequiresPermissions(value = { "data:edit", "data:add" }, logical = Logical.OR)
	public void goAddOrEdit(String id) {
		if (id != null) {
			this.setAttr("data", dataService.findById(id));
		}
		render("data_edit.html");
	}

	@RequiresPermissions("data:edit")
	public void edit(Data data) {
		dataService.update(data);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("data:add")
	public void add(Data data) {
		dataService.add(data);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("data:del")
	public void del(String id) {
		dataService.del(id);
		renderJson(new AjaxData());
	}
}