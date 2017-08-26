package controllers;

import com.jfinal.core.Controller;

import common.model.User;

import util.DateHelper;
import util.ReflectUtil;
import util.StringHelper;

/**
 * Version:v1.0 (description:  )
 */
public class UserController extends Controller {

	// 邮箱格式正则表达式
	private String emailRegEx = "\\w+\\x40\\w+\\x2e\\w+";

	private String numRegEx = "^[0-9]*$";

	private String phoneRegEx = "^\\d{11}$";

	private String stuIdRegEx = "^\\d{13}$";

	private String letterRegEx = "^[A-Z]+$";

	public void index() {
		render("form.html");
	}

	public void save() throws Exception {
		User user = new User();

		String studentId = getPara("studentId");
		Long stuId = studentId.length() == 13 && studentId.matches(stuIdRegEx) ?
				Long.valueOf(studentId) :
				null;

		String desc = getPara("userDesc");
		String userDesc = StringHelper.getLength(desc) >= 20 ? desc : null;

		String userEmail = getPara("userEmail");
		String email = userEmail.matches(emailRegEx) ? userEmail : null;

		String userGender = getPara("userGender");
		String gender =
				userGender.length() == 1 && userGender.matches(letterRegEx) ? userGender : null;

		String userQQ = getPara("userQQ");
		Long qq = userQQ.matches(numRegEx) ? Long.valueOf(userQQ) : null;

		String telephone = getPara("userTel");
		Long tel = telephone.length() == 11 && telephone.matches(phoneRegEx) ?
				Long.valueOf(telephone) :
				null;

		String userName = getPara("userName");
		String name =
				StringHelper.getLength(userName) >= 2 && StringHelper.getLength(userName) <= 6 ?
						userName :
						null;

		user.setStudentId(stuId);
		user.setUserDesc(userDesc);
		user.setUserEmail(email);
		user.setUserGender(gender);
		user.setUserQq(qq);
		user.setUserTel(tel);
		user.setUserName(name);
		user.setApplyTime(DateHelper.getDateTime());

		String emptyField = ReflectUtil.findEmptyField(user);
		if(null == emptyField || "".equals(emptyField)) {
			boolean saveSuccess = user.save();
			setAttr("status", saveSuccess);
		} else {
			setAttr("status", false);
			setAttr("errorData",emptyField);
		}

		renderJson();
	}

}
