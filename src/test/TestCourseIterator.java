package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.CourseIterator;

@DisplayName("Test Course Iterator")
class TestCourseIterator {

	CourseIterator courseIterator;
	ClassCourseList courseList;
	
	@BeforeEach
	public void init() {
		
		courseIterator = new CourseIterator();
		courseList = new ClassCourseList();
		
		
	}
	
	@Test
	void test() {
		
	}

}
