package hacs;

import javax.swing.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

abstract public class AssignmentMenu extends JDialog {

	private static final long serialVersionUID = 1L;

	public AssignmentMenu() {
		setModal(true);
		setSize(575, 330);
	}
	
	/**
	 * Shows assignment menu
	 * 
	 * @param assignment
	 * @param person
	 */
	abstract void showMenu(Assignment assignment, Person person);

	/**
	 * AssignmentMenu Constructor 
	 */
	
}