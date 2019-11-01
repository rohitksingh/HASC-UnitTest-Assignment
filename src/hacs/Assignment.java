package hacs;

/**
 * Title:        HACS
 * Description:  CSE870 Homework 3:  Implementing Design Patterns
 * Copyright:    Copyright (c) 2002
 * Company:      Department of Computer Science and Engineering, Michigan State University
 * @author Ji Zhang, Wei Zhu
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

import java.util.*;

import java.text.DateFormat;

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
public class Assignment {

	protected String assignmentName;
	protected String strAssignmentFilename;
	protected Date dueDate = new Date();
	protected String assignmentSpec;
	protected SolutionList theSolutionList = new SolutionList();
	protected Solution suggestSolution = new Solution();

	/**
	 * Assignment constructor
	 */
	public Assignment() {
	}

	/**
	 * Sets the due date
	 * 
	 * @param theDueDate
	 */
	public void setDueDate(Date theDueDate) {
		this.dueDate = theDueDate;
	}

	/**
	 * Sets assignment specification
	 * 
	 * @param theSpec
	 */
	public void setAssSpec(String theSpec) {
		this.assignmentSpec = theSpec;
	}

	/**
	 * Checks if the assignment is overdue
	 * 
	 * @return boolean
	 */
	public boolean isOverDue() {
		Date today;
		today = new Date();
		if (today.after(this.dueDate)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Create a solution
	 * 
	 * @return Solution
	 */
	public Solution addSolution() {
		Solution mySolution = new Solution();
		return mySolution;
	}
	
	/**
	 * Adds the theSolution to the Solutionlist
	 * 
	 * @param theSolution
	 */
	public void addSolution(Solution theSolution) {
		theSolutionList.add(theSolution);
	}

	/**
	 *  Submits the solution
	 * 
	 */
	public void submitSolution(Solution solution) {
		System.out.println("Solution is submitted");
	}

	/**
	 * Gets the solution list for the assignment
	 * 
	 */
	public SolutionList getSolutionList() {
		return theSolutionList;
	}

	
	/**
	 * Returns the solution of the given name
	 * 
	 * @param studentname
	 * @return Solution
	 */
	public Solution getSolution(String studentname) {
		Iterator<Solution> Iterator =  theSolutionList.iterator();
		return (Solution) Iterator.next();
	}

	/*
	 * Returns the suggested solution
	 * 
	 */
	public Solution getSugSolution() {
		return suggestSolution;
	}

	/**
	 * Returns SolutionIteartor
	 * 
	 * @return SolutionIterator
	 */
	public SolutionIterator getSolutionIterator() {
		SolutionIterator theSolutionIterator = new SolutionIterator(theSolutionList);
		return theSolutionIterator;
	}

	/**
	 * Overrides toString function to represent the object
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return assignmentName;
	}

	/**
	 * Returns due date in a String format
	 * 
	 * @return String
	 */
	public String getDueDateString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		return dateFormat.format(dueDate);
	}

	/**
	 * Allows a visitor to visit the course
	 * 
	 * @param visitor
	 */
	public void accept(NodeVisitor visitor) {
		visitor.visitAssignment(this);
	}
	
}