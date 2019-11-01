package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ClassCourseList;
import hacs.Course;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */

@DisplayName("When running Class course list")
class TestClassCourseList {

	/*
	 * Tests if course exist with a given name
	 */
	@Test
	@DisplayName("test find course name")
	void testFindCourseByCourseName() {
		
		ClassCourseList classCourseList = new ClassCourseList();
		classCourseList.initializeFromFile("src/CourseInfo.txt");
		String expected = "CSE870";
		Course c = classCourseList.findCourseByCourseName(expected);
		String actual = c.toString();
		assertEquals(expected, actual);
	
	}
	
	/*
	 * Tests if course exist with a given name when wrong file is chosen
	 */
	@Test
	@DisplayName("test find course name when uri is wrong")
	void testFindCourseByCourseNameWrongPath() {
		
		ClassCourseList classCourseList = new ClassCourseList();
		classCourseList.initializeFromFile("src/kjkasjkaj.txt");
		String expected = "CSE870";
		Course c = classCourseList.findCourseByCourseName(expected);
		assertThrows(NullPointerException.class, () -> {
		    c.toString();
		  }, "should throw a Null Pointer exception");
	}
	
	/*
	 * Tests if course exist with a given name when wrong file is chosen
	 */
	@Test
	@DisplayName("test find course name when course does not exists")
	void testFindCourseByCourseNameNotFound() {
		
		ClassCourseList classCourseList = new ClassCourseList();
		classCourseList.initializeFromFile("src/kjkasjkaj.txt");
		String expected = "SER531";
		Course c = classCourseList.findCourseByCourseName(expected);
		assertThrows(NullPointerException.class, () -> {
		    c.toString();
		  }, "should throw a Null Pointer exception");
	}
	
	@Test
	@DisplayName("test initialze from file")
	void testinitializeFromFile() {
		ClassCourseList classCourseList = new ClassCourseList();
		classCourseList.initializeFromFile("src/CourseInfo.txt");
		assertEquals(3, classCourseList.size());
		assertEquals("CSE870", classCourseList.get(0).toString());
		assertEquals("CSE880", classCourseList.get(1).toString());
		assertEquals("CSE890", classCourseList.get(2).toString());
	}
	
	@Test
	@DisplayName("test initialze from file")
	void testinitializeFileFromWhenWrongPath() {
		ClassCourseList classCourseList = new ClassCourseList();
		classCourseList.initializeFromFile("src/CourseInfoasa.txt");
		assertEquals(0, classCourseList.size());
		
	}
	

}
