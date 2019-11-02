package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 Update to Java 8
 * @author rsingh92
 * @version 3.0 refactoring
 */

public class Hacs {

	static Facade theFacade = new Facade();

	/**
	 * Hasc constructor
	 */
	public Hacs() {
	}

	/**
	 * Main function for the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		UserInfoItem userinfoitem = new UserInfoItem();
		theFacade.createCourseList();
		while (true) {
			System.out.println("1");
			boolean bExit = false;
			bExit = Facade.login(userinfoitem);
			if (bExit)
				break;

			System.out.println("2");
			theFacade.createUser(userinfoitem);
			System.out.println("3");
			theFacade.attachCourseToUser();
			System.out.println("4");
			if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student)// if is a student remind him of the due date
				{theFacade.remind();
				  System.out.println("Student");
				}
			
		
			boolean bLogout = false;
			System.out.println("5");
			while (!bLogout) {
				System.out.println("6");
				bLogout = theFacade.selectCourse();
				if (bLogout)
					break;
				System.out.println("7");
				bLogout = theFacade.courseOperation();
			}
		}

	}
}