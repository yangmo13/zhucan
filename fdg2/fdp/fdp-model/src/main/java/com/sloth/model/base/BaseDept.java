package com.sloth.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.IBean;
import com.jfinal.plugin.activerecord.Model;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDept<M extends BaseDept<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id", "ID");
		mappings.put("title", "TITLE");
		mappings.put("pid", "PID");
		mappings.put("seq", "SEQ");
		mappings.put("lv", "LV");
		mappings.put("opUserId", "OP_USER_ID");
	}

	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_dept";
	}

	public void setId(java.lang.String id) {
		set("ID", id);
	}

	public java.lang.String getId() {
		return getStr("ID");
	}

	public void setTitle(java.lang.String title) {
		set("TITLE", title);
	}

	public java.lang.String getTitle() {
		return getStr("TITLE");
	}

	public void setPid(java.lang.String pid) {
		set("PID", pid);
	}

	public java.lang.String getPid() {
		return getStr("PID");
	}

	public void setSeq(java.lang.Integer seq) {
		set("SEQ", seq);
	}

	public java.lang.Integer getSeq() {
		return getInt("SEQ");
	}

	public void setLv(java.lang.Integer lv) {
		set("LV", lv);
	}

	public java.lang.Integer getLv() {
		return getInt("LV");
	}

	public void setOpUserId(java.lang.String opUserId) {
		set("OP_USER_ID", opUserId);
	}

	public java.lang.String getOpUserId() {
		return getStr("OP_USER_ID");
	}
}