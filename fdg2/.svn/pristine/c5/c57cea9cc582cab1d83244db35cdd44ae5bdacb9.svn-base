package com.sloth.codegen.gen.model;

import java.io.File;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.sloth.codegen.Config;
import com.sloth.codegen.gen.BaseGen;

public class ServiceGen extends BaseGen {
	public void gen(TableMeta tableMeta, String servicePkg, String serviceDir, String sqlDir, String modelPkg, String idStrategy) {
		Kv data = Kv.by("servicePackageName", servicePkg);
		data.set("modelPackageName", modelPkg);
		data.set("tableMeta", tableMeta);
		data.set("supportDataAuth", supportDataAuth(tableMeta));
		data.set("idStrategy", idStrategy);
		this.generate("/model/service.jf", data, serviceDir + File.separator + tableMeta.modelName + "Service.java");
		this.generate("/model/sql.jf", data, sqlDir + File.separator + StrKit.firstCharToLowerCase(tableMeta.modelName) + ".sql");
	}
	
	@Override
	public void generate(TableMeta tableMeta, Config config) {
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("config", config);
		this.generate("/model/service.jf", data, config.getServiceDir() + File.separator + tableMeta.modelName + "Service.java");
		this.generate("/model/sql.jf", data, config.getSqlDir() + File.separator + StrKit.firstCharToLowerCase(tableMeta.modelName) + ".sql");
	}

	private boolean supportDataAuth(TableMeta tableMeta) {
		boolean includeOpUserId = false;
		boolean includeDeptId = false;
		for (ColumnMeta columnMeta : tableMeta.columnMetas) {
			if (columnMeta.name.equals("OP_USER_ID")) {
				includeOpUserId = true;
			}
			if (columnMeta.name.equals("DEPT_ID")) {
				includeDeptId = true;
			}
		}
		return includeOpUserId && includeDeptId;
	}
}