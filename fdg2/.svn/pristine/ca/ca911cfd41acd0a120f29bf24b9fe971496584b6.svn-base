package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseTrainExper<M extends BaseTrainExper<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("refId","REF_ID");
		mappings.put("orgName","ORG_NAME");
		mappings.put("fromDate","FROM_DATE");
		mappings.put("endDate","END_DATE");
		mappings.put("course","COURSE");
		mappings.put("witness","WITNESS");
		mappings.put("witnessTel","WITNESS_TEL");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_train_exper";
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

	public void setOrgName(java.lang.String orgName) {
		set("ORG_NAME", orgName);
	}
	
	public java.lang.String getOrgName() {
		return getStr("ORG_NAME");
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

	public void setCourse(java.lang.String course) {
		set("COURSE", course);
	}
	
	public java.lang.String getCourse() {
		return getStr("COURSE");
	}

	public void setWitness(java.lang.String witness) {
		set("WITNESS", witness);
	}
	
	public java.lang.String getWitness() {
		return getStr("WITNESS");
	}

	public void setWitnessTel(java.lang.String witnessTel) {
		set("WITNESS_TEL", witnessTel);
	}
	
	public java.lang.String getWitnessTel() {
		return getStr("WITNESS_TEL");
	}

}
