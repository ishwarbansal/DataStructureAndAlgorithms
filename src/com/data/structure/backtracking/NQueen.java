package com.data.structure.backtracking;

public class NQueen {


	public boolean makeNQueen(int[][] chess, int row) {
		if(row==chess.length-1) {
			System.out.println("N Queen Done");
			printMatrix(chess);
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

	public void printMatrix(int[][] chess) {
		for (int row = 0; row < chess.length; row++)
		{
			for (int col = 0; col < chess[row].length; col++)
			{
				System.out.print(chess[row][col] + "  ");
			}
			System.out.println("");
		}

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
