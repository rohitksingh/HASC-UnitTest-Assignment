package hacs.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Course;

@DisplayName("When running Test course")
class TestCourse {
	
	Course course;
	
	@BeforeEach
	public void init() {
		course = new Course("SER515",1);
	}
	
	@Test
	@DisplayName("test add assignment")
	public void testAddAssignment() {
		
		Assignment assignment = new Assignment();	
		int prevSize = course.assignmentList.size();
		course.addAssignment(assignment);
		int newSize = course.assignmentList.size();
		assertTrue((newSize == prevSize+1));
		
	}
	
	@Test
	@DisplayName("test toString")
	void testToString(){
		assertEquals("SER515", course.toString());		
	}
	
}
