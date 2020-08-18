package com.fdp.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.fdp.common.CommonService;
import com.fdp.model.ArticleTmp;
import com.fdp.model.ContentTmp;
import com.fdp.model.OrgTmp;
import com.fdp.model.TUser;
import com.fdp.service.ContentTmpService;
import com.fdp.service.OrgTmpService;
import com.fdp.service.TUserService;
import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbTemplate;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;

import com.sloth.model.Dept;
import com.sloth.service.DeptService;
import com.fdp.model.ContentTmp;
import com.fdp.service.ContentTmpService;
import com.sloth.sys.util.CtxUtil;
import com.sloth.sys.util.DataFilterKit;

public class ContentTmpController extends Controller {
	private ContentTmpService contentTmpService = Aop.get(ContentTmpService.class);
	
	private OrgTmpService orgTmpService = Aop.get(OrgTmpService.class);
	
	private DeptService deptService = new DeptService();
	
	private CommonController common =new CommonController();
	
	private Dept dept = new Dept();
	
	private TUserService sUserService = new TUserService();

	@RequiresPermissions("contentTmp:list")
	public void index() {
		render("contentTmp_list.html");
	}


	/**
	 * 内容列表
	 * @param pageNo
	 * @param pageCount
	 * @param contentTmp
	 * @param articleTmp
	 */

	@RequiresPermissions("contentTmp:list")
	public void find(@Para("page") int pageNo, @Para("limit") int pageCount, @Para("") ContentTmp contentTmp) {
		//Page<ContentTmp> contentTmps = contentTmpService.find(contentTmp, pageNo, pageCount, DataFilterKit.get("contentTmp"));
		Map<String,String> data =new HashMap<String,String>(){{
			put("title",getPara("title"));
			put("status",getPara("status"));
		}};
		Page<Record> contentTmps = Db.template("contentTmp.list", data).paginate(pageNo, pageCount);
		List<Record> list = contentTmps.getList();
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
			this.setAttr("orgTmp", orgTmpService.findById(id));
		}
		render("contentTmp_edit.html");
	}


	/**
	 * 内容修改
	 * @param contentTmp
	 */

	@RequiresPermissions("contentTmp:edit")
	public void edit(ContentTmp contentTmp,OrgTmp orgTop) {
		orgTop.setId(contentTmp.getId());
		contentTmpService.update(contentTmp);
		Dept dept = deptService.findById(orgTop.getRefDeptId());
		dept.setTitle(contentTmp.getTitle());
		deptService.update(dept);
		// 同时根据机构分配账号，在用户表中更新用户
		TUser tUser =new TUser();
		tUser.setId(contentTmp.getId().toString());
		tUser.setUsername(orgTop.getUsername());
		tUser.setRealname(contentTmp.getTitle());
		tUser.setDeptId(orgTop.getRefDeptId());
		tUser.setOrgId(orgTop.getId());
		sUserService.update(tUser);
		orgTmpService.update(orgTop);
		renderJson(new AjaxData());
	}
	/**
	 * 内容添加
	 * @param contentTmp
	 */
	@RequiresPermissions("contentTmp:add")

	public void add(ContentTmp contentTmp,OrgTmp orgTop) {
		contentTmp.setRegisterOrgName(contentTmp.getTitle());
		contentTmpService.save(contentTmp, CtxUtil.getCurrentUser());
		orgTop.setId(contentTmp.getId());
		orgTop.setRefUserId(contentTmp.getId().toString());
		dept.setOpUserId(CtxUtil.getCurrentUser().getId());
		dept.setTitle(contentTmp.getTitle());
		dept.setPid("0");
		deptService.add(dept);
		orgTop.setRefDeptId(dept.getId());
		// 同时根据机构分配账号，在用户表中添加新用户
		TUser tUser =new TUser();
		String id = contentTmp.getId().toString();
		tUser.setId(id);
		tUser.setUsername(orgTop.getUsername());
		tUser.setPassword("admin");
		tUser.setStatus(1);
		tUser.setEditable(1);
		tUser.setDeleted(0);
		tUser.setRealname(contentTmp.getTitle());
		tUser.setOpTime(new Date());
		tUser.setDeptId(orgTop.getRefDeptId());
		tUser.setOrgId(orgTop.getId());
		sUserService.save(tUser);
		String roles = orgTop.getRoles();
		orgTmpService.save(orgTop);
		renderJson(new AjaxData());
	}

	/**
	 * 内容删除
	 * @param id
	 */
	@RequiresPermissions("contentTmp:del")
	public void del(String id) {
		contentTmpService.del(id);
		renderJson(new AjaxData());
	}

	public void map() {
		render("contentTmp_map.html");
	}

	/**
	 * 上传LOGO
	 */
	public void upload() {
		UploadFile file = getFile();
		String filePath = CommonService.uploadFile(file);
		Map<String,String> map =new HashMap<String,String>(){{
			put("filePath",filePath);
			put("code","0");
		}};
		renderJson(map);
	}
	/**
	 * 上传LOGO
	 */
	public void uploadimg() {
		UploadFile file = getFile();
		String filePath = CommonService.uploadFile(file);
		renderText(filePath);
	}
	
	/**
	 * 详情页面
	 */
	@RequiresPermissions("contentTmp:view")
	public void goContentDetil(Integer id,String type) {
		if(id!=null) {
			ContentTmp contentTmp = contentTmpService.findById(id);
			OrgTmp orgTmp = orgTmpService.findById(id);
			this.setAttr("id", id);
			this.setAttr("contentTmp", contentTmp);
			this.setAttr("orgTmp", orgTmp);
		}
		render("contentDetil.html");
	}
}