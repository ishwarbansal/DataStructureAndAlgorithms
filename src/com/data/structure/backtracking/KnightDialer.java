package com.data.structure.backtracking;

import java.util.Arrays;

/*
 * 935. Knight Dialer
 * 
 * The chess knight has a unique movement, it may move two squares vertically and one square horizontally, 
 * or two squares horizontally and one square vertically (with both forming the shape of an L).  
 * 
 * We have a chess knight and a phone pad as shown below, the knight can only stand on a numeric cell (i.e. blue cell).
 * 
 * Given an integer n, return how many distinct phone numbers of length n we can dial.
 * 
 * You are allowed to place the knight on any numeric cell initially and then you should perform n - 1 
 * jumps to dial a number of length n. All jumps should be valid knight jumps.
	Example 1:
	
	Input: n = 1
	Output: 10
	Explanation: We need to dial a number of length 1, so placing the knight over any numeric cell of the 10 cells is sufficient.
	Example 2:
	
	Input: n = 2
	Output: 20
	Explanation: All the valid number we can dial are [04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 */

public class KnightDialer {

	int[][] paths = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
	final int MOD = 1000000007;

	public int knightDialer(int N) {
		long[][] dp = new long[N][10];
		
		Arrays.fill(dp[0], 1);
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int p : paths[j]) {
					dp[i][j] = (dp[i][j] + dp[i - 1][p]) % MOD;
				}
			}
		}
		long res = 0;
		for (int i = 0; i < 10; i++) {
			res = (res + dp[N-1][i]) % MOD;
		}
		return (int)res;
	}


	public static void main(String[] args) {
		KnightDialer obj = new KnightDialer();

		System.out.println("Knight Dialer Unique Movement " + obj.knightDialer(3));
	}

}



