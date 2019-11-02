package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.ListIterator;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: msu
 * 
 * @author rsingh92
 * @version 1.0 Testing
 */

@DisplayName("When running listiterator")
class TestListIterator {

	ListIterator listIterator;
	ArrayList<Object> myList;
	Object test;

	/**
	 * Initiates resources befre each test method
	 */
	@BeforeEach
	void init() {
		myList = new ArrayList<>();
		test = new Object();
		myList.add(test);
		listIterator = new ListIterator(myList);
	}

	/**
	 * Tests if iterator has more element
	 */
	@Test
	@DisplayName("test has next")
	void testHasNext() {
		assertTrue(listIterator.hasNext());
	}

	/**
	 * Tests if iterator returns null when list is empty
	 */
	@Test
	@DisplayName("test has next when iterator is null")
	void testHasNextWhenNull() {
		assertFalse(new ListIterator(new ArrayList<>()).hasNext());
	}

	/**
	 * Tests if next element is retrieved from listiterator
	 */
	@Test
	@DisplayName("test next")
	void testNext() {
		Object actual = listIterator.next();
		assertEquals(test, actual);
	}

	/**
	 * Tests if next element is null when list is empty
	 */
	@Test
	@DisplayName("test next when iterator is empty")
	void testNextWhenNull() {
		Object actual = new ListIterator(new ArrayList<>()).next();
		assertEquals(null, actual);
	}

	/**
	 * Tests if element is removed from iterator
	 */
	@Test
	@DisplayName("test remove")
	void testRemove() {
		int size = 0;
		while (listIterator.hasNext()) {
			size++;
			listIterator.next();
		}
		listIterator.remove();
		int newSize = 0;
		while (listIterator.hasNext()) {
			newSize++;
			listIterator.next();
		}

		assertTrue(newSize == size - 1);
	}

}
