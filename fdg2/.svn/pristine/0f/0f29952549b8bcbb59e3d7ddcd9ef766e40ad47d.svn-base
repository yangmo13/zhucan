package com.sloth.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Before;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.common.DataFilter;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Dept;
import com.sloth.util.StringKit;

public class DeptService {
	private Dept deptDao = new Dept();

	public String findTitleForShow(String id) {
		Record record = Db.findFirst(Db.getSqlPara("dept.findAllForShow", Kv.by("id", id)));
		return record == null ? null : record.getStr("title");
	}

	public List<Map<String, Object>> findForTreeSelect(String id, DataFilter dataFilter) {
		List<Map<String, Object>> datas = new ArrayList<>();
		if (dataFilter.getDataAuth() == 1) {
			this.dealById(dataFilter.getUser().getDeptId(), datas, dataFilter);
		} else if (dataFilter.getDataAuth() == 2) {
			this.dealById(dataFilter.getUser().getDeptId().substring(0, 3), datas, dataFilter);
		} else {
			this.reverseDept(id, "0", datas, dataFilter);
		}
		return datas;
	}

	private void dealById(String id, List<Map<String, Object>> datas, DataFilter dataFilter) {
		Dept dept = this.findById(id);
		Map<String, Object> data = new HashMap<>();
		data.put("id", dept.getId());
		data.put("name", dept.getTitle());
		data.put("lv", dept.getLv());
		datas.add(data);
		List<Map<String, Object>> children = new ArrayList<>();
		this.reverseDept(id, id, children, dataFilter);
		if (children.size() > 0) {
			data.put("children", children);
		}
	}

	private void reverseDept(String ignoreId, String pid, List<Map<String, Object>> datas, DataFilter dataFilter) {
		Kv kv = Kv.by("pid", pid).set("id", ignoreId);
		dataFilter.preFilter(kv);
		List<Dept> depts = deptDao.find(Db.getSqlPara("dept.findByPid", kv));
		for (Dept dept : depts) {
			Map<String, Object> data = new HashMap<>();
			data.put("id", dept.getId());
			data.put("name", dept.getTitle());
			data.put("lv", dept.getLv());
			List<Map<String, Object>> children = new ArrayList<>();
			this.reverseDept(ignoreId, dept.getId(), children, dataFilter);
			if (children.size() > 0) {
				data.put("children", children);
			}
			datas.add(data);
		}
	}

	public List<Dept> findAll(DataFilter dataFilter) {
		Kv kv = new Kv();
		dataFilter.preFilter(kv);
		List<Dept> depts = deptDao.find(Db.getSqlPara("dept.findAll", kv));
		return depts;
	}

	public void update(Dept dept) {
		Dept tmp = this.findById(dept.getId());
		tmp._setAttrs(dept);
		tmp.update();
	}

	public void add(Dept dept) {
		if (StringKit.isEmpty(dept.getPid())) {
			dept.setPid("0");
		}
		String maxStr = Db.queryStr(Db.getSql("dept.findMaxId"), dept.getPid());
		int maxId = Integer.parseInt(StringKit.isEmpty(maxStr) ? "0" : maxStr);
		String targetId;
		if (maxId == 0) {
			if (dept.getPid().equals("0")) {
				targetId = "100";
			} else {
				targetId = dept.getPid() + "001";
			}
		} else {
			targetId = String.valueOf(maxId + 1);
		}
		dept.setId(String.valueOf(targetId));
		this.setSeqAndLv(dept);
		dept.save();
	}

	private void setSeqAndLv(Dept dept) {
		Dept parent = this.findById(dept.getPid());
		int lv = parent == null ? 1 : parent.getLv() + 1;
		Dept tmp = this.findById(dept.getId());
		int seq = 0;
		if (tmp != null) {
			seq = tmp.getSeq();
		} else {
			seq = Db.queryInt(Db.getSqlPara("dept.findMaxSeq").getSql(), dept.getPid()) + 1;
		}
		dept.setLv(lv);
		dept.setSeq(seq);
	}

	public Dept findById(String id) {
		return deptDao.findById(id);
	}

	@Before(Tx.class)
	public void del(String id) throws SlothException {
		long count = Db.queryLong(Db.getSqlPara("dept.findSubCount").getSql(), id);
		if (count > 0) {
			throw new SlothException("请先删除子单位/部门！");
		}
		deptDao.deleteById(id);
	}

	// direct > 0 向下
	public void move(String id, int direct) {
		Dept dept = deptDao.findById(id);
		Kv data = Kv.by("id", id).set("pid", dept.getPid()).set("direct", direct).set("seq", dept.getSeq());
		Dept nearDept = deptDao.findFirst(deptDao.getSqlPara("dept.findNearBy", data));
		if (nearDept == null)
			return;
		int tmpSeq = dept.getSeq();
		dept.setSeq(nearDept.getSeq());
		nearDept.setSeq(tmpSeq);
		dept.update();
		nearDept.update();
	}

	public Dept findByTitle(String title, Integer lv) {
		Kv data = Kv.by("title", title).set("lv", lv);
		return deptDao.findFirst(deptDao.getSqlPara("dept.findByTitle", data));
	}

	public Dept findByTileAndPTitle(String title, String ptitle, Integer targetLv) {
		Kv data = Kv.by("title", title).set("ptitle", ptitle).set("lv", targetLv);
		return deptDao.findFirst(deptDao.getSqlPara("dept.findByTileAndPTitle", data));
	}
}