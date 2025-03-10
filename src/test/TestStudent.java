package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.CourseMenu;
import hacs.HighLevelCourseMenu;
import hacs.Instructor;
import hacs.LowLevelCourseMenu;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */

@DisplayName("While running student")
class TestStudent {

	/**
	 * Tests if a low-level-coursemenu is returned
	 */
	@Test
	@DisplayName("test create high level course menu")
	void testCreateLowLevelCourseMenu() {

		CourseMenu coursemenu = new Instructor().createCourseMenu(null, 0);
		boolean result = coursemenu instanceof LowLevelCourseMenu;
		assertTrue(result);

	}

	/**
	 * Tests if a high-level-coursemenu is returned
	 */
	@Test
	@DisplayName("test create low level course menu")
	void testCreateHighLevelCourseMenu() {
		CourseMenu coursemenu = new Instructor().createCourseMenu(null, 1);
		boolean result = coursemenu instanceof HighLevelCourseMenu;
		assertTrue(result);
	}

	/**
	 * Tests if a low-level-coursemenu is returned
	 */
	@Test
	@DisplayName("test create high level course menu wrongly")
	void testCreateHighLevelCourseMenuWrong() {

		CourseMenu coursemenu = new Instructor().createCourseMenu(null, 1);
		boolean result = coursemenu instanceof LowLevelCourseMenu;
		assertFalse(result);

	}

	/**
	 * Tests if a low-level-coursemenu is returned
	 */
	@Test
	@DisplayName("test create low level course menu wrongly")
	void testCreateLowLevelCourseMenuWrong() {
		CourseMenu coursemenu = new Instructor().createCourseMenu(null, 0);
		boolean result = coursemenu instanceof HighLevelCourseMenu;
		assertFalse(result);
	}

}
