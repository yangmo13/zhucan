package com.sloth.sys.shiro.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.SimpleAuthorizationInfo;

import com.jfinal.aop.Aop;
import com.sloth.model.Function;
import com.sloth.model.User;
import com.sloth.service.MenuService;

public interface IUserBiz {
	public MenuService menuService = Aop.get(MenuService.class);

	void handle(User user, SimpleAuthorizationInfo info);

	List<Map<String, Object>> findMenusForMe();
	
	public default List<Function> getDefaultFunctions(String base) {
		List<Function> functions = new ArrayList<>();
		Function function = new Function();
		function.setName("列表");
		function.setPermission(base + ":list");
		function.setSeq(0);
		functions.add(function);
		Function function1 = new Function();
		function1.setName("添加");
		function1.setPermission(base + ":add");
		function1.setSeq(1);
		functions.add(function1);
		Function function2 = new Function();
		function2.setName("编辑");
		function2.setPermission(base + ":edit");
		function2.setSeq(2);
		functions.add(function2);
		Function function3 = new Function();
		function3.setName("删除");
		function3.setPermission(base + ":del");
		function3.setSeq(3);
		functions.add(function3);
		Function function4 = new Function();
		function4.setName("查看");
		function4.setPermission(base + ":view");
		function4.setSeq(4);
		functions.add(function4);
		return functions;
	}
}