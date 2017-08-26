package controllers;

import com.jfinal.core.Controller;

import common.model.User;

import java.util.List;

import util.DateHelper;

/**
 * Version:v1.0 (description:  )
 */
public class AdminUserController extends Controller {

	public void index() {
		render("admin.html");
	}

	public void delete() {

		String account = getPara("account");
		String password = getPara("password");

		boolean status = false;
		if ("zhangjianshun".equals(account) && "growthbar".equals(password)) {
			int userId = getParaToInt("userId");
			status = User.dao.deleteById(userId);
		}
		setAttr("status", status);
		renderJson();
	}

	public void update() {
		User user = new User();
		user.setUserId(getParaToInt("userId"));
		user.setStudentId(getParaToLong("studentId"));
		user.setUserDesc(getPara("userDesc"));
		user.setUserEmail(getPara("userEmail"));
		user.setUserGender(getPara("userGender"));
		user.setUserQq(getParaToLong("userQQ"));
		user.setUserTel(getParaToLong("userTel"));
		user.setUserName(getPara("userName"));
		user.setApplyTime(DateHelper.getDateTime());

		String account = getPara("account");
		String password = getPara("password");

		boolean status = false;
		if ("zhangjianshun".equals(account) && "growthbar".equals(password)) {
			status = user.update();
		}
		setAttr("status", status);
		renderJson();
	}

	public void select() {
		int userId = getParaToInt("userId");
		String account = getPara("account");
		String password = getPara("password");

		boolean status = false;
		if ("zhangjianshun".equals(account) && "growthbar".equals(password)) {
			User user = User.dao.findById(userId);
			status = true;
			setAttr("user", user);
		}
		setAttr("status", status);
		renderJson();
	}

	public void selectList() {

		String account = getPara("account");
		String password = getPara("password");

		boolean status = false;
		if ("zhangjianshun".equals(account) && "growthbar".equals(password)) {
			List<User> userList = User.dao.find("SELECT * FROM user ORDER BY apply_time DESC");
			setAttr("users", userList);
			status = true;
		}
		setAttr("status", status);
		renderJson();
	}
}
