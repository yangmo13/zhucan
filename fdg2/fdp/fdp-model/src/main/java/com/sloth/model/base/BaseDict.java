package com.sloth.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseDict<M extends BaseDict<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("title","TITLE");
		mappings.put("code","CODE");
		mappings.put("remark","REMARK");
		mappings.put("pid","PID");
		mappings.put("seq","SEQ");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_dict";
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

	public void setCode(java.lang.String code) {
		set("CODE", code);
	}
	
	public java.lang.String getCode() {
		return getStr("CODE");
	}

	public void setRemark(java.lang.String remark) {
		set("REMARK", remark);
	}
	
	public java.lang.String getRemark() {
		return getStr("REMARK");
	}

	public void setPid(java.lang.Integer pid) {
		set("PID", pid);
	}
	
	public java.lang.Integer getPid() {
		return getInt("PID");
	}

	public void setSeq(java.lang.Integer seq) {
		set("SEQ", seq);
	}
	
	public java.lang.Integer getSeq() {
		return getInt("SEQ");
	}

}
