package hacs;

import java.util.ArrayList;
import java.io.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 */

public class ClassCourseList extends ArrayList<Course> {

	private static final long serialVersionUID = 1L;

	public ClassCourseList() {
	}

	//// initialize the list by reading from the file.
	void initializeFromFile(String theFileName) {

		BufferedReader bufferedReeader;
		try {

			String strCourseName = null;
			bufferedReeader = new BufferedReader(new FileReader("CourseInfo.txt"));
			while ((strCourseName = bufferedReeader.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				// theCourse.CourseName= strCourseName;
				add(theCourse);
			}
		} catch (Exception ee) {
			
		}
	}

	Course findCourseByCourseName(String courseName) {
		int nCourseCount = size();
		for (int i = 0; i < nCourseCount; i++) {
			Course theCourse;
			theCourse = (Course) get(i);
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}

}