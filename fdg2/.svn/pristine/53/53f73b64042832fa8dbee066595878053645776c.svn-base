package com.sloth.sys.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Dict;
import com.sloth.service.DictService;

public class DictController extends Controller {
	private DictService dictService = Aop.get(DictService.class);

	@RequiresPermissions("dict:list")
	public void index(Integer pid) {
		if (pid != null) {
			this.setAttr("parent", dictService.findById(pid));
		}
		render("dict_list.html");
	}

	@RequiresPermissions("dict:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, Integer pid, String title, String code) {
		Page<Dict> dicts = dictService.find(pid, title, code, pageNo, pageCount);
		renderJson(new TableData(dicts.getTotalRow(), dicts.getList()));
	}
	
	@RequiresPermissions(value = { "dict:edit", "dict:add" }, logical = Logical.OR)
	public void goAddOrEdit(Integer id, Integer pid) {
		if (id != null) {
			this.setAttr("dict", dictService.findById(id));
		}
		if (pid != null) {
			this.setAttr("parent", dictService.findById(pid));
		}
		render("dict_edit.html");
	}
	
	@RequiresPermissions("user:edit")
	public void edit(Dict dict) {
		dictService.update(dict);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("user:add")
	public void add(Dict dict) {
		dictService.add(dict);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("user:del")
	public void del(String id) {
		AjaxData ajaxData = new AjaxData();
		try {
			dictService.del(id);
		} catch (SlothException e) {
			ajaxData.setCode(e.getCode());
		}
		renderJson(ajaxData);
	}
	
	@RequiresPermissions("dict:move")
	public void move(String id, int direct) {
		dictService.move(id, direct);;
		renderJson(new AjaxData());
	}
}