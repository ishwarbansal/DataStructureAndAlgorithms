package com.data.structure.backtracking;

public class NQueen {

/*	51. N-Queens
	Hard
	The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
	Given an integer n, return all distinct solutions to the n-queens puzzle.
	Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

	Example 1:
	Input: n = 4
	Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
	Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

	Example 2:
	Input: n = 1
	Output: [["Q"]]

	Constraints:
	1 <= n <= 9
	
	Below solution is for one probability not for all probability.
*/

	public boolean makeNQueen(int[][] chess, int row) {
		if(row==chess.length-1) {
			return true;
		}

		for(int col=0; col<chess.length; col++) {
			int newRow = row + 1;
			if(isValidMove(chess, row, col)) {
				chess[newRow][col] = 1;
				if(makeNQueen(chess, newRow))
					return true;

				chess[newRow][col] = 0;
			}
		}
		return false;
	}

	public boolean isValidMove(int[][] chess, int row, int col) {
		for(int i=0; i<=row; i++) {
			if(chess[i][col]==1) {
				return false;
			}
		}

		if(col-1>=0 && chess[row][col-1]==1) {
			return false;
		}
		if(col+1<chess.length && chess[row][col+1]==1) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		int[][] chess = new int[4][4];
		int row=0;
		for(int col=0; col<chess[row].length; col++) {
			chess[row][col] = 1;
			if(nQueen.makeNQueen(chess, row)) {
				break;
			}else {
				chess[row][col] = 0;
			}
		}
	}
}
