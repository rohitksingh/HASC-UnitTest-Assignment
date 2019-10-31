package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

public class Instructor extends Person {
	public Instructor() {
		type = 1;// type=1 :instructor
	}

	/**
	 * Returns course menu based on the courselevel
	 * 
	 * @return CourseMenu 
	 */
	@Override
	public CourseMenu createCourseMenu(Course theCourse, int theLevel) {
		if (theLevel == 0)/// 0: Highlevel defined in CourseSeletDlg.
		{
			theCourseMenu = new LowLevelCourseMenu();
		} else/// 1: LowLevel
		{
			theCourseMenu = new HighLevelCourseMenu();
		}
		return theCourseMenu;
	}

	/**
	 * Shows menu
	 */
	public boolean showMenu() {
		super.showMenu();
		showAddButton();
		showViewButtons();
		showComboxes();
		showRadios();
		show();
		return ifLogout();
	}
}