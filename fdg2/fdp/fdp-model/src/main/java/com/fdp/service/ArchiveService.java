package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;

import java.util.ArrayList;
import java.util.List;

import com.fdp.model.Archive;

/**
 * @author sdw
 *
 */
/**
 * @author sdw
 *
 */
/**
 * @author sdw
 *
 */
public class ArchiveService {
	private Archive archiveDao = Archive.dao;

	public void save(Archive archive,String disabilityTypeCodes) {
		archive.remove("ID");
		
//		userService.add(user, roleids);
//		renderJson(new AjaxData());
		
		archive.setDisabilityType(disabilityTypeCodes);
		
		archive.save();
	}

	public void del(Object id) {
		archiveDao.deleteById(id);
	}

	public void update(Archive archive) {
		archive.update();
	}

	public Archive findById(Object id) {
		return archiveDao.findById(id);
	}
	
	//获取选中的残疾类型checkbox的code，将DisabilityType字段中的逗号拆分，放入List
	public List<Archive> findDisabilityTypeListByID(String ID)
	{
		String disabilityTypeCodes= archiveDao.findById(ID).getDisabilityType();
		String[] disabilityTypeCode=disabilityTypeCodes.split(",");
		
		List<Archive> archiveList=new ArrayList<Archive>();
		Archive archive=null;
		
		for (int i = 0; i < disabilityTypeCode.length; i++) {
			archive=new Archive();
			archive.setDisabilityType(disabilityTypeCode[i]);
			
			archiveList.add(archive);
		}
		
		return archiveList;
	}

	public Page<Archive> find(Archive archive, int pageNo, int pageSize) {
		Kv kv = Kv.by("archive", archive);
		Page<Archive> archives = archiveDao.paginate(pageNo, pageSize, archiveDao.getSqlPara("archive.find", kv));
		return archives;
	}

	public Page<Archive> find(Archive archive, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("archive", archive);
		dataFilter.preFilter(kv);
		Page<Archive> archives = archiveDao.paginate(pageNo, pageSize, archiveDao.getSqlPara("archive.find", kv));
		return archives;
	}
	
	public List<Archive> findDisabilityTypeByID(String ID)
	{
		return archiveDao.find("select DISABILITY_TYPE from archive where id='"+ID+"'");
	}
}