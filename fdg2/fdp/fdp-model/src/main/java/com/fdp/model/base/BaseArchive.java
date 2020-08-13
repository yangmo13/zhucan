package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseArchive<M extends BaseArchive<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("isDriver","IS_DRIVER");
		mappings.put("isDisability","IS_DISABILITY");
		mappings.put("idCardFront","ID_CARD_FRONT");
		mappings.put("idCardBack","ID_CARD_BACK");
		mappings.put("facePhoto","FACE_PHOTO");
		mappings.put("realname","REALNAME");
		mappings.put("idCard","ID_CARD");
		mappings.put("tel","TEL");
		mappings.put("acType","AC_TYPE");
		mappings.put("birthPlace","BIRTH_PLACE");
		mappings.put("national","NATIONAL");
		mappings.put("maritalStatus","MARITAL_STATUS");
		mappings.put("edu","EDU");
		mappings.put("idAddr","ID_ADDR");
		mappings.put("addr","ADDR");
		mappings.put("linkman","LINKMAN");
		mappings.put("relation","RELATION");
		mappings.put("linkmainTel","LINKMAIN_TEL");
		mappings.put("company","COMPANY");
		mappings.put("workType","WORK_TYPE");
		mappings.put("nature","NATURE");
		mappings.put("welfareOrg","WELFARE_ORG");
		mappings.put("certNo","CERT_NO");
		mappings.put("disabilityLevel","DISABILITY_LEVEL");
		mappings.put("certPeriod","CERT_PERIOD");
		mappings.put("disabilityType","DISABILITY_TYPE");
		mappings.put("registTime","REGIST_TIME");
		mappings.put("registOrgId","REGIST_ORG_ID");
		mappings.put("registOrgName","REGIST_ORG_NAME");
		mappings.put("registerId","REGISTER_ID");
		mappings.put("registerName","REGISTER_NAME");
		mappings.put("deleted","DELETED");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_archive";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setIsDriver(java.lang.Integer isDriver) {
		set("IS_DRIVER", isDriver);
	}
	
	public java.lang.Integer getIsDriver() {
		return getInt("IS_DRIVER");
	}

	public void setIsDisability(java.lang.Integer isDisability) {
		set("IS_DISABILITY", isDisability);
	}
	
	public java.lang.Integer getIsDisability() {
		return getInt("IS_DISABILITY");
	}

	public void setIdCardFront(java.lang.String idCardFront) {
		set("ID_CARD_FRONT", idCardFront);
	}
	
	public java.lang.String getIdCardFront() {
		return getStr("ID_CARD_FRONT");
	}

	public void setIdCardBack(java.lang.String idCardBack) {
		set("ID_CARD_BACK", idCardBack);
	}
	
	public java.lang.String getIdCardBack() {
		return getStr("ID_CARD_BACK");
	}

	public void setFacePhoto(java.lang.String facePhoto) {
		set("FACE_PHOTO", facePhoto);
	}
	
	public java.lang.String getFacePhoto() {
		return getStr("FACE_PHOTO");
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

	public void setTel(java.lang.String tel) {
		set("TEL", tel);
	}
	
	public java.lang.String getTel() {
		return getStr("TEL");
	}

	public void setAcType(java.lang.String acType) {
		set("AC_TYPE", acType);
	}
	
	public java.lang.String getAcType() {
		return getStr("AC_TYPE");
	}

	public void setBirthPlace(java.lang.String birthPlace) {
		set("BIRTH_PLACE", birthPlace);
	}
	
	public java.lang.String getBirthPlace() {
		return getStr("BIRTH_PLACE");
	}

	public void setNational(java.lang.String national) {
		set("NATIONAL", national);
	}
	
	public java.lang.String getNational() {
		return getStr("NATIONAL");
	}

	public void setMaritalStatus(java.lang.String maritalStatus) {
		set("MARITAL_STATUS", maritalStatus);
	}
	
	public java.lang.String getMaritalStatus() {
		return getStr("MARITAL_STATUS");
	}

	public void setEdu(java.lang.String edu) {
		set("EDU", edu);
	}
	
	public java.lang.String getEdu() {
		return getStr("EDU");
	}

	public void setIdAddr(java.lang.String idAddr) {
		set("ID_ADDR", idAddr);
	}
	
	public java.lang.String getIdAddr() {
		return getStr("ID_ADDR");
	}

	public void setAddr(java.lang.String addr) {
		set("ADDR", addr);
	}
	
	public java.lang.String getAddr() {
		return getStr("ADDR");
	}

	public void setLinkman(java.lang.String linkman) {
		set("LINKMAN", linkman);
	}
	
	public java.lang.String getLinkman() {
		return getStr("LINKMAN");
	}

	public void setRelation(java.lang.String relation) {
		set("RELATION", relation);
	}
	
	public java.lang.String getRelation() {
		return getStr("RELATION");
	}

	public void setLinkmainTel(java.lang.String linkmainTel) {
		set("LINKMAIN_TEL", linkmainTel);
	}
	
	public java.lang.String getLinkmainTel() {
		return getStr("LINKMAIN_TEL");
	}

	public void setCompany(java.lang.String company) {
		set("COMPANY", company);
	}
	
	public java.lang.String getCompany() {
		return getStr("COMPANY");
	}

	public void setWorkType(java.lang.String workType) {
		set("WORK_TYPE", workType);
	}
	
	public java.lang.String getWorkType() {
		return getStr("WORK_TYPE");
	}

	public void setNature(java.lang.String nature) {
		set("NATURE", nature);
	}
	
	public java.lang.String getNature() {
		return getStr("NATURE");
	}

	public void setWelfareOrg(java.lang.Integer welfareOrg) {
		set("WELFARE_ORG", welfareOrg);
	}
	
	public java.lang.Integer getWelfareOrg() {
		return getInt("WELFARE_ORG");
	}

	public void setCertNo(java.lang.String certNo) {
		set("CERT_NO", certNo);
	}
	
	public java.lang.String getCertNo() {
		return getStr("CERT_NO");
	}

	public void setDisabilityLevel(java.lang.String disabilityLevel) {
		set("DISABILITY_LEVEL", disabilityLevel);
	}
	
	public java.lang.String getDisabilityLevel() {
		return getStr("DISABILITY_LEVEL");
	}

	public void setCertPeriod(java.util.Date certPeriod) {
		set("CERT_PERIOD", certPeriod);
	}
	
	public java.util.Date getCertPeriod() {
		return get("CERT_PERIOD");
	}

	public void setDisabilityType(java.lang.String disabilityType) {
		set("DISABILITY_TYPE", disabilityType);
	}
	
	public java.lang.String getDisabilityType() {
		return getStr("DISABILITY_TYPE");
	}

	public void setRegistTime(java.util.Date registTime) {
		set("REGIST_TIME", registTime);
	}
	
	public java.util.Date getRegistTime() {
		return get("REGIST_TIME");
	}

	public void setRegistOrgId(java.lang.Long registOrgId) {
		set("REGIST_ORG_ID", registOrgId);
	}
	
	public java.lang.Long getRegistOrgId() {
		return getLong("REGIST_ORG_ID");
	}

	public void setRegistOrgName(java.lang.String registOrgName) {
		set("REGIST_ORG_NAME", registOrgName);
	}
	
	public java.lang.String getRegistOrgName() {
		return getStr("REGIST_ORG_NAME");
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

	public void setDeleted(java.lang.Integer deleted) {
		set("DELETED", deleted);
	}
	
	public java.lang.Integer getDeleted() {
		return getInt("DELETED");
	}

}
