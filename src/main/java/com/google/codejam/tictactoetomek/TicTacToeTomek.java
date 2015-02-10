package com.google.codejam.tictactoetomek;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
https://code.google.com/codejam/contest/2270488/dashboard
 * 
 */

public class TicTacToeTomek {

	public static void main(String[] args) {

		BoardParser parser = new BoardParser();
		List<Board> boards = parser.parse(args);

		for (int i = 0; i < boards.size(); i++) {
			Board board = boards.get(i);
			// if draw
			if (board.isDraw()) {
				System.out.println(String.format("Case #%d: Draw", i + 1));
				continue;
			}
			// if X won
			if (board.isXWinner()) {
				System.out.println(String.format("Case #%d: X won", i + 1));
				continue;
			}
			// if O won
			if (board.isOWinner()) {
				System.out.println(String.format("Case #%d: O won", i + 1));
				continue;
			}

			// not finished yet
			System.out.println(String.format(
					"Case #%d: Game has not completed", i + 1));
			continue;
		}
	}
}

class BoardParser {

	private static final int BOARD_DIM = 4;

	public List<Board> parse(String[] args) {
		List<Board> boards = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			int numberOfBoards = Integer.parseInt(br.readLine());
			for (int i = 0; i < numberOfBoards; i++) {
				BoardBuilder boardBuilder = new BoardBuilder();
				for (int j = 0; j < BOARD_DIM; j++) {
					String currentRow = br.readLine();
					boardBuilder.addRow(j, currentRow.toCharArray());
				}
				boards.add(boardBuilder.build());
				if (i == numberOfBoards - 1) {
					break;
				}
				// skip separator row
				br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return boards;
	}
}

class Board {

	char[][] board = new char[4][4];

	public void addRow(int rowNumber, char[] rowValues) {
		for (int i = 0; i < rowValues.length; i++) {
			board[rowNumber - 1][i] = rowValues[i];
		}
	}

	public boolean isDraw() {
		boolean isDraw = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.') {
					isDraw = false;
					return isDraw;
				}
			}
		}
		return isDraw;
	}

	public boolean isXWinner() {
		return hasWon('X');
	}

	public boolean isOWinner() {
		return hasWon('O');
	}

	private boolean hasWon(char c) {
		char[][] copy = copyReplaceT(c);
		boolean hasWon = false;
		// 4-in-the-row
		for (int i = 0; i < 4; i++) {
			hasWon = copy[i][0] == c 
					&& copy[i][1] == c && copy[i][2] == c && copy[i][3] == c;
			if (hasWon) {
				return hasWon;
			}
		}
		 // 4-in-the-column
		for (int j = 0; j < 4; j++) {

			hasWon = copy[0][j] == c
					&& copy[1][j] == c && copy[2][j] == c && copy[3][j] == c;
			if (hasWon) {
				return hasWon;
			}
		}
		// diag down
		hasWon = copy[0][0] == c && copy[1][1] == c && copy[2][2] == c
				&& copy[3][3] == c;
		if (hasWon) {
			return hasWon;
		}
		// diag up
		hasWon = copy[3][0] == c && copy[2][1] == c && copy[1][2] == c
				&& copy[0][3] == c;

		return hasWon;
	}

	public void printBoard() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private char[][] copyReplaceT(char replacement) {
		char[][] copy = new char[4][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				copy[i][j] = board[i][j] == 'T' ? replacement : board[i][j];
			}
		}
		return copy;
	}
}

class BoardBuilder {

	private char[] firstRow;
	private char[] secondRow;
	private char[] thirdRow;
	private char[] fourthRow;
	public BoardBuilder() {

	}

	public void addRow(int index, char[] row) {
		switch (index) {
		case 0:
			firstRow = row;
			break;
		case 1:
			secondRow = row;
			break;
		case 2:
			thirdRow = row;
			break;
		case 3:
			fourthRow = row;
			break;
		default:
			// throw Exception
		}
	}

	public BoardBuilder(String first, String second, String third, String fourth) {
		this.firstRow = first.toCharArray();
		this.secondRow = second.toCharArray();
		this.thirdRow = third.toCharArray();
		this.firstRow = fourth.toCharArray();
	}

	public Board build() {
		Board board = new Board();
		board.addRow(1, firstRow);
		board.addRow(2, secondRow);
		board.addRow(3, thirdRow);
		board.addRow(4, fourthRow);
		return board;
	}
}