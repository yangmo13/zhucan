package com.fdp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fdp.model.Archive;
import com.jfinal.aop.Aop;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.sloth.model.TmpUser;
import com.sloth.model.User;
import com.sloth.service.UserService;

public class ArchiveService {
	private Archive archiveDao = Archive.dao;

	public void save(Archive archive, String disabilityTypeCodes) {
		archive.remove("ID");
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

	public void delArchive(Object id) {
		Db.update("update f_archive set deleted=1 where id=?", Integer.parseInt(id.toString()));
	}

	//获取选中的残疾类型checkbox的code，将DisabilityType字段中的逗号拆分，放入List
	public List<Archive> findDisabilityTypeListByID(String ID) {
		String disabilityTypeCodes = archiveDao.findById(ID).getDisabilityType();
		String[] disabilityTypeCode = disabilityTypeCodes.split(",");
		List<Archive> archiveList = new ArrayList<Archive>();
		Archive archive = null;
		for (int i = 0; i < disabilityTypeCode.length; i++) {
			archive = new Archive();
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

	public Archive findByIdCard(String idCard) {
		Kv kv = Kv.by("idCard", idCard);
		return archiveDao.findFirst(archiveDao.getSqlPara("archive.findByIdCard", kv));
	}

	public void supply(Archive archive, TmpUser tmpUser, User user) {
		UserService service = Aop.get(UserService.class);
		if (user == null) {
			user = new User();
			user._setOrPut(tmpUser);
			user.setStatus(1);
			user.setEditable(1);
			user.setDeletable(1);
			user.setDeleted(0);
			user.setRealname(archive.getRealname());
			user.setInfoCompleted(1);
			service.add(user, null);
		} else {
			user.setRealname(archive.getRealname());
			user.setInfoCompleted(1);
			service.update(user, null);
		}
		archive.setIsDriver(0);
		archive.setIsDisability(1);
		archive.setRegistTime(new Date());
		archive.setRegisterId(user.getId());
		archive.setRegisterName(archive.getRealname());
		archive.setDeleted(0);
		if (user.getRefArchiveId() != null) {
			archive.save();
			user.setRefArchiveId(archive.getId());
			user.update();
		} else {
			archive.update();
		}
	}
}