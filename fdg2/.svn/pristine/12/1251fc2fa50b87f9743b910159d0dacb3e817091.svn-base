package com.fdp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.fdp.model.TinyWish;
import com.fdp.service.TinyWishService;
import com.sloth.sys.util.DataFilterKit;

public class TinyWishController extends Controller {
	private TinyWishService tinyWishService = Aop.get(TinyWishService.class);

	@RequiresPermissions("tinyWish:list")
	public void index() {
		render("tinyWish_list.html");
	}

	@RequiresPermissions("tinyWish:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") TinyWish tinyWish) {
		Page<TinyWish> tinyWishs = tinyWishService.find(tinyWish, pageNo, pageCount, DataFilterKit.get("tinyWish"));
		renderJson(new TableData(tinyWishs.getTotalRow(), tinyWishs.getList()));
	}

	@RequiresPermissions("tinyWish:add")
	public void goAdd() {
		render("tinyWish_edit.html");
	}
	
	@RequiresPermissions("tinyWish:edit")
	public void goEdit(String id) {
		if (id != null) {
			this.setAttr("tinyWish", tinyWishService.findById(id));
		}
		render("tinyWish_edit.html");
	}

	@RequiresPermissions("tinyWish:edit")
	public void edit(TinyWish tinyWish) {
		tinyWishService.update(tinyWish);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("tinyWish:add")
	public void add(TinyWish tinyWish) {
		tinyWishService.save(tinyWish);
		renderJson(new AjaxData());
	}

	@RequiresPermissions("tinyWish:del")
	public void del(String id) {
		tinyWishService.del(id);
		renderJson(new AjaxData());
	}
}