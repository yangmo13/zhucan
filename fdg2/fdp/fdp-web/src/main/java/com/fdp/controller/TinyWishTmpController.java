package com.fdp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.fdp.model.ContentTmp;
import com.fdp.model.TinyWishTmp;
import com.fdp.service.TinyWishTmpService;
import com.sloth.sys.util.DataFilterKit;

public class TinyWishTmpController extends Controller {
	private TinyWishTmpService tinyWishTmpService = Aop.get(TinyWishTmpService.class);

	@RequiresPermissions("tinyWishTmp:list")
	public void index() {
		render("tinyWishTmp_list.html");
	}

	@RequiresPermissions("tinyWishTmp:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") TinyWishTmp tinyWishTmp, @Para("") ContentTmp contentTmp) {
		Page<TinyWishTmp> tinyWishTmps = tinyWishTmpService.find(tinyWishTmp,contentTmp, pageNo, pageCount, DataFilterKit.get("tinyWishTmp"));
		renderJson(new TableData(tinyWishTmps.getTotalRow(), tinyWishTmps.getList()));
	}

	@RequiresPermissions("tinyWishTmp:add")
	public void goAdd() {
		render("tinyWishTmp_edit.html");
	}
	
	@RequiresPermissions("tinyWishTmp:edit")
	public void goEdit(String id) {
		if (id != null) {
			this.setAttr("tinyWishTmp", tinyWishTmpService.findById(id));
		}
		render("tinyWishTmp_edit.html");
	}

	@RequiresPermissions("tinyWishTmp:edit")
	public void edit(TinyWishTmp tinyWishTmp) {
		tinyWishTmpService.update(tinyWishTmp);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("tinyWishTmp:add")
	public void add(TinyWishTmp tinyWishTmp) {
		tinyWishTmpService.save(tinyWishTmp);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("tinyWishTmp:del")
	public void del(String id) {
		tinyWishTmpService.del(id);
		renderJson(new AjaxData());
	}
	
	/**
	 * 详情页面
	 */
	@RequiresPermissions("tinyWishTmp:detail")
	public void goDetail(Integer id) {
		if(id!=null) {
			Record findById = tinyWishTmpService.findById(id);
			this.setAttr("id", id);
			this.setAttr("tinyWishTmp", findById);
		}
		render("tinyWishTmp_detil.html");
	}
}