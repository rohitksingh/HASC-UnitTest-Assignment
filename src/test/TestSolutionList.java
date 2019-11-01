package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hacs.Solution;
import hacs.SolutionList;

@DisplayName("When running Test solution")
class TestSolutionList {

	@Test
	@DisplayName("test add solution")
	void testAddSolution()
	{
		SolutionList list = new SolutionList();
		Solution expected = new Solution();
		list.add(expected);
		Solution actual = list.get(list.size()-1);
		assertEquals(expected, actual);    
	}

}
