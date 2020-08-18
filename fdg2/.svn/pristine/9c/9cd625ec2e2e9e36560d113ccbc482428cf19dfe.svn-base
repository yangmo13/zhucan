package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseStaffTmp<M extends BaseStaffTmp<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("logo","LOGO");
		mappings.put("idCard","ID_CARD");
		mappings.put("tel","TEL");
		mappings.put("type","TYPE");
		mappings.put("level","LEVEL");
		mappings.put("username","USERNAME");
		mappings.put("refUserId","REF_USER_ID");
		mappings.put("refArchiveId","REF_ARCHIVE_ID");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_staff_tmp";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setLogo(java.lang.String logo) {
		set("LOGO", logo);
	}
	
	public java.lang.String getLogo() {
		return getStr("LOGO");
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

	public void setType(java.lang.String type) {
		set("TYPE", type);
	}
	
	public java.lang.String getType() {
		return getStr("TYPE");
	}

	public void setLevel(java.lang.String level) {
		set("LEVEL", level);
	}
	
	public java.lang.String getLevel() {
		return getStr("LEVEL");
	}

	public void setUsername(java.lang.String username) {
		set("USERNAME", username);
	}
	
	public java.lang.String getUsername() {
		return getStr("USERNAME");
	}

	public void setRefUserId(java.lang.String refUserId) {
		set("REF_USER_ID", refUserId);
	}
	
	public java.lang.String getRefUserId() {
		return getStr("REF_USER_ID");
	}

	public void setRefArchiveId(java.lang.Long refArchiveId) {
		set("REF_ARCHIVE_ID", refArchiveId);
	}
	
	public java.lang.Long getRefArchiveId() {
		return getLong("REF_ARCHIVE_ID");
	}

}
