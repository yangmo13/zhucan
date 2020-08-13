package com.fdp.model;

import com.fdp.model.base.BaseContent;

@SuppressWarnings("serial")
public class Content extends BaseContent<Content> {
	public static final Content dao = new Content().dao();
}