package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseContent<M extends BaseContent<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("type","TYPE");
		mappings.put("title","TITLE");
		mappings.put("txt","TXT");
		mappings.put("registerOrgId","REGISTER_ORG_ID");
		mappings.put("registerOrgName","REGISTER_ORG_NAME");
		mappings.put("registerId","REGISTER_ID");
		mappings.put("registerName","REGISTER_NAME");
		mappings.put("registTime","REGIST_TIME");
		mappings.put("submitorOrgId","SUBMITOR_ORG_ID");
		mappings.put("submitorOrgName","SUBMITOR_ORG_NAME");
		mappings.put("submitorId","SUBMITOR_ID");
		mappings.put("submitorName","SUBMITOR_NAME");
		mappings.put("submitTime","SUBMIT_TIME");
		mappings.put("auditorOrgId","AUDITOR_ORG_ID");
		mappings.put("auditorOrgName","AUDITOR_ORG_NAME");
		mappings.put("auditorId","AUDITOR_ID");
		mappings.put("auditorName","AUDITOR_NAME");
		mappings.put("auditTime","AUDIT_TIME");
		mappings.put("status","STATUS");
		mappings.put("auditRemark","AUDIT_REMARK");
		mappings.put("deleted","DELETED");
		mappings.put("visible","VISIBLE");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_content";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setType(java.lang.String type) {
		set("TYPE", type);
	}
	
	public java.lang.String getType() {
		return getStr("TYPE");
	}

	public void setTitle(java.lang.String title) {
		set("TITLE", title);
	}
	
	public java.lang.String getTitle() {
		return getStr("TITLE");
	}

	public void setTxt(java.lang.String txt) {
		set("TXT", txt);
	}
	
	public java.lang.String getTxt() {
		return getStr("TXT");
	}

	public void setRegisterOrgId(java.lang.Long registerOrgId) {
		set("REGISTER_ORG_ID", registerOrgId);
	}
	
	public java.lang.Long getRegisterOrgId() {
		return getLong("REGISTER_ORG_ID");
	}

	public void setRegisterOrgName(java.lang.String registerOrgName) {
		set("REGISTER_ORG_NAME", registerOrgName);
	}
	
	public java.lang.String getRegisterOrgName() {
		return getStr("REGISTER_ORG_NAME");
	}

	public void setRegisterId(java.lang.String registerId) {
		set("REGISTER_ID", registerId);
	}
	
	public java.lang.String getRegisterId() {
		return getStr("REGISTER_ID");
	}

	public void setRegisterName(java.lang.String registerName) {
		set("REGISTER_NAME", registerName);
	}
	
	public java.lang.String getRegisterName() {
		return getStr("REGISTER_NAME");
	}

	public void setRegistTime(java.util.Date registTime) {
		set("REGIST_TIME", registTime);
	}
	
	public java.util.Date getRegistTime() {
		return get("REGIST_TIME");
	}

	public void setSubmitorOrgId(java.lang.Long submitorOrgId) {
		set("SUBMITOR_ORG_ID", submitorOrgId);
	}
	
	public java.lang.Long getSubmitorOrgId() {
		return getLong("SUBMITOR_ORG_ID");
	}

	public void setSubmitorOrgName(java.lang.String submitorOrgName) {
		set("SUBMITOR_ORG_NAME", submitorOrgName);
	}
	
	public java.lang.String getSubmitorOrgName() {
		return getStr("SUBMITOR_ORG_NAME");
	}

	public void setSubmitorId(java.lang.String submitorId) {
		set("SUBMITOR_ID", submitorId);
	}
	
	public java.lang.String getSubmitorId() {
		return getStr("SUBMITOR_ID");
	}

	public void setSubmitorName(java.lang.String submitorName) {
		set("SUBMITOR_NAME", submitorName);
	}
	
	public java.lang.String getSubmitorName() {
		return getStr("SUBMITOR_NAME");
	}

	public void setSubmitTime(java.util.Date submitTime) {
		set("SUBMIT_TIME", submitTime);
	}
	
	public java.util.Date getSubmitTime() {
		return get("SUBMIT_TIME");
	}

	public void setAuditorOrgId(java.lang.Long auditorOrgId) {
		set("AUDITOR_ORG_ID", auditorOrgId);
	}
	
	public java.lang.Long getAuditorOrgId() {
		return getLong("AUDITOR_ORG_ID");
	}

	public void setAuditorOrgName(java.lang.String auditorOrgName) {
		set("AUDITOR_ORG_NAME", auditorOrgName);
	}
	
	public java.lang.String getAuditorOrgName() {
		return getStr("AUDITOR_ORG_NAME");
	}

	public void setAuditorId(java.lang.String auditorId) {
		set("AUDITOR_ID", auditorId);
	}
	
	public java.lang.String getAuditorId() {
		return getStr("AUDITOR_ID");
	}

	public void setAuditorName(java.lang.String auditorName) {
		set("AUDITOR_NAME", auditorName);
	}
	
	public java.lang.String getAuditorName() {
		return getStr("AUDITOR_NAME");
	}

	public void setAuditTime(java.util.Date auditTime) {
		set("AUDIT_TIME", auditTime);
	}
	
	public java.util.Date getAuditTime() {
		return get("AUDIT_TIME");
	}

	public void setStatus(java.lang.String status) {
		set("STATUS", status);
	}
	
	public java.lang.String getStatus() {
		return getStr("STATUS");
	}

	public void setAuditRemark(java.lang.String auditRemark) {
		set("AUDIT_REMARK", auditRemark);
	}
	
	public java.lang.String getAuditRemark() {
		return getStr("AUDIT_REMARK");
	}

	public void setDeleted(java.lang.Integer deleted) {
		set("DELETED", deleted);
	}
	
	public java.lang.Integer getDeleted() {
		return getInt("DELETED");
	}

	public void setVisible(java.lang.Integer visible) {
		set("VISIBLE", visible);
	}
	
	public java.lang.Integer getVisible() {
		return getInt("VISIBLE");
	}

}
