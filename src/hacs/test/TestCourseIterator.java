package hacs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.CourseIterator;

@DisplayName("Test Course Iterator")
class TestCourseIterator {

	CourseIterator courseIterator;
	ClassCourseList courseList;
	Course course;
	
	@BeforeEach
	public void init() {
		
		courseList = new ClassCourseList();
		course = new Course("ser531",9);
		courseList.add(course);
		courseIterator = new CourseIterator(courseList);
		
	}
	
	@Test
	@DisplayName("test has next")
	void testHasNext() {
		assertTrue(courseIterator.hasNext());
	}
	
	@Test
	@DisplayName("test next")
	void testNext() {
		Course actual = (Course)courseIterator.next();
		assertEquals(course, actual);
	}
	
	@Test
	@DisplayName("test next when iterator is empty")
	void testNextWhenNull() {
		Course actual = (Course)new CourseIterator(new ClassCourseList()).next();
		assertEquals(null, actual);
	}
	
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
	
	@Test
	@DisplayName("test next suitable course when it exists")
	void testGetNextSuiatble(){
		Course actual = (Course)courseIterator.next("ser531");
		assertEquals(course, actual);
			
	}
	
	@Test
	@DisplayName("test next suitable course when it does not exists")
	void testGetNextSuiatbleNotFound(){
		Course actual = (Course)courseIterator.next("lsaklkas");
		assertNull(actual);
			
	}
	
}
