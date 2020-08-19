package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.EduExper;

public class EduExperService {
	private EduExper eduExperDao = EduExper.dao;

	public void save(EduExper eduExper) {
		eduExper.remove("ID");
		eduExper.save();
	}

	public void del(Object id) {
		eduExperDao.deleteById(id);
	}

	public void update(EduExper eduExper) {
		eduExper.update();
	}

	public EduExper findById(Object id) {
		return eduExperDao.findById(id);
	}

	public Page<EduExper> find(EduExper eduExper, int pageNo, int pageSize) {
		Kv kv = Kv.by("eduExper", eduExper);
		Page<EduExper> eduExpers = eduExperDao.paginate(pageNo, pageSize, eduExperDao.getSqlPara("eduExper.find", kv));
		return eduExpers;
	}

	public Page<EduExper> find(EduExper eduExper, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("eduExper", eduExper);
		dataFilter.preFilter(kv);
		Page<EduExper> eduExpers = eduExperDao.paginate(pageNo, pageSize, eduExperDao.getSqlPara("eduExper.find", kv));
		return eduExpers;
	}
}