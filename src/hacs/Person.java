package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

abstract public class Person {
	
	int type = 0; // type=0 : student, type=1 instructor
	String userName;
	ClassCourseList courseList;
	CourseMenu theCourseMenu;
	Course currentCourse;
	Assignment currentAssignment;

	/**
	 * Person constructor
	 */
	public Person() {
		courseList = new ClassCourseList();
	}

	/**
	 * Creates a CourseMenu based on the course-level
	 * 
	 * @param theCourse
	 * @param theLevel
	 * @return CourseMenu
	 */
	abstract public CourseMenu createCourseMenu(Course theCourse, int theLevel);

	/**
	 * Shows add button
	 */
	public void showAddButton() {
		theCourseMenu.showAddButtons();
	}

	/**
	 * Shows view button
	 */
	public void showViewButtons() {
		theCourseMenu.showViewButtons();
	}

	/**
	 * Shows comment box
	 */
	public void showComboxes() {
		theCourseMenu.showComboxes();
	}

	/**
	 * Shows radio buttons
	 */
	public void showRadios() {
		theCourseMenu.showRadios();
	}

	/**
	 * Sets CourseMenu visible
	 */
	public void show() {
		theCourseMenu.setVisible(true);
	}

	/**
	 * Returns if user has logout
	 * 
	 * @return boolean
	 */
	public boolean ifLogout() {
		return theCourseMenu.ifLogout();
	}

	/**
	 * Shows the assignment list
	 * 
	 * @return boolean
	 */
	public boolean showMenu() {
		
		Iterator<Assignment> assignmentIterator = currentCourse.assignmentList.iterator();
		theCourseMenu.theCourse = currentCourse;
		Assignment theAssignment;
		while (assignmentIterator.hasNext()) {
			theAssignment = (Assignment) assignmentIterator.next();
			theCourseMenu.assignmentCombox.addItem(theAssignment);
		}
		return false;
	}

	/**
	 * Gets class course list
	 * 
	 * @return
	 */
	public ClassCourseList getCourseList() {
		return courseList;
	}

	/**
	 * Adds current course to courselist
	 * 
	 * @param theCourse
	 */
	public void addCourse(Course theCourse) {
		courseList.add(theCourse);
	}
}