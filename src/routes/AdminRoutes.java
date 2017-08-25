package routes;

import com.jfinal.config.Routes;

import controllers.AdminUserController;

/**
 * 
 */
public class AdminRoutes extends Routes {

	@Override
	public void config() {
		add("/admin", AdminUserController.class);
	}

}
