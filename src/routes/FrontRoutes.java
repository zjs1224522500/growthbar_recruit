package routes;

import com.jfinal.config.Routes;

import controllers.IndexController;
import controllers.UserController;

/**
 *
 */
public class FrontRoutes extends Routes {

	@Override
	public void config() {
		add("/", IndexController.class);
		add("/recruit", UserController.class);
	}

}
