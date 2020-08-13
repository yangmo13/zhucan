package com.sloth.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseMenu<M extends BaseMenu<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("title","TITLE");
		mappings.put("path","PATH");
		mappings.put("icon","ICON");
		mappings.put("pid","PID");
		mappings.put("lv","LV");
		mappings.put("seq","SEQ");
		mappings.put("editable","EDITABLE");
		mappings.put("deletable","DELETABLE");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_menu";
	}

	public void setId(java.lang.Integer id) {
		set("ID", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("ID");
	}

	public void setTitle(java.lang.String title) {
		set("TITLE", title);
	}
	
	public java.lang.String getTitle() {
		return getStr("TITLE");
	}

	public void setPath(java.lang.String path) {
		set("PATH", path);
	}
	
	public java.lang.String getPath() {
		return getStr("PATH");
	}

	public void setIcon(java.lang.String icon) {
		set("ICON", icon);
	}
	
	public java.lang.String getIcon() {
		return getStr("ICON");
	}

	public void setPid(java.lang.Integer pid) {
		set("PID", pid);
	}
	
	public java.lang.Integer getPid() {
		return getInt("PID");
	}

	public void setLv(java.lang.Integer lv) {
		set("LV", lv);
	}
	
	public java.lang.Integer getLv() {
		return getInt("LV");
	}

	public void setSeq(java.lang.Integer seq) {
		set("SEQ", seq);
	}
	
	public java.lang.Integer getSeq() {
		return getInt("SEQ");
	}

	public void setEditable(java.lang.Integer editable) {
		set("EDITABLE", editable);
	}
	
	public java.lang.Integer getEditable() {
		return getInt("EDITABLE");
	}

	public void setDeletable(java.lang.Integer deletable) {
		set("DELETABLE", deletable);
	}
	
	public java.lang.Integer getDeletable() {
		return getInt("DELETABLE");
	}

}
