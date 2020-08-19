package com.fdp.service;


import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;
import com.sloth.common.DataFilter;
import com.fdp.model.Resume;

public class ResumeService {
	private Resume resumeDao = Resume.dao;

	public void save(Resume resume) {
		resume.remove("ID");
		resume.save();
	}

	public void del(Object id) {
		resumeDao.deleteById(id);
	}

	public void update(Resume resume) {
		resume.update();
	}

	public Resume findById(Object id) {
		return resumeDao.findById(id);
	}

	public Page<Resume> find(Resume resume, int pageNo, int pageSize) {
		Kv kv = Kv.by("resume", resume);
		Page<Resume> resumes = resumeDao.paginate(pageNo, pageSize, resumeDao.getSqlPara("resume.find", kv));
		return resumes;
	}

	public Page<Resume> find(Resume resume, int pageNo, int pageSize, DataFilter dataFilter) {
		Kv kv = Kv.by("resume", resume);
		dataFilter.preFilter(kv);
		Page<Resume> resumes = resumeDao.paginate(pageNo, pageSize, resumeDao.getSqlPara("resume.find", kv));
		return resumes;
	}
}