package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.OrgTmp;

public class OrgTmpService {
	private OrgTmp orgTmpDao = OrgTmp.dao;

	public void save(OrgTmp orgTmp) {
	//	orgTmp.remove("ID");
		
		orgTmp.save();
	}

	public void del(Object id) {
		orgTmpDao.deleteById(id);
	}

	public void update(OrgTmp orgTmp) {
		orgTmp.update();
	}

	public OrgTmp findById(Object id) {
		return orgTmpDao.findById(id);
	}

	public Page<OrgTmp> find(OrgTmp orgTmp, int pageNo, int pageSize) {
		Kv kv = Kv.by("orgTmp", orgTmp);
		Page<OrgTmp> orgTmps = orgTmpDao.paginate(pageNo, pageSize, orgTmpDao.getSqlPara("orgTmp.find", kv));
		return orgTmps;
	}

	public Page<OrgTmp> find(OrgTmp orgTmp, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("orgTmp", orgTmp);
		dataFilter.preFilter(kv);
		Page<OrgTmp> orgTmps = orgTmpDao.paginate(pageNo, pageSize, orgTmpDao.getSqlPara("orgTmp.find", kv));
		return orgTmps;
	}
}