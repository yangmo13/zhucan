package com.fdp.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.jfinal.aop.Aop;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.kit.Base64Kit;
import com.sloth.common.AjaxData;
import com.sloth.model.Dept;
import com.sloth.model.User;
import com.sloth.service.DeptService;
import com.sloth.service.UserService;
import com.sloth.util.PwdKit;
import com.sloth.util.StringKit;

public class UserApi extends Controller {
	@Clear
	public void login(String username, String password) {
		AjaxData data = new AjaxData();
		try {
			String pwd = Base64Kit.decodeToStr(password);
			pwd = PwdKit.encrypt(username, pwd);
			User user = service.findByLogin(username, pwd);
			if (user != null) {
				user.setToken(UUID.randomUUID().toString().replace("-", ""));
				user.update();
				data.setData(this.assembleData(user));
			} else {
				data.setCode(20002);
			}
		} catch (Exception e) {
			e.printStackTrace();
			data.setCode(50000);
		}
		this.renderJson(data);
	}

	public void logout() {
		User user = getAttr("user");
		user.setToken(null);
		user.update();
		this.renderJson(new AjaxData());
	}

	public void changePwd(String oldPwd, String newPwd) {
		AjaxData data = new AjaxData();
		try {
			User user = getAttr("user");
			String pwd = Base64Kit.decodeToStr(oldPwd);
			pwd = PwdKit.encrypt(user.getUsername(), pwd);
			if (!user.getPassword().equals(pwd)) {
				data.setCode(20003);
			} else {
				String newEncryptPwd = Base64Kit.decodeToStr(newPwd);
				newEncryptPwd = PwdKit.encrypt(user.getUsername(), newEncryptPwd);
				user.setPassword(newEncryptPwd);
				user.update();
			}
		} catch (Exception e) {
			data.setCode(50000);
		}
		this.renderJson(data);
	}

	public void findMy(String username, String password) {
		AjaxData data = new AjaxData();
		User user = getAttr("user");
		data.setData(this.assembleData(user));
		this.renderJson(data);
	}

	private Map<String, Object> assembleData(User user) {
		user.remove("PASSWORD", "STATUS", "EDITABLE", "DELETABLE", "DELETED", "OP_TIME", "OP_USER_ID", "START_TIME", "END_TIME");
		Map<String, Object> datas = new HashMap<>();
		datas.put("user", user);
		if (StringKit.isNotEmpty(user.getDeptId())) {
			Dept dept = deptService.findById(user.getDeptId());
			user.setDept(dept);
		}
		return datas;
	}

	private UserService service = Aop.get(UserService.class);
	private DeptService deptService = Aop.get(DeptService.class);
}