
import java.util.List;

import com.fdp.module.UserModule;
import com.jfinal.server.undertow.UndertowServer;
import com.sloth.AbsConfig;
import com.sloth.common.Module;

public class Boot extends AbsConfig {
	public static void main(String[] args) {
		UndertowServer.create(Boot.class).start();
	}

	@Override
	public void configModules(List<Module> modules) {
		modules.add(new UserModule());
	}
}