package com.sloth.service;

import java.util.List;
import java.util.UUID;

import com.jfinal.aop.Before;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Data;

public class DataService {
	private Data dataDao = new Data();

	public int getDataAuth(String userId, String dataCode) {
		int dataAuth = 3;
		Kv kv = Kv.by("code", dataCode).set("userId", userId);
		Record record = Db.template("user.findMaxDataAuth", kv).findFirst();
		if (record != null) {
			Integer tmpDataAuth = record.getInt("DATA_AUTH");
			if (tmpDataAuth != null) {
				dataAuth = tmpDataAuth;
			}
		}
		return dataAuth;
	}

	public Page<Data> find(String name, String code, int pageNo, int pageSize) {
		Kv kv = Kv.by("name", name);
		kv.set("code", code);
		Page<Data> datas = dataDao.paginate(pageNo, pageSize, dataDao.getSqlPara("data.find", kv));
		return datas;
	}

	public List<Data> findByRoleId(String roleId) {
		return dataDao.template("data.findByRoleId", Kv.by("roleId", roleId)).find();
	}

	public void update(Data data) {
		data.update();
	}

	public void add(Data data) {
		data.setId(UUID.randomUUID().toString());
		data.save();
	}

	public Data findById(String id) {
		return dataDao.findById(id);
	}

	@Before(Tx.class)
	public void del(String id) throws SlothException {
		dataDao.deleteById(id);
	}
}