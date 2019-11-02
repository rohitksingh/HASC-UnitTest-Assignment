package hacs;

import java.util.Iterator;
import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 update to Java 8
 * @author rsingh92
 * @version 3.0 refactoring
 */
public class ReminderVisitor extends NodeVisitor {

	Reminder m_Reminder;

	/**
	 * Constructor Remindervisitor
	 */
	public ReminderVisitor() {
	}

	/**
	 * Constructor Remindervisitor
	 * 
	 * @param reminder
	 */
	public ReminderVisitor(Reminder reminder) {
		m_Reminder = reminder;
	}

	/**
	 * Visits Facade
	 * 
	 * @param facade
	 */
	@Override
	public void visitFacade(Facade facade) {
		CourseIterator courseList = new CourseIterator(facade.theCourseList);
		while (courseList.hasNext()) {
			Course course = (Course) courseList.next();
			course.accept(this);
		}
	}

	/**
	 * Visits Course
	 * 
	 * @param course
	 */
	@Override
	public void visitCourse(Course course) {
		Iterator<Assignment> assignmentList = course.assignmentList.listIterator();
		while (assignmentList.hasNext()) {
			Assignment assignment = (Assignment) assignmentList.next();
			assignment.accept(this);
		}
	}

	/**
	 * Visits assignment
	 * 
	 * @param assignment
	 */
	@Override
	public void visitAssignment(Assignment assignment) {
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		int ntoday = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(assignment.dueDate);
		int nDueDate = calendar.get(Calendar.DAY_OF_YEAR);
		if (nDueDate <= (ntoday + 1) && nDueDate >= ntoday) /// upcoming
		{
			m_Reminder = new Reminder();
			m_Reminder.listUpcoming.add("today is " + today.toString() + " " + assignment.assignmentName
					+ " Due Date is " + assignment.getDueDateString());
		}
		if (nDueDate < ntoday) {
			// put to the
			m_Reminder.listOverdue.add(assignment.assignmentName + " Due Date is " + assignment.getDueDateString());
		}
	}

	public static void main(String[] args) {
		ReminderVisitor reminderVisitor = new ReminderVisitor();
		Assignment assignment = new Assignment();
		assignment.setDueDate(new Date());
		reminderVisitor.visitAssignment(assignment);

	}

}