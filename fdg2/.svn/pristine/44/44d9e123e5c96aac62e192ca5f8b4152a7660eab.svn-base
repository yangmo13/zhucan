package com.fdp.controller;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.sloth.model.Dict;
import com.sloth.service.DictService;
import com.sloth.service.UserService;
import com.fdp.model.Archive;
import com.fdp.service.ArchiveService;
import com.sloth.sys.util.DataFilterKit;

public class ArchiveController extends Controller {
	private ArchiveService archiveService = Aop.get(ArchiveService.class);
	private DictService dictService = Aop.get(DictService.class);

	@RequiresPermissions("archive:list")
	public void index() {
		render("archive_list.html");
	}

	@RequiresPermissions("archive:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") Archive archive) {
		Page<Archive> archives = archiveService.find(archive, pageNo, pageCount, DataFilterKit.get("archive"));
		renderJson(new TableData(archives.getTotalRow(), archives.getList()));
	}

	@RequiresPermissions(value = { "archive:edit", "archive:add" }, logical = Logical.OR)
	public void goAddOrEdit(String id) {
		if (id != null) {
			//获取所有选中的残疾类型，存在实体DisabilityType
			this.setAttr("checked_disabilityType", archiveService.findDisabilityTypeListByID(id));
			
			this.setAttr("archive", archiveService.findById(id));
		}
		
		//为残疾类型CheckBox赋值
		Dict dict=dictService.findByCode("fdp.disabilityType");
		String pid=dict.getId().toString();
		this.setAttr("all_disabilityType", dictService.findListByPID(pid));
		
		render("archive_edit.html");
	}
	
	@RequiresPermissions("archive:add")
	public void goAdd() {
		Dict dict=dictService.findByCode("fdp.disabilityType");
		String pid=dict.getId().toString();
		this.setAttr("all_disabilityType", dictService.findListByPID(pid));

		render("archive_edit.html");
	}
	
	@RequiresPermissions("archive:edit")
	public void goEdit(String id) {
		if (id != null) {
			this.setAttr("archive", archiveService.findById(id));
		}
		render("archive_edit.html");
	}

	@RequiresPermissions("archive:edit")
	public void edit(Archive archive) {
		archiveService.update(archive);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("archive:add")
	public void add(Archive archive,String disabilityTypeCodes) {
		archiveService.save(archive,disabilityTypeCodes);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("archive:del")
	public void del(String id) {
		archiveService.del(id);
		renderJson(new AjaxData());
	}
}