package com.sloth.sys.handler;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.sloth.sys.util.NetKit;

public class IpAop implements Interceptor {
	private List<String> ips;

	public IpAop() {
		this.ips = new ArrayList<>();
		String ipStr = PropKit.get("validIps");
		if (ipStr == null || ipStr.trim().equals(""))
			return;
		String[] ipArr = ipStr.split(",");
		for (String ip : ipArr) {
			ips.add(ip.trim());
		}
	}

	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		String ip = NetKit.getIp(c.getRequest());
		if (ips.contains(ip)) {
			inv.invoke();
		} else {
			c.renderError(401);
		}
	}
}