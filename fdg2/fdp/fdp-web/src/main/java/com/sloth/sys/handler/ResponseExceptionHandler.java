package com.sloth.sys.handler;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.sloth.common.AjaxData;
/**
 * 全局异常处理
 * @author 郭翔宇
 *
 */
public class ResponseExceptionHandler implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		try {
			inv.invoke();
		}catch(Exception e) {
			e.printStackTrace();
			inv.getController().renderJson(new AjaxData(50000,e.getMessage()));
		}
	}

}
