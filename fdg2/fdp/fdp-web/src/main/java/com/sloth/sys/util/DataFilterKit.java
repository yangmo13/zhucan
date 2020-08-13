package com.sloth.sys.util;

import com.jfinal.aop.Aop;
import com.sloth.common.DataFilter;
import com.sloth.service.DataService;

public class DataFilterKit {
	private static DataService dataService = Aop.get(DataService.class);

	public static DataFilter get(String dataCode) {
		return new DataFilter(CtxUtil.getCurrentUser(), dataCode);
	}

	public static int getDataAuth(String dataCode) {
		return dataService.getDataAuth(CtxUtil.getCurrentUser().getId(), dataCode);
	}
}