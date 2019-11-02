package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.Solution;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */

@DisplayName("When running solution")
public class TestSolution {

	Solution solution;

	/**
	 * Initiates Solution before each test method
	 */
	@BeforeEach
	void init() {
		solution = new Solution();
	}

	/**
	 * Tests solution string representation when solution is graded
	 */
	@Test
	@DisplayName("test toString when solution is graded")
	void testToStringWhenGraded() {

		solution.setReported(true);
		String actual = solution.toString();
		String expected = "" + "  " + "" + " Grade=" + solution.getGradeInt() + "  " + "reported";
		assertEquals(expected, actual);

	}

	/**
	 * Tests solution string representation when solution is not graded
	 */
	@Test
	@DisplayName("test toString when solution is not graded")
	void testToStringWhenNotGraded() {

		solution.setReported(false);
		String actual = solution.toString();
		String expected = "" + "  " + "" + " Grade=" + solution.getGradeInt() + "  " + "not reported";
		assertEquals(expected, actual);
	}

	/**
	 * Tests get grade when solution is graded
	 */
	@Test
	@DisplayName("test get grade when graded")
	void testGetGrade() {
		solution.setGrade(10);
		int actual = solution.getGradeInt();
		int expected = 10;
		assertEquals(expected, actual);
	}

	/**
	 * Tests get grade when solution is not graded
	 */
	@Test
	@DisplayName("test get gradeString when not graded")
	void testGetGradeStringWhenNotGraded() {
		solution.setReported(false);
		solution.setGrade(10);
		String actual = solution.getGradeString();
		String expected = "-1";
		assertEquals(expected, actual);
	}

	/**
	 * tests gradeString representation when solution is graded
	 */
	@Test
	@DisplayName("test get gradeString when graded")
	void testGetGradeStringWhenGraded() {
		solution.setReported(true);
		solution.setGrade(10);
		String actual = solution.getGradeString();
		String expected = "10";
		assertEquals(expected, actual);
	}

	/**
	 * Tests gradeString representation when solution is not graded
	 */
	@Test
	@DisplayName("test get gradeString when not graded but grade point is given by mistake")
	void testGetGradeStringWhenNotGradedButSetGrade() {
		solution.setReported(false);
		solution.setGrade(10);
		String actual = solution.getGradeString();
		String expected = "-1";
		assertEquals(expected, actual);
	}

	/**
	 * Tests if a solution is reported
	 */
	@Test
	@DisplayName("test isReported")
	void testIsReported() {
		solution.setReported(true);
		boolean actual = solution.isReported();
		boolean expected = true;
		assertEquals(expected, actual);
	}

}
