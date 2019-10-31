package hacs.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.Assignment;
import hacs.Course;
import hacs.ReminderVisitor;

@DisplayName("When running reminder visitor")
public class TestReminderVisitor {

	ReminderVisitor reminderVisitor;
	
	@BeforeEach
	void init() {
		reminderVisitor = new ReminderVisitor();
	}
	
	
	@Test
	@Disabled
	@DisplayName("test visit facade")
	void testVisitCourse() {
	    
		Course course = new Course("SER515", 1);
		course.addAssignment(new Assignment());
		course.addAssignment(new Assignment());
		course.addAssignment(new Assignment());
		reminderVisitor.visitCourse(course);
		
		
	}
	
	
	
}
