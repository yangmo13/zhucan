package com.sloth.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;

import com.jfinal.aop.Aop;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.sloth.common.AjaxData;
import com.sloth.service.UserService;
import com.sloth.sys.util.CtxUtil;
import com.sloth.util.PwdKit;

public class IndexController extends Controller {
	@RequiresAuthentication
	public void index() {
		String homeUrl = PropKit.get("homeUrl");
		homeUrl = homeUrl.startsWith("/") ? homeUrl.substring(1) : homeUrl;
		setAttr("homeUrl", homeUrl);
		render("index/index.html");
	}

	@RequiresAuthentication
	public void setting() {
		render("index/setting.html");
	}

	@RequiresGuest
	public void goLogin() {
		render("login.html");
	}

	@RequiresGuest
	public void doLogin(String username, String password, boolean rememberMe) {
		AjaxData ajaxData = new AjaxData();
		try {
			UsernamePasswordToken token = new UsernamePasswordToken(username, PwdKit.encrypt(username, password),
					rememberMe);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);// 进行用用户名和密码验证,如果验证不过会throw exception
		} catch (Exception e) {
			ajaxData.setCode(20001);
			if (e instanceof IncorrectCredentialsException) {
				ajaxData.setMsg("用户名或密码错误！");
			} else {
				ajaxData.setMsg(e.getMessage());
			}
		}
		try {
			renderJson(ajaxData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequiresAuthentication
	public void changePsw(String oldPassword, String newPassword) {
		AjaxData ajaxData = new AjaxData();
		UserService userService = Aop.get(UserService.class);
		if (!userService.checkPassword(CtxUtil.getCurrentUser().getUsername(),
				PwdKit.encrypt(CtxUtil.getCurrentUser().getUsername(), oldPassword))) {
			ajaxData.setCode(20002);
		} else {
			userService.changePassword(CtxUtil.getCurrentUser().getId(), newPassword);
		}
		renderJson(ajaxData);
	}

	@RequiresGuest
	public void logout() {
		SecurityUtils.getSubject().logout();
		render("login.html");
	}

	public void p404() {
		render("/common/_404.html");
	}
}