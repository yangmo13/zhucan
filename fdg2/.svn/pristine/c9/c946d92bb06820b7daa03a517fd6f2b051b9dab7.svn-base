package com.sloth.codegen.gen.base;

import java.io.File;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.sloth.codegen.Config;
import com.sloth.codegen.gen.BaseGen;

public class ModuleGen extends BaseGen {
	public void gen(TableMeta tableMeta, String moduleName, String pkg, String dir, String ctlPkg, String modelPkg) {
		Kv data = Kv.by("pkg", pkg);
		data.set("ctlPkg", ctlPkg);
		data.set("modelPkg", modelPkg);
		data.set("moduleName", moduleName);
		data.set("tableMeta", tableMeta);
		this.generate("/base/module.jf", data, dir + File.separator + tableMeta.modelName + "Module.java");
	}

	@Override
	public void generate(TableMeta tableMeta, Config config) {
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("config", config);
		this.generate("/base/module.jf", data, config.getModuleDir() + File.separator + tableMeta.modelName + "Module.java");
	}
}