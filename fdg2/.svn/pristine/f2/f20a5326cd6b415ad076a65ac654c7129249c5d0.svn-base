package com.sloth.service;

import java.util.UUID;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.sloth.model.TmpUser;

public class TmpUserService {
	private TmpUser tmpUserDao = TmpUser.dao;

	public TmpUser findByToken(String token) {
		return tmpUserDao.findFirst(Db.getSqlPara("tmpUser.findByToken", Kv.by("token", token)));
	}
	
	public TmpUser findByOpenid(String openid) {
		Kv kv = Kv.by("openid", openid);
		return tmpUserDao.findFirst(Db.getSqlPara("user.findByOpenid", kv));
	}

	public void save(TmpUser tmpUser) {
		tmpUser.setId(UUID.randomUUID().toString());
		tmpUser.save();
	}

	public void del(Object id) {
		tmpUserDao.deleteById(id);
	}

	public void update(TmpUser tmpUser) {
		tmpUser.update();
	}

	public TmpUser findById(Object id) {
		return tmpUserDao.findById(id);
	}

	public Page<TmpUser> find(TmpUser tmpUser, int pageNo, int pageSize) {
		Kv kv = Kv.by("tmpUser", tmpUser);
		Page<TmpUser> tmpUsers = tmpUserDao.paginate(pageNo, pageSize, tmpUserDao.getSqlPara("tmpUser.find", kv));
		return tmpUsers;
	}

	public Page<TmpUser> find(TmpUser tmpUser, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("tmpUser", tmpUser);
		dataFilter.preFilter(kv);
		Page<TmpUser> tmpUsers = tmpUserDao.paginate(pageNo, pageSize, tmpUserDao.getSqlPara("tmpUser.find", kv));
		return tmpUsers;
	}
}