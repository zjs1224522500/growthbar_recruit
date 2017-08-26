package type;

/**
 * Version:v1.0 (description:  )
 */
public enum PropertyInfo {

	USERNAME("userName", "姓名"), STUDENTID("studentId", "学号"), USERTELEPHONE("userTel",
			"电话"), USERQQ("userQq", "QQ"), USEREMAIL("userEmail", "邮箱"), USERGENDER("userGender",
			"性别"), USERDESC("userDesc", "个人简介");

	private String symbol;

	private String desc;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	PropertyInfo(String symbol, String desc) {
		this.symbol = symbol;
		this.desc = desc;
	}

	public static String getDesc(String symbol) {
		for(PropertyInfo propertyInfo:PropertyInfo.values()) {
			if(propertyInfo.getSymbol().equals(symbol)) {
				return propertyInfo.getDesc();
			}
		}
		return null;
	}
}
