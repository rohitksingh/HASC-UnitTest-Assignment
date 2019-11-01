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
 * @version 2.0 update to Java 8
 * @author rsingh92
 * @version 3.0 refactoring
 */

public class Solution {
	
	String theAuthor = "";
	String SolutionFileName = "";
	Date theSubmitData = new Date();
	int theGrade;
	boolean reported = false;

	/**
	 * Constructor solution
	 */
	public Solution() {
	}

	/**
	 * Overrides toString 
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		String string;
		string = theAuthor + "  " + SolutionFileName + " Grade=" + getGradeInt() + "  ";
		if (isReported())
			string += "reported";
		else
			string += "not reported";

		return (string);
	}

	/**
	 * Returns grade string 
	 * 
	 * @return String
	 */
	public String getGradeString() {
		if (isReported())
			return "" + theGrade;
		else
			return "-1";
	}

	/**
	 * Returns grade
	 * 
	 * @return int 
	 */
	public int getGradeInt() {
		return theGrade;
	}

	/**
	 * Sets if the solution is reported
	 * 
	 * @param reported
	 */
	public void setReported(boolean reported) {
		this.reported = reported;
	}

	/**
	 * Returns if the solution is reported
	 * 
	 * @return boolean
	 */
	public boolean isReported() {
		return reported;
	}
	
	/**
	 * Sets grade for the solution
	 * 
	 * @param theGrade
	 */
	public void setGrade(int theGrade) {
		this.theGrade = theGrade;
	}
}