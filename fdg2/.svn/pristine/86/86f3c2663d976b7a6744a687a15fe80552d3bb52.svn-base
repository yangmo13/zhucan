package com.fdp.service;


import java.util.Arrays;
import java.util.List;

import com.fdp.common.CommonService;
import com.fdp.model.ContentTmp;
import com.fdp.model.DocumentTmp;
import com.jfinal.aop.Aop;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;
import com.sloth.model.User;

public class DocumentTmpService {
	private DocumentTmp documentTmpDao = DocumentTmp.dao;
	private static ContentTmpService contentTmpService = Aop.get(ContentTmpService.class);
	private static final String[] VIDEO_TYPE = {"avi","mp4","rm","rmvb"}; 
	
	public void save(List<UploadFile> files,ContentTmp contentTmp,DocumentTmp documentTmp, User user) {
		for (UploadFile file:files) {
			System.out.println(file.getFileName());
			String[] strArr = file.getFileName().split("\\.");
			String type = strArr[strArr.length-1];		
			if(Arrays.asList(VIDEO_TYPE).contains(type)) {
				String videoPath = CommonService.uploadFile(file);//生成文件地址
				documentTmp.setVideo(videoPath);
				continue;
			}
			String imgPath = CommonService.uploadFile(file);//生成文件地址
			documentTmp.setImg(imgPath);
		}
		contentTmp.setDeleted(0);
		contentTmp.setVisible(1);
		contentTmpService.save(contentTmp, user);
		documentTmp.setId(contentTmp.getId());
		documentTmp.save();
	}

	public void del(Object id) {
		documentTmpDao.deleteById(id);
	}

	public void update(DocumentTmp documentTmp) {
		documentTmp.update();
	}

	public Record findById(Integer id) {
		Kv kv = Kv.by("ID", id);
		Record findFirst = Db.template("documentTmp.find", kv).findFirst();
		return findFirst;
	}
	/**
	 * 查看列表
	 * @param documentTmp
	 * @param contentTmp
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page<Record> find(DocumentTmp documentTmp,ContentTmp contentTmp, int pageNo, int pageSize,String type) {
		Kv kv = Kv.by("documentTmp", documentTmp).set("contentTmp",contentTmp).set("TYPE",type);
		Page<Record> paginate = Db.template("documentTmp.find", kv).paginate(pageNo, pageSize);
		return paginate;
	}
}