package com.sloth.service;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Dict;

public class DictService {
	private Dict dao = Dict.dao;

	public List<Dict> subs(String code) {
		Dict dict = this.findByCode(code);
		return dao.find(dao.getSqlPara("dict.findSubByPid", Kv.by("pid", dict.getId())));
	}

	public Dict findByValue(String code, String value) {
		return dao.findFirst(dao.getSqlPara("dict.findByValue", Kv.by("code", code).set("value", value)));
	}

	public List<Record> findDeptsForShow() {
		return Db.find(Db.getSqlPara("dept.findAllForShow"));
	}

	public Dict findByTitle(String code, String value) {
		if (value == null) return null;
		return dao.findFirst(dao.getSqlPara("dict.findByTitle", Kv.by("code", code).set("value", value)));
	}

	public Dict findByCode(String code) {
		return dao.findFirst(dao.getSqlPara("dict.findByCode", Kv.by("code", code)));
	}
	
	public List<Dict> findListByPID(String pid){
		List<Dict> dictList= dao.find("select * from t_dict where pid = '"+pid+"'");
		return dictList;
	}

	public Page<Dict> find(Integer pid, String title, String code, int pageNo, int pageSize) {
		Kv kv = Kv.by("pid", pid);
		kv.set("title", title);
		kv.set("code", code);
		Page<Dict> users = dao.paginate(pageNo, pageSize, dao.getSqlPara("dict.find", kv));
		return users;
	}

	public Dict findById(Integer id) {
		return dao.findById(id);
	}

	@Before(Tx.class)
	public void add(Dict dict) {
		Kv kv = Kv.by("pid", dict.getPid());
		int seq;
		if (dict.getPid() == null) {
			seq = Db.queryInt(Db.getSqlPara("dict.findMaxSeq", kv).getSql()) + 1;
		} else {
			seq = Db.queryInt(Db.getSqlPara("dict.findMaxSeq", kv).getSql(), dict.getPid()) + 1;
		}
		dict.setSeq(seq);
		dict.removeNullValueAttrs();
		dict.save();
	}

	@Before(Tx.class)
	public void update(Dict dict) {
		dict.remove("pid", "seq");
		Dict tmp = this.findById(dict.getId());
		tmp._setAttrs(dict);
		tmp.update();
	}

	@Before(Tx.class)
	public void del(String id) {
		int subCount = Db.queryInt(Db.getSqlPara("dict.findSubCount").getSql(), id);
		if (subCount > 0) {
			throw new SlothException(30001);
		}
		dao.deleteById(id);
	}

	// direct > 0 向下
	public void move(String id, int direct) {
		Dict dict = dao.findById(id);
		Kv data = Kv.by("id", id).set("pid", dict.getPid()).set("direct", direct).set("seq", dict.getSeq());
		Dict neardict = dao.findFirst(dao.getSqlPara("dict.findNearBy", data));
		if (neardict == null)
			return;
		int tmpSeq = dict.getSeq();
		dict.setSeq(neardict.getSeq());
		neardict.setSeq(tmpSeq);
		dict.update();
		neardict.update();
	}

	public List<Record> findByTable(String table, String valueColumn, String showColumn) {
		Kv data = Kv.by("table", table);
		data.set("valueColumn", valueColumn);
		data.set("showColumn", showColumn);
		return Db.find(Db.getSqlPara("dict.findByTable", data));
	}
}