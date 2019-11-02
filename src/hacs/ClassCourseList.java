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

			int count =0;
			String strCourseName = null;
			bufferedReeader = new BufferedReader(new FileReader(theFileName));
			while ((strCourseName = bufferedReeader.readLine()) != null) {
				Course theCourse;
				theCourse = new Course(strCourseName, 0);
				Assignment assignment = new Assignment();
				count++;
				theCourse.assignmentList = (ArrayList<Assignment>) getList();
				// theCourse.CourseName= strCourseName;
				System.out.println(theCourse);
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
		solution.theAuthor = "rsingh92";
		solution.SolutionFileName="Solution2";
		
		SolutionList solutionList = new SolutionList();
		solutionList.add(solution1);
		solutionList.add(solution);
		
		
		List<Assignment> list = new ArrayList<Assignment>();
		Assignment ass1 = new Assignment();
		ass1.assignmentName = "Junit";
		ass1.theSolutionList  = solutionList;
		ass1.suggestSolution = solution;
		ass1.setDueDate(new Date());
		list.add(ass1);
		Assignment ass2 = new Assignment();
		ass1.assignmentName = "Design Pattern";
		ass1.setDueDate(new Date());
		ass1.theSolutionList  = solutionList;
		ass1.suggestSolution = solution1;
		list.add(ass2);
		return list;
		
		
		
		
		
		
	}
	
	
	

}