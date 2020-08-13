package com.sloth.codegen.gen.model;

import java.io.File;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.sloth.codegen.Config;
import com.sloth.codegen.gen.BaseGen;

public class BaseModelGen extends BaseGen {
	public void gen(TableMeta tableMeta, String baseModelPkg, String baseModelDir) {
		Kv data = Kv.by("baseModelPackageName", baseModelPkg);
		data.set("generateChainSetter", false);
		data.set("tableMeta", tableMeta);
		this.generate("/model/base_model.jf", data, baseModelDir + File.separator + tableMeta.baseModelName + ".java");
	}
	
	@Override
	public void generate(TableMeta tableMeta, Config config) {
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("config", config);
		data.set("generateChainSetter", false);
		this.generate("/model/base_model.jf", data, config.getBaseModelDir() + File.separator + tableMeta.baseModelName + ".java");
	}
}