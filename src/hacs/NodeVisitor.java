package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

abstract public class NodeVisitor {

	/**
	 * NodeVisitor constructor
	 */
	public NodeVisitor() {
	}

	/**
	 * NodeVisitor constructor
	 * 
	 * @param visitee
	 */
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