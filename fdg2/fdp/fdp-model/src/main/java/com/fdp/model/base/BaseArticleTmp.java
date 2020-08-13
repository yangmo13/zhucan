package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseArticleTmp<M extends BaseArticleTmp<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("pubTime","PUB_TIME");
		mappings.put("src","SRC");
		mappings.put("src2","SRC2");
		mappings.put("img","IMG");
		mappings.put("video","VIDEO");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_article_tmp";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setPubTime(java.lang.String pubTime) {
		set("PUB_TIME", pubTime);
	}
	
	public java.lang.String getPubTime() {
		return getStr("PUB_TIME");
	}

	public void setSrc(java.lang.String src) {
		set("SRC", src);
	}
	
	public java.lang.String getSrc() {
		return getStr("SRC");
	}

	public void setSrc2(java.lang.String src2) {
		set("SRC2", src2);
	}
	
	public java.lang.String getSrc2() {
		return getStr("SRC2");
	}

	public void setImg(java.lang.String img) {
		set("IMG", img);
	}
	
	public java.lang.String getImg() {
		return getStr("IMG");
	}

	public void setVideo(java.lang.String video) {
		set("VIDEO", video);
	}
	
	public java.lang.String getVideo() {
		return getStr("VIDEO");
	}

}
