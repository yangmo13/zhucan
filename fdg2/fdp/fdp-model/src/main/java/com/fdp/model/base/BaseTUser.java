package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseTUser<M extends BaseTUser<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("username","USERNAME");
		mappings.put("password","PASSWORD");
		mappings.put("status","STATUS");
		mappings.put("editable","EDITABLE");
		mappings.put("deletable","DELETABLE");
		mappings.put("deleted","DELETED");
		mappings.put("realname","REALNAME");
		mappings.put("sex","SEX");
		mappings.put("opTime","OP_TIME");
		mappings.put("opUserId","OP_USER_ID");
		mappings.put("deptId","DEPT_ID");
		mappings.put("startTime","START_TIME");
		mappings.put("endTime","END_TIME");
		mappings.put("token","TOKEN");
		mappings.put("phone","PHONE");
		mappings.put("refArchiveId","REF_ARCHIVE_ID");
		mappings.put("refResumeId","REF_RESUME_ID");
		mappings.put("infoCompleted","INFO_COMPLETED");
		mappings.put("openid","OPENID");
		mappings.put("orgId","ORG_ID");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_user";
	}

	public void setId(java.lang.String id) {
		set("ID", id);
	}
	
	public java.lang.String getId() {
		return getStr("ID");
	}

	public void setUsername(java.lang.String username) {
		set("USERNAME", username);
	}
	
	public java.lang.String getUsername() {
		return getStr("USERNAME");
	}

	public void setPassword(java.lang.String password) {
		set("PASSWORD", password);
	}
	
	public java.lang.String getPassword() {
		return getStr("PASSWORD");
	}

	public void setStatus(java.lang.Integer status) {
		set("STATUS", status);
	}
	
	public java.lang.Integer getStatus() {
		return getInt("STATUS");
	}

	public void setEditable(java.lang.Integer editable) {
		set("EDITABLE", editable);
	}
	
	public java.lang.Integer getEditable() {
		return getInt("EDITABLE");
	}

	public void setDeletable(java.lang.Integer deletable) {
		set("DELETABLE", deletable);
	}
	
	public java.lang.Integer getDeletable() {
		return getInt("DELETABLE");
	}

	public void setDeleted(java.lang.Integer deleted) {
		set("DELETED", deleted);
	}
	
	public java.lang.Integer getDeleted() {
		return getInt("DELETED");
	}

	public void setRealname(java.lang.String realname) {
		set("REALNAME", realname);
	}
	
	public java.lang.String getRealname() {
		return getStr("REALNAME");
	}

	public void setSex(java.lang.Integer sex) {
		set("SEX", sex);
	}
	
	public java.lang.Integer getSex() {
		return getInt("SEX");
	}

	public void setOpTime(java.util.Date opTime) {
		set("OP_TIME", opTime);
	}
	
	public java.util.Date getOpTime() {
		return get("OP_TIME");
	}

	public void setOpUserId(java.lang.String opUserId) {
		set("OP_USER_ID", opUserId);
	}
	
	public java.lang.String getOpUserId() {
		return getStr("OP_USER_ID");
	}

	public void setDeptId(java.lang.String deptId) {
		set("DEPT_ID", deptId);
	}
	
	public java.lang.String getDeptId() {
		return getStr("DEPT_ID");
	}

	public void setStartTime(java.util.Date startTime) {
		set("START_TIME", startTime);
	}
	
	public java.util.Date getStartTime() {
		return get("START_TIME");
	}

	public void setEndTime(java.util.Date endTime) {
		set("END_TIME", endTime);
	}
	
	public java.util.Date getEndTime() {
		return get("END_TIME");
	}

	public void setToken(java.lang.String token) {
		set("TOKEN", token);
	}
	
	public java.lang.String getToken() {
		return getStr("TOKEN");
	}

	public void setPhone(java.lang.String phone) {
		set("PHONE", phone);
	}
	
	public java.lang.String getPhone() {
		return getStr("PHONE");
	}

	public void setRefArchiveId(java.lang.Long refArchiveId) {
		set("REF_ARCHIVE_ID", refArchiveId);
	}
	
	public java.lang.Long getRefArchiveId() {
		return getLong("REF_ARCHIVE_ID");
	}

	public void setRefResumeId(java.lang.Long refResumeId) {
		set("REF_RESUME_ID", refResumeId);
	}
	
	public java.lang.Long getRefResumeId() {
		return getLong("REF_RESUME_ID");
	}

	public void setInfoCompleted(java.lang.Integer infoCompleted) {
		set("INFO_COMPLETED", infoCompleted);
	}
	
	public java.lang.Integer getInfoCompleted() {
		return getInt("INFO_COMPLETED");
	}

	public void setOpenid(java.lang.String openid) {
		set("OPENID", openid);
	}
	
	public java.lang.String getOpenid() {
		return getStr("OPENID");
	}

	public void setOrgId(java.lang.Long orgId) {
		set("ORG_ID", orgId);
	}
	
	public java.lang.Long getOrgId() {
		return getLong("ORG_ID");
	}

}
