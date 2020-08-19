package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.WorkExper;

public class WorkExperService {
	private WorkExper workExperDao = WorkExper.dao;

	public void save(WorkExper workExper) {
		workExper.remove("ID");
		workExper.save();
	}

	public void del(Object id) {
		workExperDao.deleteById(id);
	}

	public void update(WorkExper workExper) {
		workExper.update();
	}

	public WorkExper findById(Object id) {
		return workExperDao.findById(id);
	}

	public Page<WorkExper> find(WorkExper workExper, int pageNo, int pageSize) {
		Kv kv = Kv.by("workExper", workExper);
		Page<WorkExper> workExpers = workExperDao.paginate(pageNo, pageSize, workExperDao.getSqlPara("workExper.find", kv));
		return workExpers;
	}

	public Page<WorkExper> find(WorkExper workExper, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("workExper", workExper);
		dataFilter.preFilter(kv);
		Page<WorkExper> workExpers = workExperDao.paginate(pageNo, pageSize, workExperDao.getSqlPara("workExper.find", kv));
		return workExpers;
	}
}