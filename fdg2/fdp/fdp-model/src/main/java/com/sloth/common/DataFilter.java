package com.sloth.common;

import com.jfinal.aop.Aop;
import com.jfinal.kit.Kv;
import com.sloth.model.Dept;
import com.sloth.model.User;
import com.sloth.service.DataService;
import com.sloth.util.StringKit;

public class DataFilter {
	private static DataService dataService = Aop.get(DataService.class);
	private User user;
	private String dataCode;
	private int dataAuth;

	public DataFilter(User user, String dataCode) {
		this.user = user;
		this.dataCode = dataCode;
		this.dataAuth = dataService.getDataAuth(this.user.getId(), this.dataCode);
	}

	public void preFilter(Kv kv) {
		kv.set("dataAuth", this.dataAuth);
	}

	public void preFilter(Kv kv, String alias) {
		this.preFilter(kv);
		kv.set("alias", alias);
	}

	public User getUser() {
		return user;
	}

	public int getDataAuth() {
		return dataAuth;
	}

	/**
	 * 检查是否有该部门的操作权限
	 * 
	 * @param dept
	 *            指定部门
	 * @return true：有权限，false：无权限
	 */
	public boolean checkDept(Dept dept) {
		if (StringKit.isNotEmpty(this.user.getDeptId())) {
			if (this.dataAuth == 1) {
				return dept.getId().startsWith(this.user.getDeptId());
			} else if (this.dataAuth == 2) {
				String id = this.user.getDeptId().substring(0, 3);
				return dept.getId().startsWith(id);
			}
		}
		return true;
	}
}