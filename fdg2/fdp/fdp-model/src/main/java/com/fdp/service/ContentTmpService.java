package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.ContentTmp;

public class ContentTmpService {
	private ContentTmp contentTmpDao = ContentTmp.dao;

	public void save(ContentTmp contentTmp) {
		contentTmp.remove("ID");
		contentTmp.save();
	}

	public void del(Object id) {
		ContentTmp contentTmp = contentTmpDao.findById(id);
		contentTmp.setDeleted(1);
		contentTmp.update();
	}

	public void update(ContentTmp contentTmp) {
		contentTmp.update();
	}

	public ContentTmp findById(Object id) {
		return contentTmpDao.findById(id);
	}

	public Page<ContentTmp> find(ContentTmp contentTmp, int pageNo, int pageSize) {
		Kv kv = Kv.by("contentTmp", contentTmp);
		Page<ContentTmp> contentTmps = contentTmpDao.paginate(pageNo, pageSize, contentTmpDao.getSqlPara("contentTmp.find", kv));
		return contentTmps;
	}

	public Page<ContentTmp> find(ContentTmp contentTmp, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("contentTmp", contentTmp);
		dataFilter.preFilter(kv);
		Page<ContentTmp> contentTmps = contentTmpDao.paginate(pageNo, pageSize, contentTmpDao.getSqlPara("contentTmp.find", kv));
		return contentTmps;
	}
}