package com.sloth.sys.handler;

import java.lang.reflect.Method;

import org.apache.shiro.aop.MethodInvocation;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.aop.AnnotationsAuthorizingMethodInterceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.sloth.sys.util.CtxUtil;

public class ShiroInterceptor extends AnnotationsAuthorizingMethodInterceptor implements Interceptor {

	public ShiroInterceptor() {
		getMethodInterceptors(); // 用来扩展其他注解
	}

	@Override
	public void intercept(final Invocation inv) {
		try {
			invoke(new MethodInvocation() {
				@Override
				public Object proceed() throws Throwable {
					inv.invoke();
					return inv.getReturnValue();
				}

				@Override
				public Method getMethod() {
					return inv.getMethod();
				}

				@Override
				public Object[] getArguments() {
					return inv.getArgs();
				}

				@Override
				public Object getThis() {
					return inv.getController();
				}
			});
		} catch (Throwable e) {
			if (e instanceof AuthorizationException) {
				doProcessuUnauthorization(inv.getController());
			} else {
				e.printStackTrace();
				inv.getController().renderError(500);
			}
		}
	}

	/* 未授权处理 */
	private void doProcessuUnauthorization(Controller controller) {
		if (CtxUtil.getCurrentUser() == null) {
			controller.redirect(PropKit.get("loginPage"));
		} else {
			controller.renderError(401);
		}
	}
}