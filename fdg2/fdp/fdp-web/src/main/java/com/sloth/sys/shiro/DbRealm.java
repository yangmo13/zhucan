package com.sloth.sys.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.jfinal.aop.Aop;
import com.jfinal.kit.StrKit;
import com.sloth.model.User;
import com.sloth.service.UserService;
import com.sloth.sys.shiro.biz.DevUserBiz;
import com.sloth.sys.shiro.biz.IUserBiz;
import com.sloth.sys.shiro.biz.NomalUserBiz;
import com.sloth.sys.util.CtxUtil;

public class DbRealm extends AuthorizingRealm {
	public String getName() {
		return "DbRealm";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		User m = (User) principals.fromRealm(getName()).iterator().next();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		if (null == m) {
			return info;
		}
		IUserBiz userBiz;
		if (CtxUtil.isDevUser()) {
			userBiz = Aop.get(DevUserBiz.class);
		} else {
			userBiz = Aop.get(NomalUserBiz.class);
		}
		userBiz.handle(m, info);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken authcToken = (UsernamePasswordToken) token;
		if (authcToken.getUsername() == null || StrKit.isBlank(authcToken.getUsername())) {
			throw new AuthenticationException("用户名不可以为空！");
		}
		User user = null;
		if (CtxUtil.isDevMode() || (!CtxUtil.isDevMode() && !CtxUtil.isDevUsername(authcToken.getUsername()))) {
			user = Aop.get(UserService.class).findAvailableByUsername(authcToken.getUsername());
		}
		long current = System.currentTimeMillis();
		if (null == user) {
			throw new AuthenticationException("用户名或者密码错误！");
		} else if (user.getStatus() == 0) {
			throw new AuthenticationException("用户已被禁用，无法登陆！");
		} else if ((user.getStartTime() != null && user.getStartTime().getTime() > current)
				|| (user.getEndTime() != null && user.getEndTime().getTime() < current)) {
			throw new AuthenticationException("用户已过期，无法登陆！");
		} else {
			return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		}
	}
}
