package com.fdp.service;


import com.fdp.common.CommonService;
import com.fdp.model.ArticleTmp;
import com.fdp.model.ContentTmp;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.upload.UploadFile;

public class ArticleTmpService {
	private ArticleTmp articleTmpDao = ArticleTmp.dao;
	private ContentTmp contentTmpDao = ContentTmp.dao;
	private static ContentTmpService contentTmpService = new ContentTmpService();

	/**
	 * 保存
	 * @param file
	 * @param contentTmp
	 * @param articleTmp
	 */
	public void save(UploadFile file,ContentTmp contentTmp,ArticleTmp articleTmp) {
		String filePath = CommonService.uploadFile(file);//生成图片地址
		contentTmp.setDeleted(0);
		contentTmp.setVisible(1);
		contentTmpService.save(contentTmp);
		articleTmp.setId(contentTmp.getId());
		articleTmp.setImg(filePath);
		articleTmp.save();
	}
	/**
	 * 删除
	 * @param id
	 */
	public void del(Integer id) {
		contentTmpService.del(id);
	}
	/**
	 * 修改
	 * @param contentTmp
	 */
	public void update(UploadFile file,ContentTmp contentTmp,ArticleTmp articleTmp) {
		if(file!=null) {
			String filePath = CommonService.uploadFile(file);//生成图片地址
			articleTmp.setImg(filePath);
		}
		contentTmp.update();
		articleTmp.setId(contentTmp.getId());
		articleTmp.update();
	}
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	public Record findById(Integer id,String type) {
		Kv kv = Kv.by("ID", id).set("TYPE",type);
		Record findFirst = Db.template("articleTmp.find", kv).findFirst();
		return findFirst;
	}
	/**
	 * 列表查询
	 * @param articleTmp
	 * @param fContentTmp
	 * @param pageNo
	 * @param pageSize
	 * @param dataFilter
	 * @return
	 */
	public Page<Record> find(ArticleTmp articleTmp,ContentTmp contentTmp, int pageNo, int pageSize,String type) {
		Kv kv = Kv.by("contentTmp", contentTmp).set("articleTmp",articleTmp).set("TYPE",type);
		Page<Record> contentTmps = Db.paginate(pageNo, pageSize, articleTmpDao.getSqlPara("articleTmp.find", kv));
		return contentTmps;
	}
}