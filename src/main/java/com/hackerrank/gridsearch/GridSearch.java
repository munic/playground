package com.hackerrank.gridsearch;

/**
 * See package.info
 */
public class GridSearch {

	private char[][] grid;
	private char[][] pattern;

	public GridSearch(char[][] grid, char[][] pattern) {
		this.grid = grid;
		this.pattern = pattern;
	}

	public boolean containsPattern() {
		int gridRows = grid.length;
		int gridColumns = grid[0].length;
		int patternRows = pattern.length;
		int patternColumns = pattern[0].length;
		for (int i = 0; i <= gridRows - patternRows; i++) {
			for (int j = 0; j <= gridColumns - patternColumns; j++) {
				if (patternMatchesAtGridLocation(i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Assumption that we always deal with real two dimensional arrays (same
	 * column count for each row)
	 * 
	 * @param i
	 * @param j
	 * @param grid
	 * @param pattern
	 * @return
	 */
	private boolean patternMatchesAtGridLocation(int i, int j) {
		int gridRowIndex = i;
		int gridColumnIndex = j;
		int patternRows = pattern.length;
		int patternColumns = pattern[0].length;

		for (int patternRowIndex = 0; patternRowIndex < patternRows; patternRowIndex++, gridRowIndex++) {
			for (int patternColumnnIndex = 0; patternColumnnIndex < patternColumns; patternColumnnIndex++, gridColumnIndex++) {
				if (grid[gridRowIndex][gridColumnIndex] != pattern[patternRowIndex][patternColumnnIndex]) {
					return false;
				}
			}
			gridColumnIndex = j;
		}
		return true;
	}
}
