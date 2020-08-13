package com.sloth.service;

import java.util.Date;
import java.util.UUID;

import com.jfinal.aop.Aop;
import com.jfinal.aop.Before;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.common.DataFilter;
import com.sloth.model.RoleUser;
import com.sloth.model.User;
import com.sloth.util.PwdKit;
import com.sloth.util.StringKit;

public class UserService {
	private ConfigService configService = Aop.get(ConfigService.class);
	private User userDao = new User();

	public User findByLogin(String username, String password) {
		return userDao.findFirst(Db.getSqlPara("user.findByLogin", Kv.by("username", username).set("password", password)));
	}

	public User findByToken(String token) {
		return userDao.findFirst(Db.getSqlPara("user.findByToken", Kv.by("token", token)));
	}

	public User findAvailableByUsername(String username) {
		return userDao.findFirst(Db.getSqlPara("user.findAvailableByUsername", Kv.by("username", username)));
	}

	public Page<User> find(User user, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("user", user);
		dataFilter.preFilter(kv);
		Page<User> users = userDao.paginate(pageNo, pageSize, userDao.getSqlPara("user.find", kv));
		return users;
	}

	public boolean checkPassword(String username, String password) {
		Kv kv = Kv.by("username", username).set("password", password);
		User user = userDao.findFirst(Db.getSqlPara("user.findByUsernameAndPassword", kv));
		return user != null;
	}

	public void changePassword(String userId, String password) {
		User user = this.findById(userId);
		user.setPassword(PwdKit.encrypt(user.getUsername(), password));
		user.update();
	}

	public User findById(String id) {
		return userDao.findById(id);
	}

	public void lock(String id) {
		User user = this.findById(id);
		if (user == null)
			return;
		user.setStatus(0);
		user.update();
	}

	public void unlock(String id) {
		User user = this.findById(id);
		if (user == null)
			return;
		user.setStatus(1);
		user.update();
	}

	@Before(Tx.class)
	public void update(User user, String roleids) {
		user.remove("deletable", "editable", "deleted", "stauts", "password", "username");
		User tmp = this.findById(user.getId());
		tmp._setAttrs(user);
		tmp.update();
		this.updateRoleUser(user.getId(), roleids);
	}

	@Before(Tx.class)
	public void add(User user, String roleids) {
		user.setId(UUID.randomUUID().toString());
		user.setDeletable(1);
		user.setEditable(1);
		user.setDeleted(0);
		user.setStatus(1);
		user.setPassword(PwdKit.encrypt(user.getUsername(), configService.findValueByCode("user.defaultPwd")));
		user.setOpTime(new Date());
		user.save();
		this.updateRoleUser(user.getId(), roleids);
	}

	public void resetpwd(String id) {
		User user = this.findById(id);
		user.setPassword(PwdKit.encrypt(user.getUsername(), configService.findValueByCode("user.defaultPwd")));
		user.update();
	}

	public void updateRoleUser(String userId, String roleids) {
		Db.update(Db.getSqlPara("user.deleteRoleUserByUserId", Kv.by("userId", userId)));
		if (StringKit.isEmpty(roleids)) {
			return;
		}
		String[] roleIds = roleids.split(",");
		for (String roleId : roleIds) {
			if (roleId.equals("1")) {
				continue;
			}
			RoleUser roleUser = new RoleUser();
			roleUser.setId(UUID.randomUUID().toString());
			roleUser.setRoleId(roleId);
			roleUser.setUserId(userId);
			roleUser.save();
		}
	}

	@Before(Tx.class)
	public void del(String id) {
		Db.update(Db.getSqlPara("user.deleteRoleUserByUserId", Kv.by("userId", id)));
		userDao.deleteById(id);
	}
}