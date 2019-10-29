package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Solution;
import hacs.SolutionList;

@DisplayName("When running AssignmentTest")
class AssignmentTest {
		
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
			assignment.SetDueDate(date1);
			DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
		    String out1 =  dateFormat.format(date1);
		    String out2 =  assignment.getDueDateString();
		    assertTrue(out1.equals(out2));
		}
		
		@Test
		@DisplayName("when setting a null value")
		public void testSetDueDateNull() {
			assignment.SetDueDate(null);
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
			assignment.SetDueDate(tenDaysBefore);
			assertEquals(true, assignment.IsOverDue());
			
	    }
		
		@Test
		@DisplayName("when current date is after duedate")
		public void testIsOverDuePastFuture(){
		    
			Date tenDaysAfter = new Date(currentDate.getTime() + (10 * 24 * 60 * 60 * 1000)); 
			assignment.SetDueDate(tenDaysAfter);
			assertEquals(false, assignment.IsOverDue());	
	    }
		
	}
	

	@Test
	public void testAddSolution(){
		Solution mysolution = new Solution();
		assertTrue(mysolution instanceof Solution);
	}
	
	@Test
	@Disabled
	public void testAddSolutionToList(){
		
	}
	
}
