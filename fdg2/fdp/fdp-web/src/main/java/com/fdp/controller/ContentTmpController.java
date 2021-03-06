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
import com.fdp.service.ContentTmpService;
import com.fdp.service.OrgTmpService;
import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.DbTemplate;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.sloth.common.AjaxData;
import com.sloth.common.TableData;

import com.sloth.model.Dept;
import com.sloth.model.Role;
import com.sloth.model.RoleUser;
import com.sloth.model.User;
import com.sloth.service.ConfigService;
import com.sloth.service.DeptService;
import com.sloth.service.RoleService;
import com.sloth.service.UserService;
import com.fdp.model.ContentTmp;
import com.fdp.service.ContentTmpService;
import com.sloth.sys.util.CtxUtil;
import com.sloth.sys.util.DataFilterKit;
import com.sloth.util.PwdKit;
import com.sloth.util.StringKit;

public class ContentTmpController extends Controller {
	private ContentTmpService contentTmpService = Aop.get(ContentTmpService.class);
	
	private OrgTmpService orgTmpService = Aop.get(OrgTmpService.class);
	
	private DeptService deptService = Aop.get(DeptService.class); 
	
	private CommonController common =Aop.get(CommonController.class); 
	
	private Dept dept = new Dept();
	
	private RoleService  roleService = Aop.get(RoleService.class); 
	
	private ConfigService configService = Aop.get(ConfigService.class);

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
		contentTmpService.update(contentTmp,CtxUtil.getCurrentUser());
		Dept dept = deptService.findById(orgTop.getRefDeptId());
		dept.setTitle(contentTmp.getTitle());
		deptService.update(dept);
		// 同时根据机构分配账号，在用户表中更新用户
		User User =new User();
		User.setId(contentTmp.getId().toString());
		User.setUsername(orgTop.getUsername());
		User.setRealname(contentTmp.getTitle());
		User.setDeptId(orgTop.getRefDeptId());
		User.setOrgId(orgTop.getId());
		User.update();
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
		User user =new User();
		String id = contentTmp.getId().toString();
		user.setId(id);
		user.setUsername(orgTop.getUsername());
		user.setPassword(PwdKit.encrypt(user.getUsername(), configService.findValueByCode("user.defaultPwd")));
		user.setStatus(1);
		user.setEditable(1);
		user.setDeleted(0);
		user.setRealname(contentTmp.getTitle());
		user.setOpTime(new Date());
		user.setDeptId(orgTop.getRefDeptId());
		user.setOrgId(orgTop.getId());
		addRole(orgTop,user);
		user.save();
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
	public void addRole(OrgTmp orgTop,User user) {
		String roles = orgTop.getRoles();
		
		if (StringKit.isEmpty(roles)) {
			return;
		}
		List<Role> roleAll = roleService.findAll();
		RoleUser roleUser = new RoleUser();
		String[] roleIds = roles.split(",");
		for (String roleId : roleIds) {
			for (Role role : roleAll) {
				String string = PropKit.get(roleId);
			if (PropKit.get(roleId).equals(role.getCode())) {
				roleUser.setId(UUID.randomUUID().toString());
				roleUser.setRoleId(role.getId());
				roleUser.setUserId(user.getId());
				roleUser.save();
				break;
			}
			}
			
			
		}
	}
}