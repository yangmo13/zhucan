package com.fdp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fdp.common.AuditSubService;
import com.fdp.model.ContentTmp;
import com.jfinal.aop.Aop;
import com.jfinal.aop.Before;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.sloth.model.Dict;
import com.sloth.model.User;
import com.sloth.service.DictService;
import com.sloth.sys.util.CtxUtil;

public class AuditService {
	/**
	 * 内容审核
	 * @param id 内容ID
	 * @param access 审核是否通过
	 * @param remark 审核说明
	 */
	@Before(Tx.class)
	public void audit(Long id, boolean access, String remark) throws Exception {
		ContentTmp tmp = contentTmpService.findById(id);
		AuditSubService subService = this.serviceMap.get(tmp.getType());
		if (subService == null) {
			Dict dict = dictService.findByValue("fdp.contentType", tmp.getType());
			if (dict == null) {
				throw new Exception(String.format("未知的内容类别【fdp.contentType】：%s！", tmp.getType()));
			} else {
				throw new Exception(String.format("【%s】内容审核功能暂未实现！", dict.getTitle())) ;
			}
		}
		tmp.setStatus(access ? "4" : "2");
		tmp.setAuditRemark(remark);
		tmp.setAuditTime(new Date());
		// 以下是设置审核人信息
		User user = CtxUtil.getCurrentUser();
		tmp.setAuditorOrgId(-1l);// TODO 王大卫 这里设置用户所属机构ID及名称
		tmp.setAuditorOrgName("");
		tmp.setAuditorId(user.getId());
		tmp.setAuditorName(user.getUsername());
		contentTmpService.update(tmp);
		// TODO 王大卫 这里拷贝并保存ContentTmp到Content
		subService.doAuditSub(tmp);
	}
	
	public AuditService() {
		this.serviceMap.put("C001", null);// 康复活动
		this.serviceMap.put("C002", null);// 培训活动
		this.serviceMap.put("C003", null);// 培训资料
		this.serviceMap.put("C004", null);// 康复资料
		this.serviceMap.put("C005", null);// 康复器具
		this.serviceMap.put("C006", null);// 辅助器具
		this.serviceMap.put("C007", null);// 文体活动
		this.serviceMap.put("C008", null);// 精彩瞬间
		this.serviceMap.put("C009", null);// 自强之星
		this.serviceMap.put("C101", null);// 党群心连心
		this.serviceMap.put("C102", null);// 法律咨询
		this.serviceMap.put("C201", null);// 通知公告
		this.serviceMap.put("C202", null);// 工作动态
		this.serviceMap.put("C203", null);// 政策法规
		this.serviceMap.put("C204", null);// 党建工作
		this.serviceMap.put("C205", null);// 组织机构
		this.serviceMap.put("C206", null);// 业务指南
		this.serviceMap.put("C301", null);// 机构信息
		this.serviceMap.put("C302", null);// 成员信息
		this.serviceMap.put("C303", null);// 职位管理
		this.serviceMap.put("C401", null);// 康复需求
		this.serviceMap.put("C402", null);// 示范体验预约
		this.serviceMap.put("C403", null);// 托养需求
		this.serviceMap.put("C404", null);// 培训需求
		this.serviceMap.put("C501", null);// 远程诊疗
		this.serviceMap.put("C502", null);// 心理咨询
	}
	
	private Map<String, AuditSubService> serviceMap = new HashMap<>();
	private ContentTmpService contentTmpService = Aop.get(ContentTmpService.class);
	private DictService dictService = Aop.get(DictService.class);
}