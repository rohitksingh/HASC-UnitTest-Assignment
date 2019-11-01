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
		
	@Nested
	@DisplayName("test set due-date")
	class SetDueDate{
		
		Assignment assignment;
		
		@BeforeEach
		public void init() {
			assignment = new Assignment();
		}
		
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
		
		@Test
		@DisplayName("when setting a null value")
		public void testSetDueDateNull() {
			assignment.setDueDate(null);
			assertThrows(NullPointerException.class, () -> {
			    assignment.getDueDateString();
			  }, "should throw a Null Pointer exception");
		}
		
	}
	
	@Nested
	@DisplayName("test is assignment overdue")
	class SetOverdue{
		
		Assignment assignment;
		Date currentDate = new Date();
		
		@BeforeEach
		void init() {
		    assignment = new Assignment();
		    currentDate = new Date();
		}
		
		@Test
		@DisplayName("when current date is before duedate")
		public void testIsOverDuePastDate(){
		    
			Date tenDaysBefore = new Date(currentDate.getTime() - (10 * 24 * 60 * 60 * 1000)); 
			assignment.setDueDate(tenDaysBefore);
			assertEquals(true, assignment.isOverDue());
			
	    }
		
		@Test
		@DisplayName("when current date is after duedate")
		public void testIsOverDuePastFuture(){
		    
			Date tenDaysAfter = new Date(currentDate.getTime() + (10 * 24 * 60 * 60 * 1000)); 
			assignment.setDueDate(tenDaysAfter);
			assertEquals(false, assignment.isOverDue());	
	    }
		
	}
	
	@Test
    void testAddSolution(){
		Solution mysolution = new Solution();
		assertTrue(mysolution instanceof Solution);
	}
	
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
	
	@Test
	void testSubmitSolution(){
		
	}

	@Test
	void testGetSolutionList(){
		
	}
	
	
	@Test
	@DisplayName("test get solution")
	void testGetSolution(){
	    
		Solution mysolution = new Solution();
        Assignment assignment = new Assignment();
        assignment.addSolution(mysolution);
        assertEquals(mysolution, assignment.getSolution(""));
		
	}
	
	@Test
	@DisplayName("test toString")
	void testToString(){
		Assignment assignment = new Assignment();
		assertEquals(null, assignment.toString());	
	}

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
