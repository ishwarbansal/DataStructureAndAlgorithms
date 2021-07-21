package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class kanpsack {

	int[][] dp;
	
	public int getKnapSack(int[] w, int[] p, int c, int n) {
		dp = new int[n+1][c+1];

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=c; j++) {
				if(w[i-1]<=j) {
					dp[i][j] = Math.max( p[i-1] + dp[i-1] [j-w[i-1]], dp[i-1][j]);
				}else
					dp[i][j]= dp[i-1][j];
			}
		}		
		return dp[n][c];
	}
	
	public static void main(String[] args) {
		int[] w = {3,4,6,5};
		int[] p = {2,3,1,4};
		int capacity = 8;

		kanpsack testDP = new kanpsack();
		System.out.println("getKnapSackUsingBottomUp " +testDP.getKnapSack(w, p, capacity, w.length));
	}
}
