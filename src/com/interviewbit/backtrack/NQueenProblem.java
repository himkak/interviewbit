package com.interviewbit.backtrack;

import java.util.ArrayList;

import org.junit.Test;

public class NQueenProblem {

	public ArrayList<ArrayList<String>> solveNQueens(int a) {

		int[][] board = new int[a][a];
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		processRowWise(0, board, a, result);
		return result;
	}

	private boolean processRowWise(int row, int[][] board, int n, ArrayList<ArrayList<String>> result) {
		if (row == n) {
			ArrayList<String> perSol = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < n; j++) {
					sb.append(getElem(board, i, j));

				}
				perSol.add(sb.toString());

			}
			// System.out.println("------");
			result.add(perSol);
			return false;
		}

		for (int col = 0; col < n; col++) {
			if (checkPos(row, col, board, n)) {
				board[row][col] = 1;
				if (!processRowWise(row + 1, board, n, result)) {
					board[row][col] = 0;
				}
				// else {
//					return true;
//				}
			}

		}
		return false;

	}

	private String getElem(int[][] board, int i, int j) {
		int el = board[i][j];
		if (el == 1) {
			return "Q";
		} else {
			return ".";
		}
	}

	private boolean checkPos(int row, int col, int[][] board, int n) {
		for (int i = 0; i < n; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}
		for (int i = 0; i < n; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
//check upper left diagonal
		int tmpRow;
		int tmpCol;
		if (col <= row) {
			tmpRow = row - col;
			tmpCol = 0;
		} else {
			tmpRow = 0;
			tmpCol = col - row;
		}
		for (int i = tmpRow, j = tmpCol; i < n && j < n; i++, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
//check lower left diagonal
		if (row + col <= n - 1) {
			tmpCol = 0;
			tmpRow = row + col;
		} else {
			tmpCol = col - n + 1 + row;
			tmpRow = n-1;
		}
		for (int i = tmpRow, j = tmpCol; i > -1 && j < n; i--, j++) {

			if (board[i][j] == 1) {
				return false;
			}

		}
		return true;
	}

	@Test
	public void testCheckPos() {
		int[][] board = { { 0, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		checkPos(2, 2, board, 4);
	}

	@Test
	public void test() {
		solveNQueens(3);
	}

}
