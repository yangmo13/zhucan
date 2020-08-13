package com.sloth.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.jfinal.aop.Before;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.SqlPara;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.common.exception.SlothException;
import com.sloth.model.Function;
import com.sloth.model.Menu;
import com.sloth.util.StringKit;

public class MenuService {
	private Menu menuDao = new Menu();
	private Function functionDao = new Function();

	@Before(Tx.class)
	public void update(Menu menu, String functions) {
		this.setSeqAndLv(menu);
		menu.update();
		this.updateFunctions(menu.getId(), functions);
	}

	@Before(Tx.class)
	public void add(Menu menu, String functions) {
		this.setSeqAndLv(menu);
		menu.remove("ID");
		menu.save();
		this.updateFunctions(menu.getId(), functions);
	}

	private void updateFunctions(int menuId, String functions) {
		Db.update(Db.getSqlPara("menu.deleteFunctions", Kv.by("menuId", menuId)));
		if (StringKit.isEmpty(functions)) {
			return;
		}
		String[] fs = functions.split(",");
		for (int i = 0; i < fs.length; i++) {
			String[] t = fs[i].split("\\|");
			Function function = new Function();
			function.setId(UUID.randomUUID().toString());
			function.setName(t[0]);
			function.setPermission(t[1]);
			function.setMenuId(menuId);
			function.setSeq(i);
			function.save();
		}
	}

	public List<Function> findFunctionsByMenuId(int menuId) {
		List<Function> functions = functionDao.find(functionDao.getSqlPara("menu.findFunctionsByMenuId", Kv.by("menuId", menuId)));
		return functions;
	}

	public List<Function> findAllFunctions() {
		List<Function> functions = functionDao.find(functionDao.getSqlPara("menu.findAllFunctions"));
		return functions;
	}

	public List<Map<String, Object>> findByUserid(String userId) {
		List<Map<String, Object>> datas = new ArrayList<>();
		this.reverseMenuByPidAndUserId(userId, 0, datas);
		return datas;
	}

	private void reverseMenuByPidAndUserId(String userId, int pid, List<Map<String, Object>> datas) {
		List<Menu> menus = menuDao.find(Db.getSqlPara("menu.findByUserId", Kv.by("pid", pid).set("userId", userId)));
		for (Menu menu : menus) {
			Map<String, Object> data = new HashMap<>();
			data.put("id", menu.getId());
			data.put("name", menu.getTitle());
			data.put("url", menu.getPath());
			data.put("icon", menu.getIcon());
			data.put("pid", menu.getPid());
			List<Map<String, Object>> children = new ArrayList<>();
			this.reverseMenuByPidAndUserId(userId, menu.getId(), children);
			if (children.size() > 0) {
				data.put("children", children);
			}
			datas.add(data);
		}
	}

	public List<Menu> findAll() {
		List<Menu> menus = menuDao.find(Db.getSqlPara("menu.findAll"));
		return menus;
	}

	public Menu findById(int id) {
		return menuDao.findById(id);
	}

	public List<Map<String, Object>> findForTreeSelect(int id) {
		List<Map<String, Object>> datas = new ArrayList<>();
		this.reverseMenu(id, 0, datas);
		return datas;
	}

	private void reverseMenu(int ignoreId, int pid, List<Map<String, Object>> datas) {
		List<Menu> menus = menuDao.find(Db.getSqlPara("menu.findByPid", Kv.by("pid", pid).set("id", ignoreId)));
		for (Menu menu : menus) {
			Map<String, Object> data = new HashMap<>();
			data.put("id", menu.getId());
			data.put("name", menu.getTitle());
			List<Map<String, Object>> children = new ArrayList<>();
			this.reverseMenu(ignoreId, menu.getId(), children);
			if (children.size() > 0) {
				data.put("children", children);
			}
			datas.add(data);
		}
	}

	@Before(Tx.class)
	public void del(int id) throws SlothException {
		long count = Db.queryLong(Db.getSqlPara("menu.findSubCount").getSql(), id);
		if (count > 0) {
			throw new SlothException(30001);
		}
		Db.update(Db.getSqlPara("menu.deleteRoleMenuByMenuId", Kv.by("menuId", id)));
		Db.update(Db.getSqlPara("menu.deleteFunctionByMenuId", Kv.by("menuId", id)));
		menuDao.deleteById(id);
	}

	private void setSeqAndLv(Menu menu) {
		Menu parent = this.findById(menu.getPid());
		int lv = parent == null ? 1 : parent.getLv() + 1;
		SqlPara sql = Db.getSqlPara(menu.getId() != null ? "menu.findMaxSeq2" : "menu.findMaxSeq1");
		int seq = 0;
		if (menu.getId() != null) {
			seq = Db.queryInt(sql.getSql(), menu.getPid(), menu.getId()) + 1;
			Menu tmp = this.findById(menu.getId());
			seq = tmp.getPid().equals(menu.getPid()) ? tmp.getSeq() : seq;
		} else {
			seq = Db.queryInt(sql.getSql(), menu.getPid()) + 1;
		}
		menu.setLv(lv);
		menu.setSeq(seq);
	}

	public List<Menu> findMenuByRoleId(String roleId) {
		List<Menu> menus = menuDao.find(Db.getSqlPara("menu.findByRoleId", Kv.by("roleId", roleId)));
		return menus;
	}

	// direct > 0 向下
	public void move(String id, int direct) {
		Menu menu = menuDao.findById(id);
		Kv data = Kv.by("id", id).set("pid", menu.getPid()).set("direct", direct).set("seq", menu.getSeq());
		Menu nearMenu = menuDao.findFirst(menuDao.getSqlPara("menu.findNearBy", data));
		if (nearMenu == null)
			return;
		int tmpSeq = menu.getSeq();
		menu.setSeq(nearMenu.getSeq());
		nearMenu.setSeq(tmpSeq);
		menu.update();
		nearMenu.update();
	}
}