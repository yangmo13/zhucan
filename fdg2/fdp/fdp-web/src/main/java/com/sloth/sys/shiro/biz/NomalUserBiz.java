package com.sloth.sys.shiro.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.jfinal.aop.Aop;
import com.sloth.model.Role;
import com.sloth.model.User;
import com.sloth.service.RoleService;
import com.sloth.sys.util.CtxUtil;

public class NomalUserBiz implements IUserBiz {
	private RoleService roleService = Aop.get(RoleService.class);

	@Override
	public void handle(User user, SimpleAuthorizationInfo info) {
		List<Role> roles = roleService.findByUserId(user.getId());
		List<String> roleids = new ArrayList<>();
		for (Role role : roles) {
			info.addRole(role.getCode());
			roleids.add(role.getId());
		}
		List<String> permissions = roleService.findPermissions(roleids);
		info.addStringPermissions(permissions);
	}
	
	public List<Map<String, Object>> findMenusForMe() {
		return menuService.findByUserid(CtxUtil.getCurrentUser().getId());
	}
}