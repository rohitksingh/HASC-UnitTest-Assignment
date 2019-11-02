package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.Solution;
import hacs.SolutionIterator;
import hacs.SolutionList;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */

@DisplayName("When running Solution Iterator")
class TestSolutionIterator {

	SolutionIterator solutionIterator;
	SolutionList solutionList;
	Solution solution;

	/**
	 * Initiates resources before each test methods
	 */
	@BeforeEach
	void init() {

		solutionList = new SolutionList();
		solution = new Solution();
		solutionList.add(solution);
		solutionIterator = new SolutionIterator(solutionList);
	}

	/**
	 * Tests if iterator has next element
	 */
	@Test
	@DisplayName("test next")
	void testNext() {
		assertTrue(solutionIterator.hasNext());
	}

	/**
	 * Tests if iterator returns null when list is empty
	 */
	@Test
	@DisplayName("test next when list is empty")
	void testNextWhenEmpty() {
		assertFalse(new SolutionIterator(new SolutionList()).hasNext());
	}

	/**
	 * Tests if Iterator returns null when listiterator reaches at the last element
	 */
	@Test
	@DisplayName("test next when there is no element left")
	void testNextWhenPoppedAll() {
		solutionIterator.next();
		assertFalse(solutionIterator.hasNext());
	}

	/**
	 * Tests id elenet is removed from iterator
	 */
	@Test
	@DisplayName("test remove")
	void testRemove() {
		int size = 0;
		while (solutionIterator.hasNext()) {
			size++;
			solutionIterator.next();
		}
		solutionIterator.remove();
		int newSize = 0;
		while (solutionIterator.hasNext()) {
			newSize++;
			solutionIterator.next();
		}

		assertTrue(newSize == size - 1);
	}

	/**
	 * Tests if next suitable element is retrieved from iterator using key
	 */
	@Test
	@DisplayName("test next suitable course when it exists")
	void testGetNextSuiatble() {
		Solution actual = (Solution) solutionIterator.next("");
		assertEquals(solution, actual);
	}

	/**
	 * Tests if null is returned when there is no solution thats maps to given key
	 */
	@Test
	@DisplayName("test next suitable course when it does not exists")
	void testGetNextSuiatbleNotFound() {
		Solution actual = (Solution) solutionIterator.next("ser531");
		assertNull(actual);
	}

}
