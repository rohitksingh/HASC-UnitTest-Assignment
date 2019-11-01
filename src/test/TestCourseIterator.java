package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;


/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */

@DisplayName("Test Course Iterator")
class TestCourseIterator {

	CourseIterator courseIterator;
	ClassCourseList courseList;
	Course course;
	
	/**
	 * Initiates resources before each test-method run
	 */
	@BeforeEach
	public void init() {
		
		courseList = new ClassCourseList();
		course = new Course("ser531",9);
		courseList.add(course);
		courseIterator = new CourseIterator(courseList);
		
	}
	
	/**
	 * Tests if the iterator has more elements
	 */
	@Test
	@DisplayName("test has next")
	void testHasNext() {
		assertTrue(courseIterator.hasNext());
	}
	
	/**
	 * Tests if next element is retrieved from iterator
	 */
	@Test
	@DisplayName("test next")
	void testNext() {
		Course actual = (Course)courseIterator.next();
		assertEquals(course, actual);
	}
	
	/**
	 * Tests if null is returned when list is empty
	 */
	@Test
	@DisplayName("test next when iterator is empty")
	void testNextWhenNull() {
		Course actual = (Course)new CourseIterator(new ClassCourseList()).next();
		assertEquals(null, actual);
	}
	
	/**
	 * Tests if element is removed from iterator
	 */
	@Test
	@DisplayName("test remove")
	void testRemove() {
		int size = 0;
		while(courseIterator.hasNext())
		{
			size++;
			courseIterator.next();
		}
		courseIterator.remove();
		int newSize = 0;
		while(courseIterator.hasNext())
		{
			newSize++;
			courseIterator.next();
		}
		
		assertTrue(newSize == size-1);
	}
	
	/**
	 * Tests if next suitable course is retrieved from courseIterator using coursename
	 */
	@Test
	@DisplayName("test next suitable course when it exists")
	void testGetNextSuiatble(){
		Course actual = (Course)courseIterator.next("ser531");
		assertEquals(course, actual);
			
	}
	
	/**
	 * Tests if null is returned when no course is found from iterator
	 */
	@Test
	@DisplayName("test next suitable course when it does not exists")
	void testGetNextSuiatbleNotFound(){
		Course actual = (Course)courseIterator.next("lsaklkas");
		assertNull(actual);
			
	}
	
}
