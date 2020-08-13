package com.sloth.sys.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.aop.Aop;
import com.jfinal.handler.Handler;
import com.jfinal.kit.PropKit;
import com.sloth.service.ConfigService;
import com.sloth.sys.util.CtxUtil;

public class GlobalHandler extends Handler {
	private ConfigService configService = Aop.get(ConfigService.class);

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		request.setAttribute("currentUser", CtxUtil.getCurrentUser());
		request.setAttribute("projectName", configService.findValueByCode("project.name"));
		request.setAttribute("projectLogo", configService.findValueByCode("project.logo"));
		request.setAttribute("isDevUser", CtxUtil.isDevUser());
		request.setAttribute("devMode", PropKit.getBoolean("devMode", false));
		next.handle(target, request, response, isHandled);
		response.addHeader("Access-Control-Allow-Origin", "*");
	}
}