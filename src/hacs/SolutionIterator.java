package hacs;

import java.util.Iterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author Zhang ji Zhu Wei
 * @version 1.0
 * @author rsingh92
 * @version 2.0 refactoring
 */

@SuppressWarnings("rawtypes")
public class SolutionIterator implements Iterator {
	SolutionList solutionlist;

	int currentSolutionNumber = -1;

	/**
	 * Constructor SolutionIterator
	 */
	public SolutionIterator() {
	}

	/**
	 * Returns SolutionIterator
	 * 
	 * @param thesolutionlist
	 */
	public SolutionIterator(SolutionList thesolutionlist) {
		solutionlist = thesolutionlist;
		MoveToHead();
	}

	/**
	 * Moves CurrentSolutionNumber: point to the location before the first element
	 * 
	 */
	public void MoveToHead() {
		currentSolutionNumber = -1;
	}

	/**
	 * returns if more solution exists in solutionlist
	 * 
	 * @return boolean
	 */
	@Override
	public boolean hasNext() {
		if (currentSolutionNumber >= solutionlist.size() - 1)
			return false;
		else
			return true;
	}

	/**
	 * Returns next solution in the solutionlist
	 * 
	 * @return Object
	 */
	@Override
	public Object next() {
		/** @todo: Implement this java.util.Iterator method */
		if (hasNext() == true) {
			currentSolutionNumber++;
			return solutionlist.get(currentSolutionNumber);
		} else {
			return null;
		}
	}

	/**
	 * Gets the next Solution that fits the Username;
	 * 
	 * @param UserName
	 * @return Object
	 */
	public Object next(String UserName) {
		Solution theSolution;
		theSolution = (Solution) next();
		while (theSolution != null) {
			if (UserName.compareTo(theSolution.theAuthor) == 0) {
				return theSolution;
			}
			theSolution = (Solution) next();
		}
		return null;
	}

	/**
	 * Removes current solution from solution list
	 * 
	 */
	@Override
	public void remove() {
		solutionlist.remove(currentSolutionNumber);
	}

}