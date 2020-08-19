package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.TrainExper;

public class TrainExperService {
	private TrainExper trainExperDao = TrainExper.dao;

	public void save(TrainExper trainExper) {
		trainExper.remove("ID");
		trainExper.save();
	}

	public void del(Object id) {
		trainExperDao.deleteById(id);
	}

	public void update(TrainExper trainExper) {
		trainExper.update();
	}

	public TrainExper findById(Object id) {
		return trainExperDao.findById(id);
	}

	public Page<TrainExper> find(TrainExper trainExper, int pageNo, int pageSize) {
		Kv kv = Kv.by("trainExper", trainExper);
		Page<TrainExper> trainExpers = trainExperDao.paginate(pageNo, pageSize, trainExperDao.getSqlPara("trainExper.find", kv));
		return trainExpers;
	}

	public Page<TrainExper> find(TrainExper trainExper, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("trainExper", trainExper);
		dataFilter.preFilter(kv);
		Page<TrainExper> trainExpers = trainExperDao.paginate(pageNo, pageSize, trainExperDao.getSqlPara("trainExper.find", kv));
		return trainExpers;
	}
}