package com.sloth.codegen.gen.normal;

import java.io.File;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.sloth.codegen.Config;
import com.sloth.codegen.gen.BaseGen;

public class ControllerGen extends BaseGen {
	public void gen(TableMeta tableMeta, String ctlPkg, String ctlDir, String modelPkg, String servicePkg) {
		Kv data = Kv.by("controllerPackageName", ctlPkg);
		data.set("modelPackageName", modelPkg);
		data.set("servicePackageName", servicePkg);
		data.set("tableMeta", tableMeta);
		this.generate("/normal/contoller.jf", data, ctlDir + File.separator + tableMeta.modelName + "Controller.java");
	}
	
	@Override
	public void generate(TableMeta tableMeta, Config config) {
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("config", config);
		this.generate("/normal/contoller.jf", data, config.getCtlDir() + File.separator + tableMeta.modelName + "Controller.java");
	}
}