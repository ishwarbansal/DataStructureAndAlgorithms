package com.patterns.dynamic.programming.aditya.verma.knap.sack;

import java.util.ArrayList;
import java.util.Arrays;

public class kanpsack {

	int[][] dp;
	int[][] t;
	
	public kanpsack(int n, int w) {
		dp = new int[n][w];
		t = new int[n][w];

		for(int i=0; i<n; i++) {
			for(int j=0; j<w; j++) {
				dp[i][j] = -1;
			}
		}
	}

	public int getKnapSackUsingRecurssion(int[] w, int[] p, int c, int n, ArrayList<Integer> taken) {
		if(c==0 || n==0)
			return 0;

		if(w[n-1]<=c) {
			final int preTookSize = taken.size();
			int p1= p[n-1] + getKnapSackUsingRecurssion (w, p, c-w[n-1], n-1, taken);
			
			final int preLeftSize = taken.size();
			int p2= getKnapSackUsingRecurssion(w, p, c, n-1, taken);
			
			if(p1>p2) {
				if (taken.size() > preLeftSize) {
					System.out.println("p1 before clearing sublist> >> "+Arrays.toString(taken.toArray()));

					taken.subList(preLeftSize, taken.size()).clear();
					System.out.println("p1 after clearing sublist> >> "+Arrays.toString(taken.toArray()));

				}
	            taken.add(Integer.valueOf(n - 1));
	            return p1;
			}else {
	            if (preLeftSize > preTookSize) {
					System.out.println("p2 before clearing sublist> >> "+Arrays.toString(taken.toArray()));

	            	taken.subList(preTookSize, preLeftSize).clear();
					System.out.println("p2 after clearing sublist> >> "+Arrays.toString(taken.toArray()));

	            }
	            return p2;
			}
		}else {
			return getKnapSackUsingRecurssion(w, p, c, n-1, taken);
		}
	}

	public int getKnapSackUsingTopDown(int[] w, int[] p, int c, int n) {
		if(c==0 || n==0)
			return 0;

		if(dp[n][c]!=-1)
			return dp[n][c];

		if(w[n-1]<=c) {
			return dp[n][c] = Math.max(p[n-1]+getKnapSackUsingTopDown(w, p, c-w[n-1], n-1), getKnapSackUsingTopDown(w, p, c, n-1));
		}else
			return dp[n][c]= getKnapSackUsingTopDown(w, p, c, n-1);
	}

	public int getKnapSackUsingBottomUp(int[] w, int[] p, int c, int n) {
		t = new int[n+1][c+1];

		for(int i=0; i<=n; i++) {
			for(int j=0; j<=c; j++) {
				if(i==0 || j==0)
					t[i][j] = 0;
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=c; j++) {
				if(w[i-1]<=j) {
					t[i][j] = Math.max( p[i-1] + t[i-1] [j-w[i-1]], t[i-1][j]);
				}else
					t[i][j]= t[i-1][j];
			}
		}		
		printSelectedElements(t, w, p, c);
		return t[n][c];
	}
	
	private void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
		System.out.println("Selected weights:");
				
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}
		
		int totalProfit = dp[weights.length][capacity];
		for(int i=weights.length; i >0; i--) {
			if(totalProfit != dp[i-1][capacity]) {
				System.out.print(" " + weights[i-1]);
				capacity -= weights[i-1];
				totalProfit -= profits[i-1];
			}
		}

		if(totalProfit != 0)
			System.out.print(" " + weights[0]);
		System.out.println("");
	}

	public static void main(String[] args) {
//		int[] w = {2,3,1,4,};
//		int[] p = {4,5,3,7,};
//		int capacity = 5;
		
		//Jenny Input
		int[] w = {3,4,6,5};
		int[] p = {2,3,1,4};
		int capacity = 8;

		kanpsack testDP = new kanpsack(w.length+1, capacity+1);
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		System.out.println("getKnapSackUsingRecurssion" + testDP.getKnapSackUsingRecurssion(w, p, capacity, w.length, list));
//		System.out.println(Arrays.toString(list.toArray()));`
//		System.out.println("getKnapSackUsingTopDown "+ testDP.getKnapSackUsingTopDown(w, p, capacity, w.length));
		System.out.println("getKnapSackUsingBottomUp " +testDP.getKnapSackUsingBottomUp(w, p, capacity, w.length));
	}
}
