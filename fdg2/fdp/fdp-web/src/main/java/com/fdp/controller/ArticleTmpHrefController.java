package com.fdp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;

import com.jfinal.plugin.activerecord.Record;
/**
 * 内容管理 页面跳转 controller
 * type说明
 * C201 通知公告
 * C202 工作动态
 * C203 政策法规
 * C204 党建工作
 * C205 组织机构
 * C206 业务指南
 * @author 郭翔宇
 *
 */
public class ArticleTmpHrefController extends ArticleTmpController{

	/**
	 * 通知公告
	 */
	@RequiresPermissions("articleTmp:list")
	public void notice() {
		render("notice/notice.html");
	}
	/**
	 * 添加-编辑 通知公告
	 */
	@RequiresPermissions("articleTmp:Edit")
	public void goNoticeEdit(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		render("notice/noticeEdit.html");
	}
	
	/**
	 * 工作动态
	 */
	@RequiresPermissions("contentTmp:list")
	public void work() {
		render("work/work.html");
	}
	/**
	 * 添加-编辑工作动态
	 */
	@RequiresPermissions("contentTmp:Edit")
	public void goWorkEdit(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		render("work/workEdit.html");
	}
	
	/**
	 * 政策法规
	 */
	@RequiresPermissions("articleTmp:list")
	public void policy() {
		render("policy/policy.html");
	}
	/**
	 * 添加-编辑政策法规
	 */
	@RequiresPermissions("articleTmp:Edit")
	public void goPolicyEdit(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		render("policy/policyEdit.html");
	}
	
	/**
	 * 党建工作
	 */
	@RequiresPermissions("contentTmp:list")
	public void building() {
		render("building/building.html");
	}
	/**
	 * 添加党建工作
	 */
	@RequiresPermissions("contentTmp:Edit")
	public void goBuildingEdit(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		render("building/buildingEdit.html");
	}
	
	/**
	 * 业务指南
	 */
	@RequiresPermissions("articleTmp:list")
	public void service() {
		render("service/service.html");
	}
	/**
	 * 添加业务指南
	 */
	@RequiresPermissions("articleTmp:Edit")
	public void goServiceEdit(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		render("service/serviceEdit.html");
	}
	
	/**
	 * 组织机构
	 */
	@RequiresPermissions("articleTmp:view")
	public void organize() {
		String type= "C205";
		Record findById = super.articleTmpService.findById(null,type);
		this.setAttr("articleTmp", findById);
		this.setAttr("id", findById.get("ID"));
		this.setAttr("path", "goOrganizeEdit");
		render("contentDetil.html");
	}
	/**
	 * 添加组织机构
	 */
	@RequiresPermissions("articleTmp:Edit")
	public void goOrganizeEdit(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		render("organize/organizeEdit.html");
	}
	
	/**
	 * 详情页面
	 */
	@RequiresPermissions("articleTmp:view")
	public void goContentDetil(Integer id,String type) {
		if(id!=null) {
			Record findById = super.articleTmpService.findById(id,type);
			this.setAttr("id", id);
			this.setAttr("articleTmp", findById);
		}
		switch(type){
	    case "C201" :
	        this.setAttr("path", "goNoticeEdit");
	       break;
	    case "C202" :
	    	this.setAttr("path", "goWorkEdit");
	       break;
	    case "C203" :
	    	this.setAttr("path", "goPolicyEdit");
	    	break;
	    case "C204" :
	    	this.setAttr("path", "goBuildingEdit");
	    	break;
	    case "C205" :
	    	this.setAttr("path", "goOrganizeEdit");
	    	break;
	    case "C206" :
	    	this.setAttr("path", "goServiceEdit");
	    	break;
		}
		render("contentDetil.html");
	}
}
