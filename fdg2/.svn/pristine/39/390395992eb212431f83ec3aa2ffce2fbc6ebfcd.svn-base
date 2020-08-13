package com.sloth.sys.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;

import com.jfinal.aop.Aop;
import com.jfinal.kit.PropKit;
import com.sloth.model.User;
import com.sloth.service.DictService;

public class CtxUtil {
	public static User getCurrentUser() {
		if (SecurityUtils.getSubject() == null)
			return null;
		return (User) SecurityUtils.getSubject().getPrincipal();
	}

	public static boolean isDevUser() {
		User user = getCurrentUser();
		if (user != null && isDevMode() && isDevUsername(user.getUsername())) {
			return true;
		}
		return false;
	}

	public static boolean isDevMode() {
		return PropKit.getBoolean("devMode", false);
	}

	public static boolean isDevUsername(String username) {
		return "dev".equals(username);
	}

	private static Map<String, String> mappings = new HashMap<>();

	public static void setColumn(String module, String dictCode, String column) {
		mappings.put(module + "." + Aop.get(DictService.class).findByCode(dictCode).getId(), column);
	}

	public static String getColumn(String module, Integer id) {
		return mappings.get(module + "." + id);
	}
}