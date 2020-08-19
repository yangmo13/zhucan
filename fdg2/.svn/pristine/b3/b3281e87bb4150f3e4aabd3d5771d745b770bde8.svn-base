package com.fdp.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;
import com.fdp.common.CommonService;
import com.fdp.model.ArticleTmp;
import com.fdp.model.ContentTmp;
import com.fdp.model.DocumentTmp;
import com.fdp.service.DocumentTmpService;
import com.sloth.sys.util.CtxUtil;
import com.sloth.sys.util.DataFilterKit;

public class DocumentTmpController extends Controller {
	private DocumentTmpService documentTmpService = Aop.get(DocumentTmpService.class);

	
	/**
	 * 康复资料跳转页面
	 */
	@RequiresPermissions("documentTmp:view")
	public void recoveryMeansHref() {
		render("recoveryMeans/recoveryMeans_list.html");
	}
	/**
	 * 示范资料跳转页面
	 */
	@RequiresPermissions("documentTmp:view")
	public void demonstrationMeansHref() {
		render("demonstrationMeans/demonstrationMeans_list.html");
	}
	/**
	 * 编辑跳转页面
	 * @param id
	 */
	@RequiresPermissions("documentTmp:edit")
	public void goEdit(Integer id,String type) {
		if (id != null) {
			this.setAttr("documentTmp", documentTmpService.findById(id));
		}
		if(type!=null) {
			this.setAttr("type", type);
		}
		render("contentEdit/contentEdit.html");
	}
	/**
	 * 跳转详情页面
	 * @param id
	 * @param type
	 */
	@RequiresPermissions("documentTmp:view")
	public void goContentDetil(Integer id,String type) {
		if (id != null) {
			this.setAttr("documentTmp", documentTmpService.findById(id));
		}
		if(type!=null) {
			this.setAttr("type", type);
		}
		render("contentDetil/contentDetil.html");
	}
	/**
	 * 列表
	 * @param pageNo
	 * @param pageCount
	 * @param contentTmp
	 * @param documentTmp
	 */
	@RequiresPermissions("documentTmp:list")
	public void find(String type,@Para("page") int pageNo, @Para("limit") int pageCount,@Para("") ContentTmp contentTmp,@Para("") DocumentTmp documentTmp) {
		Page<Record> documentTmps = documentTmpService.find(documentTmp,contentTmp, pageNo, pageCount,type);
		renderJson(new TableData(documentTmps.getTotalRow(), documentTmps.getList()));
	}
	/**
	 * 修改
	 * @param documentTmp
	 */
	@RequiresPermissions("documentTmp:edit")
	public void update(DocumentTmp documentTmp) {
		documentTmpService.update(documentTmp);
		renderJson(new AjaxData());
	}
	/**
	 * 添加
	 * @param documentTmp
	 */
	@RequiresPermissions("documentTmp:add")
	public void add() {
		List<UploadFile> files = getFiles();
		DocumentTmp documentTmp = getModel(DocumentTmp.class,"documentTmp");
		ContentTmp contentTmp = getModel(ContentTmp.class,"contentTmp");
		documentTmpService.save(files,contentTmp,documentTmp,CtxUtil.getCurrentUser());
		renderJson(new AjaxData());
	}
	/**
	 * 删除
	 * @param id
	 */
	@RequiresPermissions("documentTmp:del")
	public void del(String id) {
		documentTmpService.del(id);
		renderJson(new AjaxData());
	}
	/**
	 * 上传图片
	 */
	public void upload() {
		UploadFile file = getFile();
		String filePath = CommonService.uploadFile(file);
		renderText(filePath);
	}
}