package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Solution;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */
@DisplayName("When running AssignmentTest")
class TestAssignment {
	
	/**
	 * Nested class for testing Assignment set due-date
	 */
	@Nested
	@DisplayName("test set due-date")
	class SetDueDate{
		
		Assignment assignment;
		
		/**
		 * initiates resource to run before each test method
		 */
		@BeforeEach
		public void init() {
			assignment = new Assignment();
		}
		
		/**
		 * Test method for seeting up correct date format
		 */
		@Test
		@DisplayName("when setting a correct date")
		public void testSetSetDueDate() {
			Date date1 = new Date();
			assignment.setDueDate(date1);
			DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
		    String out1 =  dateFormat.format(date1);
		    String out2 =  assignment.getDueDateString();
		    assertTrue(out1.equals(out2));
		}
		
		/**
		 * Test for setting up null value as a due-date
		 */
		@Test
		@DisplayName("when setting a null value")
		public void testSetDueDateNull() {
			assignment.setDueDate(null);
			assertThrows(NullPointerException.class, () -> {
			    assignment.getDueDateString();
			  }, "should throw a Null Pointer exception");
		}
		
	}
	
	/**
	 * Nested class for testing if assignment is overdue
	 */
	@Nested
	@DisplayName("test is assignment overdue")
	class IsOverdue{
		
		Assignment assignment;
		Date currentDate = new Date();
		
		/**
		 * Initiates resource for each test method
		 */
		@BeforeEach
		void init() {
		    assignment = new Assignment();
		    currentDate = new Date();
		}
		
		/**
		 * Tests isoverdue when current date is before duedate
		 */
		@Test
		@DisplayName("when current date is before duedate")
		public void testIsOverDuePastDate(){
		    
			Date tenDaysBefore = new Date(currentDate.getTime() - (10 * 24 * 60 * 60 * 1000)); 
			assignment.setDueDate(tenDaysBefore);
			assertEquals(true, assignment.isOverDue());
			
	    }
		
		/**
		 * Tests isoverdue when current date is after duedate
		 */
		@Test
		@DisplayName("when current date is after duedate")
		public void testIsOverDuePastFuture(){
		    
			Date tenDaysAfter = new Date(currentDate.getTime() + (10 * 24 * 60 * 60 * 1000)); 
			assignment.setDueDate(tenDaysAfter);
			assertEquals(false, assignment.isOverDue());	
	    }
		
	}
	
	/**
	 * Tests add solution instance type
	 */
	@Test
    void testAddSolution(){
		Solution mysolution = new Solution();
		assertTrue(mysolution instanceof Solution);
	}
	
	/**
	 * Tests if current solution is added to solutionlist
	 */
	@Test
	@DisplayName("test add solution to list")
	void testAddSolutionToList(){
		
		Assignment assignment = new Assignment();
		Iterator<?> iterator = assignment.getSolutionIterator();
		int size=0;
		while(iterator.hasNext()) {
			iterator.next();
			size++;
		}
		
		assignment.addSolution(new Solution());
		Iterator<?> iterator1 = assignment.getSolutionIterator();
	
		int newSize=0;
		while(iterator1.hasNext()) {
			iterator1.next();
			newSize++;
		}
		
		assertTrue(newSize == size+1);
	}
	
	/**
	 * Tests if the solution is submitted
	 */
	@Test
	void testSubmitSolution(){
		
	}

	/**
	 * Tests if the solutionlist is retrieved
	 */
	@Test
	void testGetSolutionList(){
		
	}
	
	/**
	 * Tests getSolution
	 */
	@Test
	@DisplayName("test get solution")
	void testGetSolution(){
	    
		Solution mysolution = new Solution();
        Assignment assignment = new Assignment();
        assignment.addSolution(mysolution);
        assertEquals(mysolution, assignment.getSolution(""));
		
	}
	
	/**
	 * Tests the string representation of assignment object
	 */
	@Test
	@DisplayName("test toString")
	void testToString(){
		Assignment assignment = new Assignment();
		assertEquals(null, assignment.toString());	
	}

	/**
	 * Tests due-date string format representation
	 */
	@Test
	@DisplayName("test get duedate string")
    void getDueDateString(){
	    
		Date date = new Date();
	    DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
	    String expected = dateFormat.format(date);
	    Assignment assignment = new Assignment();
	    assignment.setDueDate(date);
	    String actual = assignment.getDueDateString();
	    assertEquals(expected, actual);
	}

}
