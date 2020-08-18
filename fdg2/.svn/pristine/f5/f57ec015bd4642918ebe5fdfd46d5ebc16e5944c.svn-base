package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.TUser;

public class TUserService {
	private TUser tUserDao = TUser.dao;

	public void save(TUser tUser) {
		tUser.save();
	}

	public void del(Object id) {
		tUserDao.deleteById(id);
	}

	public void update(TUser tUser) {
		tUser.update();
	}

	public TUser findById(Object id) {
		return tUserDao.findById(id);
	}

	public Page<TUser> find(TUser tUser, int pageNo, int pageSize) {
		Kv kv = Kv.by("tUser", tUser);
		Page<TUser> tUsers = tUserDao.paginate(pageNo, pageSize, tUserDao.getSqlPara("tUser.find", kv));
		return tUsers;
	}

	public Page<TUser> find(TUser tUser, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("tUser", tUser);
		dataFilter.preFilter(kv);
		Page<TUser> tUsers = tUserDao.paginate(pageNo, pageSize, tUserDao.getSqlPara("tUser.find", kv));
		return tUsers;
	}
}