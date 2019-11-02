package hacs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

public class ClassCourseList extends ArrayList<Course> {

	private static final long serialVersionUID = 1L;

	/**
	 * ClassCourseList constructor
	 */
	public ClassCourseList() {
	}

	/**
	 * Reads all courses from file
	 * 
	 * @param theFileName
	 */

	public void initializeFromFile(String theFileName) {

		BufferedReader bufferedReeader;
		try {

			
			String strCourseName = null;
			bufferedReeader = new BufferedReader(new FileReader(theFileName));
			while ((strCourseName = bufferedReeader.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				theCourse.assignmentList = (ArrayList<Assignment>) getList();
				add(theCourse);
			}
		} catch (Exception ee) {

		}
	}

	/**
	 * Finds course by name
	 * 
	 * @param courseName
	 * @return Course
	 */
	public Course findCourseByCourseName(String courseName) {
		int nCourseCount = size();
		for (int i = 0; i < nCourseCount; i++) {
			Course theCourse;
			theCourse = (Course) get(i);
			if (theCourse.courseName.compareTo(courseName) == 0)
				return theCourse;
		}
		return null;
	}
	
	private List<Assignment> getList(){
		
		
		Solution solution = new Solution();
		solution.theAuthor = "rsingh91";
		solution.SolutionFileName="Solution1";
	
		
		Solution solution1 = new Solution();
		solution1.theAuthor = "rsingh92";
		solution1.SolutionFileName="Solution2";
		
		SolutionList solutionList = new SolutionList();
		solutionList.add(solution1);
		solutionList.add(solution);
		
		
		Date currentDate = new Date();
		Assignment ass1 = new Assignment();
		ass1.assignmentName = "Junit";
		ass1.theSolutionList  = solutionList;
		ass1.suggestSolution = solution;
		Date tenDaysAfter = new Date(currentDate.getTime() + (10 * 24 * 60 * 60 * 1000));
		ass1.setDueDate(tenDaysAfter);
		
		Assignment ass2 = new Assignment();
		ass2.assignmentName = "Design Pattern";
		ass2.theSolutionList  = solutionList;
		ass2.suggestSolution = solution1;
		Date seven = new Date(currentDate.getTime() - (7 * 24 * 60 * 60 * 1000));
		ass2.setDueDate(seven);

		List<Assignment> list = new ArrayList<Assignment>();
		list.add(ass1);
		list.add(ass2);
		
		return list;
		
	}
	
	
	

}