package hacs;

import java.util.*;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author mjfindler
 * @version 2.0 use <e> notation
 * @author rsingh92
 * @version 3.0 refactoring

 */

public class ListIterator implements Iterator<Object> {
	public ArrayList<Object> theList;
	int currentNumber = -1;

	public ListIterator() {
	}

	
	public ListIterator(ArrayList<Object> list) {
		theList = list;
	}

	/**
	 * Returns if more Object are available in arraylist
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasNext() {
		if (currentNumber >= theList.size() - 1)
			return false;
		else
			return true;
	}

	/**
	 * Returns the next object in the arraylist
	 * 
	 * @return Object
	 */
	@Override
	public Object next() {
		if (hasNext() == true) {
			currentNumber++;
			return theList.get(currentNumber);
		} else {
			return null;
		}
	}

	/**
	 * Removes the current object from arraylist
	 * 
	 */
	@Override
	public void remove() {
		theList.remove(currentNumber);
	}
}