package com.fdp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.fdp.model.OrgTmp;
import com.fdp.service.OrgTmpService;
import com.sloth.sys.util.DataFilterKit;

public class OrgTmpController extends Controller {
	private OrgTmpService orgTmpService = Aop.get(OrgTmpService.class);

	@RequiresPermissions("orgTmp:list")
	public void index() {
		render("orgTmp_list.html");
	}

	@RequiresPermissions("orgTmp:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") OrgTmp orgTmp) {
		Page<OrgTmp> orgTmps = orgTmpService.find(orgTmp, pageNo, pageCount, DataFilterKit.get("orgTmp"));
		renderJson(new TableData(orgTmps.getTotalRow(), orgTmps.getList()));
	}

	@RequiresPermissions("orgTmp:add")
	public void goAdd() {
		render("orgTmp_edit.html");
	}
	
	@RequiresPermissions("orgTmp:edit")
	public void goEdit(String id) {
		if (id != null) {
			this.setAttr("orgTmp", orgTmpService.findById(id));
		}
		render("orgTmp_edit.html");
	}

	@RequiresPermissions("orgTmp:edit")
	public void edit(OrgTmp orgTmp) {
		orgTmpService.update(orgTmp);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("orgTmp:add")
	public void add(OrgTmp orgTmp) {
		orgTmpService.save(orgTmp);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("orgTmp:del")
	public void del(String id) {
		orgTmpService.del(id);
		renderJson(new AjaxData());
	}
}