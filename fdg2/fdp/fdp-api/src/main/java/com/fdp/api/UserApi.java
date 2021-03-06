package com.fdp.api;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fdp.model.Archive;
import com.fdp.service.ArchiveService;
import com.jfinal.aop.Aop;
import com.jfinal.aop.Before;
import com.jfinal.aop.Clear;
import com.jfinal.core.Controller;
import com.jfinal.kit.Base64Kit;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.wxaapp.api.WxaUserApi;
import com.sloth.common.AjaxData;
import com.sloth.model.Dept;
import com.sloth.model.TmpUser;
import com.sloth.model.User;
import com.sloth.service.DeptService;
import com.sloth.service.TmpUserService;
import com.sloth.service.UserService;
import com.sloth.util.PwdKit;
import com.sloth.util.StringKit;

public class UserApi extends Controller {
	@Clear
	// 微信登陆
	public void wxLogin(String code) {
		AjaxData data = new AjaxData();
		ApiResult apiResult = WxaUserApi.getSessionKey(code);
		if (apiResult.getStr("openid") == null) {
			data.setCode(20002);// 微信登陆失败
			this.renderJson(data);
			return;
		}
		String openid = apiResult.getStr("openid");
		User wxUser = service.findByOpenid(openid);
		TmpUser tmpUser = Aop.get(TmpUserService.class).findByOpenid(openid);
		if (wxUser == null) {
			if (tmpUser == null) {
				tmpUser = new TmpUser();
				tmpUser.setOpenid(openid);
				tmpUser.setToken(apiResult.getStr("session_key"));
				tmpUser.setInfoCompleted(0);
				tmpUser.setOpTime(new Date());
				tmpUser.save();
			}
			data.setData(tmpUser);
		} else {
			data.setData(wxUser);
		}
		this.renderJson(this.assembleData(wxUser, tmpUser));
	}

	public void bind(String username, String password) {
		AjaxData data = new AjaxData();
		try {
			TmpUser tmpUser = getAttr("tmpUser");
			String pwd = Base64Kit.decodeToStr(password);
			pwd = PwdKit.encrypt(username, pwd);
			User user = service.findByLogin(username, pwd);
			if (user != null) {
				user.setOpTime(new Date());
				user.setToken(tmpUser.getToken());
				user.setOpenid(tmpUser.getOpenid());
				user.setInfoCompleted(1);
				user.update();
				data.setData(this.assembleData(user, tmpUser));
			} else {
				data.setCode(20005);
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

	public void findMy(String username, String password) {
		AjaxData data = new AjaxData();
		User user = getAttr("user");
		TmpUser tmpUser = getAttr("tmpUser");
		data.setData(this.assembleData(user, tmpUser));
		this.renderJson(data);
	}

	public void match(String idCard) {
		AjaxData data = new AjaxData();
		data.setData(Aop.get(ArchiveService.class).findByIdCard(idCard));
		this.renderJson(data);
	}

	@Before(Tx.class)
	public void supply(Archive archive) {
		AjaxData data = new AjaxData();
		try {
			TmpUser tmpUser = getAttr("tmpUser");
			User user = getAttr("user");
			archiveService.supply(archive, tmpUser, user);
		} catch (Exception e) {
			e.printStackTrace();
			data.setCode(50000);
		}
	}

	private Map<String, Object> assembleData(User user, TmpUser tmpUser) {
		Map<String, Object> datas = new HashMap<>();
		if (user != null) {
			user.remove("PASSWORD", "STATUS", "EDITABLE", "DELETABLE", "DELETED", "VISIBLE", "OP_TIME", "OP_USER_ID", "START_TIME", "END_TIME");
			if (user.getRefArchiveId() != null) {
				datas.put("archive", Aop.get(ArchiveService.class).findById(user.getRefArchiveId()));
			}
			datas.put("user", user);
			if (StringKit.isNotEmpty(user.getDeptId())) {
				Dept dept = deptService.findById(user.getDeptId());
				user.setDept(dept);
			}
		} else {
			datas.put("user", tmpUser);
		}
		return datas;
	}

	private UserService service = Aop.get(UserService.class);
	private DeptService deptService = Aop.get(DeptService.class);
	private ArchiveService archiveService = Aop.get(ArchiveService.class);
}