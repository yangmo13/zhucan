package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseWorkExper<M extends BaseWorkExper<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("refId","REF_ID");
		mappings.put("companyName","COMPANY_NAME");
		mappings.put("post","POST");
		mappings.put("fromDate","FROM_DATE");
		mappings.put("endDate","END_DATE");
		mappings.put("duty","DUTY");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_work_exper";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setRefId(java.lang.Long refId) {
		set("REF_ID", refId);
	}
	
	public java.lang.Long getRefId() {
		return getLong("REF_ID");
	}

	public void setCompanyName(java.lang.String companyName) {
		set("COMPANY_NAME", companyName);
	}
	
	public java.lang.String getCompanyName() {
		return getStr("COMPANY_NAME");
	}

	public void setPost(java.lang.String post) {
		set("POST", post);
	}
	
	public java.lang.String getPost() {
		return getStr("POST");
	}

	public void setFromDate(java.util.Date fromDate) {
		set("FROM_DATE", fromDate);
	}
	
	public java.util.Date getFromDate() {
		return get("FROM_DATE");
	}

	public void setEndDate(java.util.Date endDate) {
		set("END_DATE", endDate);
	}
	
	public java.util.Date getEndDate() {
		return get("END_DATE");
	}

	public void setDuty(java.lang.String duty) {
		set("DUTY", duty);
	}
	
	public java.lang.String getDuty() {
		return getStr("DUTY");
	}

}
