package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseEduExper<M extends BaseEduExper<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("refId","REF_ID");
		mappings.put("schoolName","SCHOOL_NAME");
		mappings.put("fromDate","FROM_DATE");
		mappings.put("endDate","END_DATE");
		mappings.put("edu","EDU");
		mappings.put("unified","UNIFIED");
		mappings.put("major","MAJOR");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_edu_exper";
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

	public void setSchoolName(java.lang.String schoolName) {
		set("SCHOOL_NAME", schoolName);
	}
	
	public java.lang.String getSchoolName() {
		return getStr("SCHOOL_NAME");
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

	public void setEdu(java.lang.String edu) {
		set("EDU", edu);
	}
	
	public java.lang.String getEdu() {
		return getStr("EDU");
	}

	public void setUnified(java.lang.Integer unified) {
		set("UNIFIED", unified);
	}
	
	public java.lang.Integer getUnified() {
		return getInt("UNIFIED");
	}

	public void setMajor(java.lang.String major) {
		set("MAJOR", major);
	}
	
	public java.lang.String getMajor() {
		return getStr("MAJOR");
	}

}
