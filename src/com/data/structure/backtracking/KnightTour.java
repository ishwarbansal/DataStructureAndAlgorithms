package com.data.structure.backtracking;

import java.util.Arrays;

public class KnightTour {

	static int[] rowMove =  {-2,-2,-1,-1, 1, 1, 2, 2};
	static int[] colMove =  {-1, 1,-2, 2,-2, 2,-1, 1};
	static int moveCount = 1;
	public boolean checkKnightTour(int[][] chess, int row, int col, int count) {
		//		System.out.println("count "+count);
		if(count==64) {
			System.out.println("Chess Knight Tour Done");
			printMatrix(chess);
			return true;
		}

		for(int i=0; i<rowMove.length; i++) {
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];
			//			System.out.println(moveCount++);
			if(newRow >=0 && newCol>=0 && newRow<chess.length && newCol<chess[newRow].length && chess[newRow][newCol]==0) {
				count++;
				chess[newRow][newCol] = count;
				if(checkKnightTour(chess, newRow, newCol, count))
					return true;

				count--;
				chess[newRow][newCol] = 0;
			}
		}
		return false;
	}

	public void checkKnightTourDP(int[][] chess, int row, int col) {
		int count = 1;
		
		for(int i=row; i<chess.length; i++) {
			for(int j=col; j<chess.length; j++) {
				for(int k=0; k<rowMove.length; k++) {
					int newRow = i + rowMove[k];
					int newCol = j + colMove[k];
					if(newRow >=0 && newCol>=0 && newRow<chess.length && newCol<chess[newRow].length && chess[newRow][newCol]==0) {
						count++;
						chess[newRow][newCol] = count;
						break;
					}
				}
			}
		}
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
		KnightTour knightTour = new KnightTour();
		int[][] chess = new int[8][8];
		chess[0][0] = 1;
//		knightTour.checkKnightTour(chess, 0, 0, 1);
		knightTour.checkKnightTourDP(chess, 0, 0);
		knightTour.printMatrix(chess);
	}

	int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
	public double knightProbability(int N, int K, int r, int c) {
		int len = N;

		double dp0[][] = new double[len][len];

		for(double[] row : dp0) 
			Arrays.fill(row, 1);

		for(int l = 0; l < K; l++) {
			double[][] dp1 = new double[len][len];
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					for(int[] move : moves) {
						int row = i + move[0];
						int col = j + move[1];

						if(isLegal(row, col, len)) 
							dp1[i][j] += dp0[row][col];
					}
				}
			}
			dp0 = dp1;
		}
		return dp0[r][c] / Math.pow(8, K); 
	}
	private boolean isLegal(int r, int c, int len) {
		return r >= 0 && r < len && c >= 0 && c < len;
	}
}
