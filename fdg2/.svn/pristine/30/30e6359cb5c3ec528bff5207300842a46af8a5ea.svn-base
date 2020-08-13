package com.sloth.codegen.gen;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.JavaKeyword;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.jfinal.template.Engine;
import com.sloth.codegen.Config;
import com.sloth.codegen.kit.ResKit;

public abstract class BaseGen {
	protected JavaKeyword javaKeyword = JavaKeyword.me;
	protected Engine engine;
	
	public abstract void generate(TableMeta tableMeta, Config config);

	protected BaseGen() {
		initEngine();
	}

	protected void initEngine() {
		engine = new Engine();
		engine.setToClassPathSourceFactory();
		engine.addSharedMethod(new StrKit());
		engine.addSharedObject("getterTypeMap", getterTypeMap);
		engine.addSharedObject("javaKeyword", javaKeyword);
	}
	
	@SuppressWarnings("serial")
	protected Map<String, String> getterTypeMap = new HashMap<String, String>() {{
		put("java.lang.String", "getStr");
		put("java.lang.Integer", "getInt");
		put("java.lang.Long", "getLong");
		put("java.lang.Double", "getDouble");
		put("java.lang.Float", "getFloat");
		put("java.lang.Short", "getShort");
		put("java.lang.Byte", "getByte");
	}};

	protected void generate(String tpl, Kv data, String file) {
		String ret = engine.getTemplate(tpl).renderToString(data);
		ResKit.writeToFile(ret, file);
	}
}