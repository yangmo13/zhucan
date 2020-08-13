package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.Content;

public class ContentService {
	private Content contentDao = Content.dao;

	public void save(Content content) {
		content.remove("ID");
		content.save();
	}

	public void del(Object id) {
		contentDao.deleteById(id);
	}

	public void update(Content content) {
		content.update();
	}

	public Content findById(Object id) {
		return contentDao.findById(id);
	}

	public Page<Content> find(Content content, int pageNo, int pageSize) {
		Kv kv = Kv.by("content", content);
		Page<Content> contents = contentDao.paginate(pageNo, pageSize, contentDao.getSqlPara("content.find", kv));
		return contents;
	}

	public Page<Content> find(Content content, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("content", content);
		dataFilter.preFilter(kv);
		Page<Content> contents = contentDao.paginate(pageNo, pageSize, contentDao.getSqlPara("content.find", kv));
		return contents;
	}
}