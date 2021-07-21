package com.data.structure.backtracking;

public class SudokuSolver {

	static int count=0;
	public void solveSudoku(char[][] board) {
		fillSudoku(board, 0, 0);
		display(board);
		System.out.println("Counts are "+ count);
	}

	public boolean fillSudoku(char[][] board, int row, int col) {
		if(row==board.length-1 && col==board.length) {
			return true;
		}


		if(col==board.length) {
			row++;
			col=0;
		}


		//If col already have digit, move on to next column.
		if(board[row][col]!='.') {
			count++;
			return fillSudoku(board, row, col+1);
		}
		//Otherwise check for all posibilities of digits 1-9.
		for(char po='1'; po<='9'; po++) {
			count++;
			//To check if same digits exists or not in same row, same col or same 3 x 3 matrix.
			if(isValid(board, row, col, po)) {
				board[row][col] = po;
				if(fillSudoku(board, row, col+1))
					return true;
				board[row][col] = '.';
			}			
		}
		return false;
	}	

	boolean isValid(char[][]board, int row, int col, char val) {

		for(int i=0; i<board.length; i++) {
			if(board[row][i]==val || board[i][col]==val)
				return false;
		}

		int spRow = 3*(row/3);
		int spCol = 3*(col/3);

		for(int i=spRow; i<spRow+3; i++) {
			for(int j=spCol; j<spCol+3; j++) {
				if(board[i][j] == val)
					return false; 
			}
		}

		return true;
	}

	public void display(char[][] board) {
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j] + "  ");
			}
			System.out.println("");
		}
	}
	public static void main(String[] args) {
		SudokuSolver obj = new SudokuSolver();
		char[][] board = new char[][] {

			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		obj.solveSudoku(board);
	}
}
