package com.sloth.common;

import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

public interface Module {
	void configRoutes(Routes me);

	void configMappings(ActiveRecordPlugin arp);

	default String getDbKey() {
		return null;
	}

	default boolean isDefault() {
		return getDbKey() == null;
	}

	default Routes newRoutes(String viewPath, String url, Class<? extends Controller> cls) {
		return new Routes() {
			@Override
			public void config() {
				this.setBaseViewPath(viewPath);
				this.add(url, cls);
			}
		};
	}
}