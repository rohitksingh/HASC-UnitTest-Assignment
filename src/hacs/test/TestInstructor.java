package hacs.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.CourseMenu;
import hacs.HighLevelCourseMenu;
import hacs.Instructor;
import hacs.LowLevelCourseMenu;

@DisplayName("When running test instructor")
class TestInstructor {

	@Test
	@DisplayName("test create high level course menu")
	void testCreateLowLevelCourseMenu() {
	
		 CourseMenu coursemenu = new Instructor().createCourseMenu(null, 0);
		 boolean result = coursemenu instanceof LowLevelCourseMenu; 
		 assertTrue(result);
		
	}
	
	@Test
	@DisplayName("test create low level course menu")
	void testCreateHighLevelCourseMenu() {
		CourseMenu coursemenu = new Instructor().createCourseMenu(null, 1);
		 boolean result = coursemenu instanceof HighLevelCourseMenu; 
		 assertTrue(result);
	}
	
	@Test
	@DisplayName("test create high level course menu wrongly")
	void testCreateHighLevelCourseMenuWrong() {
	
		 CourseMenu coursemenu = new Instructor().createCourseMenu(null, 1);
		 boolean result = coursemenu instanceof LowLevelCourseMenu; 
		 assertFalse(result);
		
	}
	
	@Test
	@DisplayName("test create low level course menu wrongly")
	void testCreateLowLevelCourseMenuWrong() {
		CourseMenu coursemenu = new Instructor().createCourseMenu(null, 0);
		 boolean result = coursemenu instanceof HighLevelCourseMenu; 
		 assertFalse(result);
	}

}
