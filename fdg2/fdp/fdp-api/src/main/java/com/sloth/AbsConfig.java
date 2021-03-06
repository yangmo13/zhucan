package com.sloth;

import java.util.ArrayList;
import java.util.List;

import com.fdp.aop.AuthInterceptor;
import com.fdp.aop.GlobalHandler;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.Const;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.proxy.CglibProxyFactory;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.wxaapp.WxaConfig;
import com.jfinal.wxaapp.WxaConfigKit;
import com.sloth.common.Module;

public abstract class AbsConfig extends JFinalConfig {
	private List<Module> modules = new ArrayList<>();

	public AbsConfig() {
		this.configModules(modules);
	}

	public abstract void configModules(List<Module> modules);

	public void configConstant(Constants me) {
		PropKit.use("config.txt");
		me.setProxyFactory(new CglibProxyFactory());
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setJsonFactory(new FastJsonFactory());
		me.setMaxPostSize(10 * Const.DEFAULT_MAX_POST_SIZE);
		ApiConfigKit.setDevMode(me.getDevMode());
	}

	public final void configRoute(Routes me) {
		for (Module module : modules) {
			module.configRoutes(me);
		}
	}

	public void configEngine(Engine me) {
	}

	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbc.url"), PropKit.get("jdbc.user"), PropKit.get("jdbc.pwd").trim());
	}

	public void configPlugin(Plugins me) {
		DruidPlugin druidPlugin = createDruidPlugin();
		me.add(druidPlugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		BaseMappingKit.mapping(arp);
		me.add(arp);
		arp.setBaseSqlTemplatePath("sqlfiles");
		arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
		arp.setShowSql(PropKit.getBoolean("showSql", false));
		for (Module module : modules) {
			module.configMappings(arp);
		}
	}

	public void configInterceptor(Interceptors me) {
		me.add(new AuthInterceptor());
	}

	public void configHandler(Handlers me) {
		me.add(new GlobalHandler());
		me.add(new ContextPathHandler("base"));
	}
	
	@Override
	public void onStart() {
		WxaConfig wc = new WxaConfig();
		wc.setAppId("wx2e1a595e9a89b33b");
		wc.setAppSecret("ce851967b15175abbbd07194467f46ca");
		WxaConfigKit.setWxaConfig(wc);
	}
}