
import java.util.List;

import com.fdp.module.ArchiveModule;
import com.fdp.module.ArticleTmpModule;
import com.fdp.module.CommonModule;
import com.fdp.module.ContentTmpModule;
import com.jfinal.server.undertow.UndertowServer;
import com.sloth.AbsConfig;
import com.sloth.common.Module;

public class Boot extends AbsConfig {
	public static void main(String[] args) {
		UndertowServer.create(Boot.class).configWeb(builder -> {
			builder.addFilter("shiro", "org.apache.shiro.web.servlet.ShiroFilter");
			builder.addFilterUrlMapping("shiro", "/*");
			builder.addListener("org.apache.shiro.web.env.EnvironmentLoaderListener");
		}).start();
	}

	@Override
	public void configModules(List<Module> modules) {
		modules.add(new ArchiveModule());
		modules.add(new ArticleTmpModule());
		modules.add(new ContentTmpModule());
		modules.add(new CommonModule());
	}
}