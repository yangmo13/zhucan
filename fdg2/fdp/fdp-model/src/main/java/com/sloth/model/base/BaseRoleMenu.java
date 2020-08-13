package com.sloth.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseRoleMenu<M extends BaseRoleMenu<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("roleId","ROLE_ID");
		mappings.put("menuId","MENU_ID");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_role_menu";
	}

	public void setId(java.lang.String id) {
		set("ID", id);
	}
	
	public java.lang.String getId() {
		return getStr("ID");
	}

	public void setRoleId(java.lang.String roleId) {
		set("ROLE_ID", roleId);
	}
	
	public java.lang.String getRoleId() {
		return getStr("ROLE_ID");
	}

	public void setMenuId(java.lang.Integer menuId) {
		set("MENU_ID", menuId);
	}
	
	public java.lang.Integer getMenuId() {
		return getInt("MENU_ID");
	}

}