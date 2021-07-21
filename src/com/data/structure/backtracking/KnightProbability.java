package com.data.structure.backtracking;

import java.util.Arrays;

/*688. Knight Probability in Chessboard
 * 
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. 
 * The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
 * A chess knight has 8 possible moves it can make. 
 * Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
 * 
 * Each time the knight is to move, it chooses one of eight possible moves uniformly at random 
 * (even if the piece would go off the chessboard) and moves there.
 * 
 * The knight continues moving until it has made exactly K moves or has moved off the chessboard. 
 * Return the probability that the knight remains on the board after it has stopped moving.
 * 
 * */

/*Complexity Analysis

Time Complexity: O(N^2 K) where N, K are defined as in the problem. 
We do O(1) work on each layer dp of N^2 elements, 
and there are K layers considered.

Space Complexity: O(N^2), the size of dp and dp1.*/

public class KnightProbability {

	static int[] rowMove =  {-2,-2,-1,-1, 1, 1, 2, 2};
	static int[] colMove =  {-1, 1,-2, 2,-2, 2,-1, 1};

	public double knightProbability(int N, int K, int r, int c) {
		int len = N;

		double dp0[][] = new double[len][len];

		for(double[] row : dp0) 
			Arrays.fill(row, 1);

		for(int l = 0; l < K; l++) {
			double[][] dp1 = new double[len][len];
			for(int i = 0; i < len; i++) {
				for(int j = 0; j < len; j++) {
					for(int k=0; k<rowMove.length; k++) {
						int newRow = i + rowMove[k];
						int newCol = j + colMove[k];

						if(isLegal(newRow, newCol, len)) 
							dp1[i][j] += dp0[newRow][newCol];
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

	public static void main(String[] args) {
		KnightProbability obj = new KnightProbability();
		obj.knightProbability(3,2,0,0);
	}

}
