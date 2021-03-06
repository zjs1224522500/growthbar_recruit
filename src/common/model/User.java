package common.model;

import common.model.base.BaseUser;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class User extends BaseUser<User> {
	public static final User dao = new User().dao();

	private Long studentId;

	private String userName;

	private String userGender;

	private String userEmail;

	private Long userQq;

	private Long userTel;

	private String userDesc;

	private String applyTime;
}
