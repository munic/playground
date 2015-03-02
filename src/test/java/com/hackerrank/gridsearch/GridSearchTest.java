package com.hackerrank.gridsearch;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GridSearchTest {
	
	private GridSearch gridSearch;
	private char[][] testGrid;
	private char[][] testPattern;

	@Before
	public void setUp() throws Exception {	

		testGrid = new char[][]{
				{'A','B','F','H','Q'},
				{'D','F','J','H','F'},
				{'G','E','N','H','A'},
				{'L','L','L','Q','P'}
		};
		
		testPattern = new char[][]{
				{'G','E'},
				{'L','L'}
		};
		
		gridSearch = new GridSearch(testGrid, testPattern);	
	}

	@Test
	public void containsPattern(){
		testGrid = new char[][]{
				{'A','B','F','H','Q'},
				{'D','F','J','H','F'},
				{'G','E','N','H','A'},
				{'L','L','L','Q','P'}
		};
		
		testPattern = new char[][]{
				{'F','J'},
				{'E','N'},
				{'L','L'}
		};
		assertTrue("Pattern not found in grid", gridSearch.containsPattern());
	}	
}
