package com.sloth.service;

import java.util.Map;
import java.util.Set;

import com.jfinal.aop.Before;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.model.Config;

public class ConfigService {
	private Config dao = Config.dao;

	@Before(Tx.class)
	public void saveAll(Map<String, String[]> maps) {
		Set<String> ids = maps.keySet();
		for (String idStr : ids) {
			Integer id = Integer.parseInt(idStr);
			this.updateById(id, maps.get(idStr)[0]);
		}
	}

	public String findValueByCode(String code) {
		Config config = this.findByCode(code);
		if (config == null)
			return null;
		return config.getValue();
	}

	public void updateById(Integer id, String value) {
		Config config = this.findById(id);
		config.setValue(value);
		config.update();
	}

	public Config findById(Integer id) {
		return dao.findById(id);
	}

	public Config findByCode(String code) {
		Config config = dao.findFirst(dao.getSqlPara("config.findByCode", Kv.by("code", code)));
		return config;
	}
}