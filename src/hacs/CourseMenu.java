package hacs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

abstract public class CourseMenu extends JDialog {

	private static final long serialVersionUID = 1L;
	Course theCourse;
	boolean bLogout = true;

	JRadioButton assignmentRadiao = new JRadioButton();
	JComboBox<Assignment> assignmentCombox = new JComboBox<Assignment>();
	JButton assignmentViewButton = new JButton();
	JButton assignmentAddButton = new JButton();
	JRadioButton optionRadio = new JRadioButton();
	JLabel assignmentContentLable = new JLabel();
	JComboBox<Assignment> optionCombo = new JComboBox<Assignment>();
	JButton optionViewButton = new JButton();
	JButton optionAddButton = new JButton();
	JButton buttonChangeCourse = new JButton();
	JButton buttonLogout = new JButton();

	/**
	 * CourseMenu constructor
	 */
	public CourseMenu() {

		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		setModal(true);
		setSize(503, 294);
	}

	/**
	 * Init function
	 * 
	 * @throws Exception
	 */
	private void jbInit() throws Exception {
		buttonChangeCourse.setText("ChangeCourse");
		buttonChangeCourse.setBounds(new Rectangle(101, 211, 73, 37));
		buttonChangeCourse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonChangeCourse_actionPerformed(e);
			}
		});
		this.getContentPane().setLayout(null);
		this.setTitle("");
		buttonLogout.setText("Logout");
		buttonLogout.setBounds(new Rectangle(267, 215, 73, 37));
		buttonLogout.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonLogout_actionPerformed(e);
			}
		});
		this.getContentPane().add(buttonChangeCourse, null);
		this.getContentPane().add(buttonLogout, null);
	}

	/**
	 * Shows menu
	 * 
	 * @param theCourse
	 */
	abstract void showMenu(Course theCourse);

	/**
	 * shows add button
	 */
	abstract void showAddButtons();

	/**
	 * shows view button
	 */
	abstract void showViewButtons();

	/**
	 * shows radio buttons
	 */
	abstract void showRadios();

	/**
	 * shows commentbox
	 */
	abstract void showComboxes();

	/**
	 * shows label
	 */
	abstract void showLabel();

	/**
	 * Add button listener
	 * 
	 * @param e
	 */
	void assignmentAddButton_actionPerformed(ActionEvent e) {
		Hacs.theFacade.addAssignment(theCourse);
		refresh();
	}

	/**
	 * assignment add button action listener
	 * 
	 * @param e
	 */
	void assignmentViewButton_actionPerformed(ActionEvent e) {
		Assignment theAss = (Assignment) assignmentCombox.getSelectedItem();
		Hacs.theFacade.viewAssignment(theAss);
	}

	/**
	 * Refreshes items in comment box
	 */
	void refresh() {
		assignmentCombox.removeAllItems();
		Iterator<Assignment> iterator = theCourse.assignmentList.iterator();
		while (iterator.hasNext()) {
			assignmentCombox.addItem((Assignment) iterator.next());
		}
	}

	/**
	 * Performs change course action
	 * 
	 * @param e
	 */
	void buttonChangeCourse_actionPerformed(ActionEvent e) {
		bLogout = false;
		setVisible(false);
	}

	/**
	 * Performs logout
	 * 
	 * @param e
	 */
	void buttonLogout_actionPerformed(ActionEvent e) {
		bLogout = true;
		setVisible(false);
	}

	/**
	 * Returns if logout
	 * 
	 * @return boolean
	 */
	boolean ifLogout() {
		return bLogout;
	}
}