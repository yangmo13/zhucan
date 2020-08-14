package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.TinyWish;

public class TinyWishService {
	private TinyWish tinyWishDao = TinyWish.dao;

	public void save(TinyWish tinyWish) {
		tinyWish.remove("ID");
		tinyWish.save();
	}

	public void del(Object id) {
		tinyWishDao.deleteById(id);
	}

	public void update(TinyWish tinyWish) {
		tinyWish.update();
	}

	public TinyWish findById(Object id) {
		return tinyWishDao.findById(id);
	}

	public Page<TinyWish> find(TinyWish tinyWish, int pageNo, int pageSize) {
		Kv kv = Kv.by("tinyWish", tinyWish);
		Page<TinyWish> tinyWishs = tinyWishDao.paginate(pageNo, pageSize, tinyWishDao.getSqlPara("tinyWish.find", kv));
		return tinyWishs;
	}

	public Page<TinyWish> find(TinyWish tinyWish, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("tinyWish", tinyWish);
		dataFilter.preFilter(kv);
		Page<TinyWish> tinyWishs = tinyWishDao.paginate(pageNo, pageSize, tinyWishDao.getSqlPara("tinyWish.find", kv));
		return tinyWishs;
	}
}