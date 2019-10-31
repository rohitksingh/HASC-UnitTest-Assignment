package hacs;

import java.util.*;

/**
 * Title: HACS Description: CSE870 Homework 3: Implementing Design Patterns
 * Copyright: Copyright (c) 2002 Company: Department of Computer Science and
 * Engineering, Michigan State University
 * 
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author mjfindler
 * @version 2.0 Update to Java 8
 * @author rsingh92
 * @version 3.0 refactoring
 */

public class Course {
	String courseName;
	public ArrayList<Assignment> assignmentList = new ArrayList<Assignment>();
	int numOfAssignment;
	int courseLevel;

	/**
	 * Course constructor
	 * 
	 * @param strCourse
	 * @param theLevel
	 */
	public Course(String strCourse, int theLevel) {
		this.courseName = strCourse;
		// 0 HighLeve presentation 1 LowLevel Experiment
		this.courseLevel = theLevel;
		// this.AssList = NULL;
		this.numOfAssignment = 0;
	}

	/**
	 * Adds an assignment to assinment list
	 * 
	 * @param newAssignment
	 */
	public void addAssignment(Assignment newAssignment) {
		assignmentList.add(newAssignment);
	}

	/**
	 * Overrides toString function
	 * 
	 * @return String 
	 */
	@Override
	public String toString() {
		return courseName;
	}

	/**
	 * Allows a nodevisitor to visit Course
	 * 
	 * @param visitor
	 */
	void accept(NodeVisitor visitor) {
		visitor.visitCourse(this);
	}

}