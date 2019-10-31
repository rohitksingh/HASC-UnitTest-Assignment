package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

@SuppressWarnings("rawtypes")
public class CourseIterator implements Iterator {

	ClassCourseList theCourseList;
	int currentCourseNumber = -1;

	/**
	 * CourseIterator constructor
	 */
	public CourseIterator() {
	}

	/**
	 * CourseIterator constructor
	 * 
	 * @param courseList
	 */
	public CourseIterator(ClassCourseList courseList) {
		theCourseList = courseList;
	}

	/**
	 * Returns if more Courses are available in courselist
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasNext() {
		if (currentCourseNumber >= theCourseList.size() - 1)
			return false;
		else
			return true;
	}

	/**
	 * Returns the next Course in Course
	 * 
	 * @return Object
	 */
	@Override
	public Object next() {
		if (hasNext() == true) {
			currentCourseNumber++;
			return theCourseList.get(currentCourseNumber);
		} else {
			return null;
		}
	}

	/**
	 * Removes current course from list
	 * 
	 */
	@Override
	public void remove() {
		theCourseList.remove(currentCourseNumber);
	}

	/**
	 * Returns the next Course that fits the given CourseName
	 * 
	 * @param courseName
	 * @return
	 */
	public Object next(String courseName) {
		Course theCourse;
		theCourse = (Course) next();
		while (theCourse != null) {
			if (courseName.compareTo(theCourse.toString()) == 0) {
				return theCourse;
			}
			theCourse = (Course) next();
		}
		return null;
	}

}