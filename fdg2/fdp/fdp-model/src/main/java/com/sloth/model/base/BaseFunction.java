package com.sloth.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseFunction<M extends BaseFunction<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("name","NAME");
		mappings.put("permission","PERMISSION");
		mappings.put("menuId","MENU_ID");
		mappings.put("seq","SEQ");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_function";
	}

	public void setId(java.lang.String id) {
		set("ID", id);
	}
	
	public java.lang.String getId() {
		return getStr("ID");
	}

	public void setName(java.lang.String name) {
		set("NAME", name);
	}
	
	public java.lang.String getName() {
		return getStr("NAME");
	}

	public void setPermission(java.lang.String permission) {
		set("PERMISSION", permission);
	}
	
	public java.lang.String getPermission() {
		return getStr("PERMISSION");
	}

	public void setMenuId(java.lang.Integer menuId) {
		set("MENU_ID", menuId);
	}
	
	public java.lang.Integer getMenuId() {
		return getInt("MENU_ID");
	}

	public void setSeq(java.lang.Integer seq) {
		set("SEQ", seq);
	}
	
	public java.lang.Integer getSeq() {
		return getInt("SEQ");
	}

}