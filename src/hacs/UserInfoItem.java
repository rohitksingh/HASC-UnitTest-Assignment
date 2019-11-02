package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 Update to Java 8
 * @author rsingh92
 * @version 3.0 refactoring
 */

public class UserInfoItem {

	public enum USER_TYPE {
		Student, Instructor
	}

	String strUserName;

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public USER_TYPE getUserType() {
		return userType;
	}

	public void setUserType(USER_TYPE userType) {
		this.userType = userType;
	}

	USER_TYPE userType; // 0 : Student, 1: Instructor
}