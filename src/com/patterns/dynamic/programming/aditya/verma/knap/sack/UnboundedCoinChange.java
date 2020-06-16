package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class UnboundedCoinChange {

	int[][] b;

	public UnboundedCoinChange(int n, int w) {
		b = new int[n][w];
	}

	public int getCoinChangeUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0)
			return 1;
		if(n==0)
			return 0;

		if(arr[n-1]<=sum) {
			return getCoinChangeUsingRecurssion(arr, sum-arr[n-1], n) + getCoinChangeUsingRecurssion(arr, sum, n-1);
		}else {
			return getCoinChangeUsingRecurssion(arr, sum, n-1);
		}
	}

	public int getCoinChangeUsingDP(int[] arr, int sum, int n) {
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j==0)
					b[i][j] = 1;
				else if(i==0)
					b[i][j] = 0;
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(arr[i-1]<=j) {
					b[i][j] =  b[i] [j-arr[i-1]] + b[i-1][j];
				}else
					b[i][j]= b[i-1][j];
			}
		}		
		printSelectedElements(b, arr, sum);
		return b[n][sum];
	}
	
	private void printSelectedElements(int dp[][], int[] weights, int capacity){
		System.out.println("Selected coins:");
//		System.out.println("dp.length "+ dp.length);
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}

//		System.out.println("Total Capacity "+ capacity);
//		int row = weights.length;
//		while(row>0 && capacity > 0) {
//			if(dp[row][capacity] != dp[row-1][capacity]) {
//				System.out.print(" " + weights[row-1]);
//				capacity-=weights[row-1];
//			}else {
//				row--;
//			}
//		}

		System.out.println("");
	}


	public static void main(String[] args) {
		int[] arr = {1,2,3};

		int sum = 5;

		UnboundedCoinChange testDP = new UnboundedCoinChange(arr.length+1, sum+1);
//		System.out.println("getCoinChangeUsingRecurssion  "+ testDP.getCoinChangeUsingRecurssion(arr, sum, arr.length));
		System.out.println("getCoinChangeUsingDP  "+ testDP.getCoinChangeUsingDP(arr, sum, arr.length));
	}
}
