package com.fdp.model.base;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

@SuppressWarnings("serial")
public abstract class BaseDocumentTmp<M extends BaseDocumentTmp<M>> extends Model<M> implements IBean {
	private static Map<String, String> mappings;
	static {
		mappings = new HashMap<>();
		mappings.put("id","ID");
		mappings.put("pubDate","PUB_DATE");
		mappings.put("type","TYPE");
		mappings.put("img","IMG");
		mappings.put("tag","TAG");
		mappings.put("video","VIDEO");
		mappings.put("videoName","VIDEO_NAME");
	}
	
	public static String toColumnName(String name) {
		return mappings.get(name);
	}

	public static String getTablename() {
		return "f_document_tmp";
	}

	public void setId(java.lang.Long id) {
		set("ID", id);
	}
	
	public java.lang.Long getId() {
		return getLong("ID");
	}

	public void setPubDate(java.lang.String pubDate) {
		set("PUB_DATE", pubDate);
	}
	
	public java.lang.String getPubDate() {
		return getStr("PUB_DATE");
	}

	public void setType(java.lang.String type) {
		set("TYPE", type);
	}
	
	public java.lang.String getType() {
		return getStr("TYPE");
	}

	public void setImg(java.lang.String img) {
		set("IMG", img);
	}
	
	public java.lang.String getImg() {
		return getStr("IMG");
	}

	public void setTag(java.lang.String tag) {
		set("TAG", tag);
	}
	
	public java.lang.String getTag() {
		return getStr("TAG");
	}

	public void setVideo(java.lang.String video) {
		set("VIDEO", video);
	}
	
	public java.lang.String getVideo() {
		return getStr("VIDEO");
	}
	public void setVideoName(java.lang.String videoName) {
		set("VIDEO_NAME", videoName);
	}
	
	public java.lang.String getVideoName() {
		return getStr("VIDEO_NAME");
	}
}
