package com.sloth.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseTmpUser<M extends BaseTmpUser<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("opTime","OP_TIME");
		mappings.put("token","TOKEN");
		mappings.put("infoCompleted","INFO_COMPLETED");
		mappings.put("openid","OPENID");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "t_tmp_user";
	}

	public void setId(java.lang.String id) {
		set("ID", id);
	}
	
	public java.lang.String getId() {
		return getStr("ID");
	}

	public void setOpTime(java.util.Date opTime) {
		set("OP_TIME", opTime);
	}
	
	public java.util.Date getOpTime() {
		return get("OP_TIME");
	}

	public void setToken(java.lang.String token) {
		set("TOKEN", token);
	}
	
	public java.lang.String getToken() {
		return getStr("TOKEN");
	}

	public void setInfoCompleted(java.lang.Integer infoCompleted) {
		set("INFO_COMPLETED", infoCompleted);
	}
	
	public java.lang.Integer getInfoCompleted() {
		return getInt("INFO_COMPLETED");
	}

	public void setOpenid(java.lang.String openid) {
		set("OPENID", openid);
	}
	
	public java.lang.String getOpenid() {
		return getStr("OPENID");
	}

}
