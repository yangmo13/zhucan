package com.sloth.codegen;

import java.text.MessageFormat;
import java.util.List;

import javax.sql.DataSource;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.generator.MetaBuilder;
import com.jfinal.plugin.activerecord.generator.TableMeta;
import com.jfinal.plugin.druid.DruidPlugin;
import com.sloth.codegen.gen.base.ModuleGen;
import com.sloth.codegen.gen.model.BaseModelGen;
import com.sloth.codegen.gen.model.ModelGen;
import com.sloth.codegen.gen.model.ServiceGen;
import com.sloth.codegen.gen.normal.ControllerGen;
import com.sloth.codegen.gen.normal.ViewGen;

public class Boot {
	private static BaseModelGen baseModelGen = new BaseModelGen();
	private static ModelGen modelGen = new ModelGen();
	private static ServiceGen serviceGen = new ServiceGen();
	private static ControllerGen controllerGen = new ControllerGen();
	private static ViewGen viewGen = new ViewGen();
	private static ModuleGen moduleGen = new ModuleGen();

	public static void main(String[] args) {
		String[] tablenames = { "F_ARCHIVE" };
		Config config = new Config("fdp", "fdp").build("D:/temp/gen/");
		config.setIdStrategy("native");
		gencode(config, tablenames);
	}

	public static void gencode(Config config, String... tablenames) {
		long s = System.currentTimeMillis();
		DataSource dataSource = getDataSource();
		MetaBuilder metaBuilder = new SlothMetaBuilder(dataSource, tablenames);
		metaBuilder.setRemovedTableNamePrefixes("f_");
		metaBuilder.setGenerateRemarks(true);
		List<TableMeta> tableMetas = metaBuilder.build();
		for (TableMeta tableMeta : tableMetas) {
			baseModelGen.generate(tableMeta, config);
			modelGen.generate(tableMeta, config);
			serviceGen.generate(tableMeta, config);
			controllerGen.generate(tableMeta, config);
			viewGen.generate(tableMeta, config);
			moduleGen.generate(tableMeta, config);
		}
		long e = System.currentTimeMillis();
		double inteval = (e - s) / 1000.0;
		System.out.println(MessageFormat.format("生成完成，共耗时{0}秒！！！", inteval));
	}

	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.user"), PropKit.get("jdbc.pwd").trim());
	}

	public static DataSource getDataSource() {
		PropKit.use("config.txt");
		DruidPlugin druidPlugin = createDruidPlugin();
		druidPlugin.start();
		return druidPlugin.getDataSource();
	}
}