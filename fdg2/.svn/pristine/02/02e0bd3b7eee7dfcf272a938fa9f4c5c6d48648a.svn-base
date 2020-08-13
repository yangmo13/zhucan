package com.fdp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.fdp.model.ContentTmp;
import com.fdp.service.ContentTmpService;
import com.sloth.sys.util.DataFilterKit;

public class ContentTmpController extends Controller {
	private ContentTmpService contentTmpService = Aop.get(ContentTmpService.class);

	@RequiresPermissions("contentTmp:list")
	public void index() {
		render("contentTmp_list.html");
	}

	@RequiresPermissions("contentTmp:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") ContentTmp contentTmp) {
		Page<ContentTmp> contentTmps = contentTmpService.find(contentTmp, pageNo, pageCount, DataFilterKit.get("contentTmp"));
		renderJson(new TableData(contentTmps.getTotalRow(), contentTmps.getList()));
	}

	@RequiresPermissions("contentTmp:add")
	public void goAdd() {
		render("contentTmp_edit.html");
	}
	
	@RequiresPermissions("contentTmp:edit")
	public void goEdit(String id) {
		if (id != null) {
			this.setAttr("contentTmp", contentTmpService.findById(id));
		}
		render("contentTmp_edit.html");
	}

	@RequiresPermissions("contentTmp:edit")
	public void edit(ContentTmp contentTmp) {
		contentTmpService.update(contentTmp);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("contentTmp:add")
	public void add(ContentTmp contentTmp) {
		contentTmpService.save(contentTmp);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("contentTmp:del")
	public void del(String id) {
		contentTmpService.del(id);
		renderJson(new AjaxData());
	}
}