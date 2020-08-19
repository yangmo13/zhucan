package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseResume<M extends BaseResume<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("deleted","DELETED");
		mappings.put("userId","USER_ID");
		mappings.put("orgId","ORG_ID");
		mappings.put("orgName","ORG_NAME");
		mappings.put("registerId","REGISTER_ID");
		mappings.put("registerName","REGISTER_NAME");
		mappings.put("registTime","REGIST_TIME");
		mappings.put("realname","REALNAME");
		mappings.put("idCard","ID_CARD");
		mappings.put("workFrom","WORK_FROM");
		mappings.put("city","CITY");
		mappings.put("tel","TEL");
		mappings.put("disabilityLevel","DISABILITY_LEVEL");
		mappings.put("disabilityType","DISABILITY_TYPE");
		mappings.put("expectSalary","EXPECT_SALARY");
		mappings.put("expectCity","EXPECT_CITY");
		mappings.put("expectPost","EXPECT_POST");
		mappings.put("selfEval","SELF_EVAL");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_resume";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setDeleted(java.lang.Integer deleted) {
		set("DELETED", deleted);
	}
	
	public java.lang.Integer getDeleted() {
		return getInt("DELETED");
	}

	public void setUserId(java.lang.String userId) {
		set("USER_ID", userId);
	}
	
	public java.lang.String getUserId() {
		return getStr("USER_ID");
	}

	public void setOrgId(java.lang.Long orgId) {
		set("ORG_ID", orgId);
	}
	
	public java.lang.Long getOrgId() {
		return getLong("ORG_ID");
	}

	public void setOrgName(java.lang.String orgName) {
		set("ORG_NAME", orgName);
	}
	
	public java.lang.String getOrgName() {
		return getStr("ORG_NAME");
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

	public void setRealname(java.lang.String realname) {
		set("REALNAME", realname);
	}
	
	public java.lang.String getRealname() {
		return getStr("REALNAME");
	}

	public void setIdCard(java.lang.String idCard) {
		set("ID_CARD", idCard);
	}
	
	public java.lang.String getIdCard() {
		return getStr("ID_CARD");
	}

	public void setWorkFrom(java.util.Date workFrom) {
		set("WORK_FROM", workFrom);
	}
	
	public java.util.Date getWorkFrom() {
		return get("WORK_FROM");
	}

	public void setCity(java.lang.String city) {
		set("CITY", city);
	}
	
	public java.lang.String getCity() {
		return getStr("CITY");
	}

	public void setTel(java.lang.String tel) {
		set("TEL", tel);
	}
	
	public java.lang.String getTel() {
		return getStr("TEL");
	}

	public void setDisabilityLevel(java.lang.String disabilityLevel) {
		set("DISABILITY_LEVEL", disabilityLevel);
	}
	
	public java.lang.String getDisabilityLevel() {
		return getStr("DISABILITY_LEVEL");
	}

	public void setDisabilityType(java.lang.String disabilityType) {
		set("DISABILITY_TYPE", disabilityType);
	}
	
	public java.lang.String getDisabilityType() {
		return getStr("DISABILITY_TYPE");
	}

	public void setExpectSalary(java.lang.String expectSalary) {
		set("EXPECT_SALARY", expectSalary);
	}
	
	public java.lang.String getExpectSalary() {
		return getStr("EXPECT_SALARY");
	}

	public void setExpectCity(java.lang.String expectCity) {
		set("EXPECT_CITY", expectCity);
	}
	
	public java.lang.String getExpectCity() {
		return getStr("EXPECT_CITY");
	}

	public void setExpectPost(java.lang.String expectPost) {
		set("EXPECT_POST", expectPost);
	}
	
	public java.lang.String getExpectPost() {
		return getStr("EXPECT_POST");
	}

	public void setSelfEval(java.lang.String selfEval) {
		set("SELF_EVAL", selfEval);
	}
	
	public java.lang.String getSelfEval() {
		return getStr("SELF_EVAL");
	}

}
