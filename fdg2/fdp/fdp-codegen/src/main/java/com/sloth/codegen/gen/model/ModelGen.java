package com.sloth.codegen.gen.model;

import java.io.File;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.sloth.codegen.Config;
import com.sloth.codegen.gen.BaseGen;

public class ModelGen extends BaseGen {
	public void gen(TableMeta tableMeta, String modelPkg, String baseModelPkg, String modelDir) {
		Kv data = Kv.by("modelPackageName", modelPkg);
		data.set("baseModelPackageName", baseModelPkg);
		data.set("generateDaoInModel", true);
		data.set("tableMeta", tableMeta);
		this.generate("/model/model.jf", data, modelDir + File.separator + tableMeta.modelName + ".java");
	}
	
	@Override
	public void generate(TableMeta tableMeta, Config config) {
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("config", config);
		data.set("generateDaoInModel", true);
		this.generate("/model/model.jf", data, config.getModelDir() + File.separator + tableMeta.modelName + ".java");
	}
}