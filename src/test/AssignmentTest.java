package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Solution;
import hacs.SolutionList;

class AssignmentTest {
 	
	@Test
	public void testSetSetDueDate() {
		Date date1 = new Date();
		Assignment assignment = new Assignment();
		assignment.SetDueDate(date1);
		DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.SHORT);
	    String out1 =  dateFormat.format(date1);
	    String out2 =  assignment.getDueDateString();
	    assertTrue(out1.equals(out2));
	}
	
	@Test
	public void testSetDueDateNull() {
		Assignment assignment = new Assignment();
		assignment.SetDueDate(null);
		assertThrows(NullPointerException.class, () -> {
		    assignment.getDueDateString();
		  });
	}
	
	@Test
	public void testIsOverDuePastDate(){
	    
		Assignment assignment = new Assignment();
		Date currentDate = new Date();
		Date tenDaysBefore = new Date(currentDate.getTime() - (10 * 24 * 60 * 60 * 1000)); 
        System.out.println(tenDaysBefore.toString());
		assignment.SetDueDate(tenDaysBefore);
		
		assertEquals(true, assignment.IsOverDue());
		
    }
	
	@Test
	public void testIsOverDuePastFuture(){
	    
		Assignment assignment = new Assignment();
		Date currentDate = new Date();
		Date tenDaysBefore = new Date(currentDate.getTime() + (10 * 24 * 60 * 60 * 1000)); 
        System.out.println(tenDaysBefore.toString());
		assignment.SetDueDate(tenDaysBefore);
		assertEquals(false, assignment.IsOverDue());	
    }
	
	
	@Test
	public void testAddSolution(){
	    
		Solution mysolution = new Solution();
		assertTrue(mysolution instanceof Solution);
		
	}
	
	@Test
	public void testAddSolutionToList(){
		
	}
	
}
