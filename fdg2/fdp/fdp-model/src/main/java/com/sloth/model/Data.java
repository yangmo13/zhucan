package com.sloth.model;

import com.sloth.model.base.BaseData;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Data extends BaseData<Data> {
	public static final Data dao = new Data().dao();

	public Integer getDataAuth() {
		return getInt("DATA_AUTH");
	}
}