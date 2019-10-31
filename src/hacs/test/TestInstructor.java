package hacs.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.hamcrest.core.IsInstanceOf;
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
	
		 CourseMenu o = new Instructor().createCourseMenu(null, 0);
		 boolean result = o instanceof LowLevelCourseMenu; 
		 assertTrue(result);
		
	}
	
	@Test
	@DisplayName("test create low level course menu")
	void testCreateHighLevelCourseMenu() {
		CourseMenu o = new Instructor().createCourseMenu(null, 1);
		 boolean result = o instanceof HighLevelCourseMenu; 
		 assertTrue(result);
	}
	
	@Test
	@DisplayName("test create high level course menu wrongly")
	void testCreateHighLevelCourseMenuWrong() {
	
		 CourseMenu o = new Instructor().createCourseMenu(null, 1);
		 boolean result = o instanceof LowLevelCourseMenu; 
		 assertFalse(result);
		
	}
	
	@Test
	@DisplayName("test create low level course menu wrongly")
	void testCreateLowLevelCourseMenuWrong() {
		CourseMenu o = new Instructor().createCourseMenu(null, 0);
		 boolean result = o instanceof HighLevelCourseMenu; 
		 assertFalse(result);
	}

}
