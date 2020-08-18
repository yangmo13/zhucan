package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseOrgTmp<M extends BaseOrgTmp<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("logo","LOGO");
		mappings.put("industry","INDUSTRY");
		mappings.put("size","SIZE");
		mappings.put("nature","NATURE");
		mappings.put("linkman","LINKMAN");
		mappings.put("tel","TEL");
		mappings.put("username","USERNAME");
		mappings.put("roles","ROLES");
		mappings.put("addr","ADDR");
		mappings.put("x","X");
		mappings.put("y","Y");
		mappings.put("refUserId","REF_USER_ID");
		mappings.put("refDeptId","REF_DEPT_ID");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_org_tmp";
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

	public void setIndustry(java.lang.String industry) {
		set("INDUSTRY", industry);
	}
	
	public java.lang.String getIndustry() {
		return getStr("INDUSTRY");
	}

	public void setSize(java.lang.String size) {
		set("SIZE", size);
	}
	
	public java.lang.String getSize() {
		return getStr("SIZE");
	}

	public void setNature(java.lang.String nature) {
		set("NATURE", nature);
	}
	
	public java.lang.String getNature() {
		return getStr("NATURE");
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

	public void setUsername(java.lang.String username) {
		set("USERNAME", username);
	}
	
	public java.lang.String getUsername() {
		return getStr("USERNAME");
	}

	public void setRoles(java.lang.String roles) {
		set("ROLES", roles);
	}
	
	public java.lang.String getRoles() {
		return getStr("ROLES");
	}

	public void setAddr(java.lang.String addr) {
		set("ADDR", addr);
	}
	
	public java.lang.String getAddr() {
		return getStr("ADDR");
	}

	public void setX(java.lang.String x) {
		set("X", x);
	}
	
	public java.lang.String getX() {
		return getStr("X");
	}

	public void setY(java.lang.String y) {
		set("Y", y);
	}
	
	public java.lang.String getY() {
		return getStr("Y");
	}

	public void setRefUserId(java.lang.String refUserId) {
		set("REF_USER_ID", refUserId);
	}
	
	public java.lang.String getRefUserId() {
		return getStr("REF_USER_ID");
	}

	public void setRefDeptId(java.lang.String refDeptId) {
		set("REF_DEPT_ID", refDeptId);
	}
	
	public java.lang.String getRefDeptId() {
		return getStr("REF_DEPT_ID");
	}

}
