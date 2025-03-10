package hacs;

import javax.swing.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * 
 * @author mjfindler
 * @version 2.0 Update to Java 8  
 * @author rsingh92
 * @version 3.0 refactoring       
 */

public class SolutionMenu extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor SolutionMenu
	 */
	public SolutionMenu() {
	}

	/**
	 * Shows SolutionMenu to user
	 * 
	 * @param theSolution
	 */
	void ShowMenu(Solution theSolution) {
		setVisible(true);
	}

}
