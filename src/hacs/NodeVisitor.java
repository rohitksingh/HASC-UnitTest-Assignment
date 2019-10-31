package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract public class NodeVisitor {

	public NodeVisitor() {
	}

	public NodeVisitor(Object visitee) {
	}

	/**
	 * Visits Facade class
	 * 
	 * @param facade
	 */
	abstract public void visitFacade(Facade facade);

	/**
	 * Visits Course class
	 * 
	 * @param course
	 */
	abstract public void visitCourse(Course course);

	/**
	 * Visits assignment class
	 * 
	 * @param assignment
	 */
	abstract public void visitAssignment(Assignment assignment);

}