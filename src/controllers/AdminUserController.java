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

	public void save() {
		User user = new User();
		user.setStudentId(getParaToLong("studentId"));
		user.setUserDesc(getPara("userDesc"));
		user.setUserEmail(getPara("userEmail"));
		user.setUserGender(getPara("userGender"));
		user.setUserQq(getParaToLong("userQq"));
		user.setUserTel(getParaToLong("userTel"));
		user.setUserName(getPara("userName"));
		user.setApplyTime(DateHelper.getDateTime());
		boolean saveSuccess = user.save();
		setAttr("status", saveSuccess);
		renderJson();
	}

	public void delete() {
		int userId = getParaToInt("userId");
		boolean deleteSuccess = User.dao.deleteById(userId);
		setAttr("status", deleteSuccess);
		renderJson();
	}

	public void update() {
		User user = new User();
		user.setStudentId(getParaToLong("studentId"));
		user.setUserDesc(getPara("userDesc"));
		user.setUserEmail(getPara("userEmail"));
		user.setUserGender(getPara("userGender"));
		user.setUserQq(getParaToLong("userQq"));
		user.setUserTel(getParaToLong("userTel"));
		user.setUserName(getPara("userName"));
		user.setApplyTime(DateHelper.getDateTime());
		boolean updateSuccess = user.update();
		setAttr("status", updateSuccess);
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
		setAttr("status",status);
		renderJson();
	}

	public void selectList() {

		String account = getPara("account");
		String password = getPara("password");

		boolean status = false;
		if ("zhangjianshun".equals(account) && "growthbar".equals(password)) {
			List<User> userList = User.dao.find("SELECT * FROM user");
			setAttr("users", userList);
			status = true;
		}
		setAttr("status",status);
		renderJson();
	}
}
