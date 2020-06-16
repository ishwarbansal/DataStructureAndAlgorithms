package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class UnboundedKanpsack {

	int[][] t;

	public UnboundedKanpsack(int n, int w) {
		t = new int[n][w];
	}

	public int getKnapSackUsingRecurssion(int[] w, int[] p, int c, int n) {
		if(c==0 || n==0)
			return 0;

		if(w[n-1]<=c) {
			return Math.max(p[n-1]+ getKnapSackUsingRecurssion (w, p, c-w[n-1], n), getKnapSackUsingRecurssion(w, p, c, n-1));
		}else {
			return getKnapSackUsingRecurssion(w, p, c, n-1);
		}
	}

	public int getKnapSackUsingBottomUp(int[] w, int[] p, int c, int n) {

		for(int i=0; i<=n; i++) {
			for(int j=0; j<=c; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=c; j++) {
				if(w[i-1]<=j) {
					t[i][j] = Math.max( p[i-1] + t[i] [j-w[i-1]], t[i-1][j]);
				}else
					t[i][j]= t[i-1][j];
			}
		}
		printSelectedElements(t, w, c);
		return t[n][c];
	}

	private void printSelectedElements(int dp[][], int[] weights, int capacity){
//		System.out.print("Selected weights:");
//		System.out.println("dp.length "+ dp.length);
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}

//		System.out.println("Total Capacity "+ capacity);
		int row = weights.length;
		while(row>0 && capacity > 0) {
			if(dp[row][capacity] != dp[row-1][capacity]) {
				System.out.print(" " + weights[row-1]);
				capacity-=weights[row-1];
			}else {
				row--;
			}
		}

		System.out.println("");
	}

	public static void main(String[] args) {
		int[] w = {1,2,3};
		int[] p = {10,30,20};
		int capacity = 7;
		UnboundedKanpsack testDP = new UnboundedKanpsack(w.length+1, capacity+1);
		//		System.out.println("getKnapSackUsingRecurssion " +testDP.getKnapSackUsingRecurssion(w, p, capacity, w.length));
		System.out.println("getKnapSackUsingBottomUp " +testDP.getKnapSackUsingBottomUp(w, p, capacity, w.length));
	}
}
