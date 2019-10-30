package hacs.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;
import hacs.Person;
import hacs.Student;

@DisplayName("When running person")
class TestPerson {

	Person person;
	Course course;
	
	@BeforeEach
	void init() {
		person = new Student();
		course = new Course("Junit", 0);
	}
	
	@Test
	@DisplayName("test add course")
	void testAddCourse() {
		
		int prevSize = person.getCourseList().size();
		person.addCourse(course);
		int newSize = person.getCourseList().size();
		assertTrue(prevSize==newSize-1);
	}
	
	@Test
	@DisplayName("test getCourseList")
	void testGetCourseList() {
		
		ClassCourseList courseList = new ClassCourseList();
		courseList.add(new Course("SER515",2));
		courseList.add(new Course("SER516",2));
		courseList.add(new Course("SER517",2));
		
		for(Course course: courseList) {
			person.addCourse(course);
		}
		ClassCourseList personCourseList = person.getCourseList();
		assertEquals(courseList, personCourseList);
	}
	

}
