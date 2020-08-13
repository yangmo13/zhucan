package com.sloth.codegen.gen.normal;

import java.io.File;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.sloth.codegen.Config;
import com.sloth.codegen.gen.BaseGen;

public class ViewGen extends BaseGen {
	public void gen(TableMeta tableMeta, String viewOutputDir) {
		String lname = StrKit.firstCharToLowerCase(tableMeta.modelName);
		String baseDir = viewOutputDir + File.separator + lname + File.separator;
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("primaryKey", getIdColumn(tableMeta));
		this.generate("/normal/list_html.jf", data, baseDir + lname + "_list.html");
		this.generate("/normal/list_js.jf", data, baseDir + lname + "_list.js");
		this.generate("/normal/edit_html.jf", data, baseDir + lname + "_edit.html");
		this.generate("/normal/edit_js.jf", data, baseDir + lname + "_edit.js");
	}

	@Override
	public void generate(TableMeta tableMeta, Config config) {
		Kv data = Kv.by("tableMeta", tableMeta);
		data.set("config", config);
		data.set("primaryKey", getIdColumn(tableMeta));
		String lname = StrKit.firstCharToLowerCase(tableMeta.modelName);
		String base = config.getViewDir() + File.separator + lname + File.separator + lname;
		this.generate("/normal/list_html.jf", data, base + "_list.html");
		this.generate("/normal/list_js.jf", data, base + "_list.js");
		this.generate("/normal/edit_html.jf", data, base + "_edit.html");
		this.generate("/normal/edit_js.jf", data, base + "_edit.js");
	}

	private String getIdColumn(TableMeta tableMeta) {
		for (ColumnMeta cm : tableMeta.columnMetas) {
			if (cm.name.equals(tableMeta.primaryKey)) {
				return cm.attrName;
			}
		}
		return null;
	}
}