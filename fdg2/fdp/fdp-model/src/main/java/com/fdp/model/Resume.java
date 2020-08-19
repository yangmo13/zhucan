package com.fdp.model;

import com.fdp.model.base.BaseResume;

@SuppressWarnings("serial")
public class Resume extends BaseResume<Resume> {
	public static final Resume dao = new Resume().dao();
}