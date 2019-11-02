package hacs;

import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 * @author rsingh92
 * @version 3.0 refactoring
 */

public class Facade {

	public int userType;
	private Course theSelecteCourse = null;
	private int nCourseLevel = 0;
	public ClassCourseList theCourseList;
	Person thePerson;

	/**
	 * Constructor Facade
	 */
	public Facade() {
	}

	/**
	 * Performs login for User
	 * 
	 * @param userinfoItem
	 * @return
	 */
	static public boolean login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.getName();
		userinfoItem.userType = login.getUserType();
		return login.isExit();
	}

	/**
	 * Adds assignment to course
	 * 
	 * @param theCourse
	 */
	void addAssignment(Course theCourse) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}
		Assignment theAssignment = new Assignment();
		theAssignmentMenu.showMenu(theAssignment, thePerson);
		theCourse.addAssignment(theAssignment);
	}

	/**
	 * Shows assignment
	 * 
	 * @param theAssignment
	 */
	void viewAssignment(Assignment theAssignment) {
		AssignmentMenu theAssignmentMenu;
		if (thePerson.type == 0)/// student
		{
			theAssignmentMenu = new StudentAssignmentMenu();
		} else {
			theAssignmentMenu = new InstructorAssignmentMenu();
		}

		theAssignmentMenu.showMenu(theAssignment, thePerson);
	}

	/**
	 * Grades solution for a solution
	 * 
	 * @param theSolution
	 */
	void gradeSolution(Solution theSolution) {
		SolutionMenu solutionMenu = new SolutionMenu();
		solutionMenu.ShowMenu(theSolution);
	}

	/**
	 * Reports solution
	 * 
	 * @param theAssignment
	 */
	void reportSolutions(Assignment theAssignment) {
		Solution theSolution;
		SolutionIterator theSolutionIterator;
		theSolutionIterator = theAssignment.getSolutionIterator();
		theSolution = (Solution) theSolutionIterator.next();
		while (theSolution != null) {
			theSolution.setReported(true);
			theSolution = (Solution) theSolutionIterator.next();
		}
	}

	/**
	 * Submits solution
	 * 
	 * @param theAssignment
	 * @param theSolution
	 */
	void submitSolution(Assignment theAssignment, Solution theSolution) {
		theAssignment.addSolution(theSolution);
	}

	/**
	 * Reminder function
	 */
	void remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.getCourseList());
	}

	/**
	 * Creates user from UserInfo
	 * 
	 * @param userinfoitem
	 */
	public void createUser(UserInfoItem userinfoitem) {
		if (userinfoitem.userType == UserInfoItem.USER_TYPE.Student) /// student
		{
			thePerson = new Student();
		} else /// instructor
		{
			thePerson = new Instructor();
		}
		thePerson.userName = userinfoitem.strUserName;
	}

	/**
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	public void createCourseList() {
		theCourseList = new ClassCourseList();
		theCourseList.initializeFromFile("src/CourseInfo.txt");
	}

	/**
	 * Adds course to user's course list
	 */
	public void attachCourseToUser() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("src/UserCourse.txt"));
			String aline, strUserName, strCourseName;
			while ((aline = file.readLine()) != null) // not the EOF
			{
				strUserName = getUserName(aline);
				strCourseName = getCourseName(aline);
				if (strUserName.compareTo(thePerson.userName) == 0) /// the UserName mateches
				{
					theSelecteCourse = findCourseByCourseName(strCourseName);
					if (theSelecteCourse != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.addCourse(theSelecteCourse);
					}
				}
			}
		} catch (Exception ee) {

		}
	}

	/**
	 * Gets the user name from aline UserName:CourseName
	 * 
	 * @param aline
	 * @return String
	 */
	private String getUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/**
	 * Gets the CourseName from aline UserName:CourseName
	 * 
	 * @param aline
	 * @return String
	 */
	private String getCourseName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	/**
	 * Selects course
	 * 
	 * @return String
	 */
	public boolean selectCourse() {
		CourseSelectDialog theDlg = new CourseSelectDialog();
		theSelecteCourse = theDlg.showDialog(thePerson.courseList);
		thePerson.currentCourse = theSelecteCourse;
		nCourseLevel = theDlg.nCourseLevel;
		return theDlg.isLogout();
	}

	/**
	 * Performs course operation
	 * 
	 * @return boolean
	 */
	public boolean courseOperation() {
		thePerson.createCourseMenu(theSelecteCourse, nCourseLevel);
		return thePerson.showMenu();//// 0: logout 1 select an other course
	}

	/**
	 * Returns course from course list using coursename
	 * 
	 * @param courseName
	 * @return Course
	 */
	private Course findCourseByCourseName(String courseName) {
		CourseIterator Iterator = new CourseIterator(theCourseList);
		return (Course) Iterator.next(courseName);
	}

	public Person getPerson() {
		return thePerson;
	}

}