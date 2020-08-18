package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseTinyWishTmp<M extends BaseTinyWishTmp<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("realname","REALNAME");
		mappings.put("idCard","ID_CARD");
		mappings.put("linkman","LINKMAN");
		mappings.put("tel","TEL");
		mappings.put("disabilityType","DISABILITY_TYPE");
		mappings.put("disabilityLevel","DISABILITY_LEVEL");
		mappings.put("startDate","START_DATE");
		mappings.put("endDate","END_DATE");
		mappings.put("takeStatus","TAKE_STATUS");
		mappings.put("takerId","TAKER_ID");
		mappings.put("takerName","TAKER_NAME");
		mappings.put("takeTime","TAKE_TIME");
		mappings.put("completeDate","COMPLETE_DATE");
		mappings.put("photo","PHOTO");
		
		//F_CONTENT_TMP里的TITLE
//		mappings.put("title", "TITLE");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_tiny_wish_tmp";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
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

	public void setLinkman(java.lang.String linkman) {
		set("LINKMAN", linkman);
	}
	
	public java.lang.String getLinkman() {
		return getStr("LINKMAN");
	}

	public void setTel(java.lang.String tel) {
		set("TEL", tel);
	}
	
	public java.lang.String getTel() {
		return getStr("TEL");
	}

	public void setDisabilityType(java.lang.String disabilityType) {
		set("DISABILITY_TYPE", disabilityType);
	}
	
	public java.lang.String getDisabilityType() {
		return getStr("DISABILITY_TYPE");
	}

	public void setDisabilityLevel(java.lang.String disabilityLevel) {
		set("DISABILITY_LEVEL", disabilityLevel);
	}
	
	public java.lang.String getDisabilityLevel() {
		return getStr("DISABILITY_LEVEL");
	}

	public void setStartDate(java.util.Date startDate) {
		set("START_DATE", startDate);
	}
	
	public java.util.Date getStartDate() {
		return get("START_DATE");
	}

	public void setEndDate(java.util.Date endDate) {
		set("END_DATE", endDate);
	}
	
	public java.util.Date getEndDate() {
		return get("END_DATE");
	}

	public void setTakeStatus(java.lang.String takeStatus) {
		set("TAKE_STATUS", takeStatus);
	}
	
	public java.lang.String getTakeStatus() {
		return getStr("TAKE_STATUS");
	}

	public void setTakerId(java.lang.String takerId) {
		set("TAKER_ID", takerId);
	}
	
	public java.lang.String getTakerId() {
		return getStr("TAKER_ID");
	}

	public void setTakerName(java.lang.String takerName) {
		set("TAKER_NAME", takerName);
	}
	
	public java.lang.String getTakerName() {
		return getStr("TAKER_NAME");
	}

	public void setTakeTime(java.util.Date takeTime) {
		set("TAKE_TIME", takeTime);
	}
	
	public java.util.Date getTakeTime() {
		return get("TAKE_TIME");
	}

	public void setCompleteDate(java.util.Date completeDate) {
		set("COMPLETE_DATE", completeDate);
	}
	
	public java.util.Date getCompleteDate() {
		return get("COMPLETE_DATE");
	}

	public void setPhoto(java.lang.String photo) {
		set("PHOTO", photo);
	}
	
	public java.lang.String getPhoto() {
		return getStr("PHOTO");
	}

	
//	//F_CONTENT_TMP里的TITLE
//	public void setTile(String title) {
//		set("TITLE", title);
//	}
//	
//	public String getTitle() {
//		return getStr("TITLE");
//	}
}
