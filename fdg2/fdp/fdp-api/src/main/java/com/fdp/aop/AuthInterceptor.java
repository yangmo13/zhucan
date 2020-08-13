package com.fdp.aop;

import com.jfinal.aop.Aop;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.sloth.common.AjaxData;
import com.sloth.model.User;
import com.sloth.service.UserService;
import com.sloth.util.StringKit;

public class AuthInterceptor implements Interceptor {
	@Override
	public void intercept(Invocation inv) {
		String token = inv.getController().getHeader("token");
		User user;
		if (StringKit.isEmpty(token) || (user = service.findByToken(token)) == null) {
			AjaxData ajaxData = new AjaxData();
			ajaxData.setCode(20001);
			inv.getController().renderJson(ajaxData);
		} else {
			inv.getController().setAttr("user", user);
			inv.invoke();
		}
	}

	private UserService service = Aop.get(UserService.class);
}