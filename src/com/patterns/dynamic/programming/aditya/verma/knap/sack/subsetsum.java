package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class subsetsum {

	
	public boolean getSubsetSumUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0)
			return true;
		if(n==0)
			return false;

		if(arr[n-1]<=sum) {
			return getSubsetSumUsingRecurssion(arr, sum-arr[n-1], n-1) || getSubsetSumUsingRecurssion(arr, sum, n-1);
		}else {
			return getSubsetSumUsingRecurssion(arr, sum, n-1);
		}
	}

	boolean[][] b;
	
	public boolean getSubsetSumUsingBottomUp(int[] arr, int sum, int n) {
		b = new boolean[n+1][sum+1];
		
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j==0)
					b[i][j] = true;
				else if(i==0)
					b[i][j] = false;
			}
		}

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(arr[i-1]<=j) {
					b[i][j] =  b[i-1] [j-arr[i-1]] || b[i-1][j];
				}else
					b[i][j]= b[i-1][j];
			}
		}		
		printSelectedElements(b, arr, sum);
		return b[n][sum];
	}

	private void printSelectedElements(boolean bp[][], int[] arr, int sum){
		System.out.println("-----------");
//		
		for(int i=0; i<bp.length; i++) {
			for(int j=0; j<bp[i].length; j++) {
				System.out.print(bp[i][j] + "  ");
			}
			System.out.println("");
		}
		
		System.out.print("Selected sums:");
		
		boolean isSum = bp[arr.length][sum];
		
		for(int i=arr.length; i>0; i--) {
			if(isSum != bp[i-1][sum]) {
				System.out.print(" " + arr[i-1]);
				sum -= arr[i-1];
				isSum = bp[i][sum];
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] arr = {2,3,7};
		int sum = 5;

		subsetsum testDP = new subsetsum();
//		System.out.println("getSubsetSumUsingRecurssion  "+ testDP.getSubsetSumUsingRecurssion(arr, sum, arr.length));
		System.out.println("getSubsetSumUsingDP  "+ testDP.getSubsetSumUsingBottomUp(arr, sum, arr.length));
//		System.out.println("getSubsetSumUsingDP  "+ testDP.getSubsetSumUsingBottomUp(arr, 18, arr.length));
//		System.out.println("getSubsetSumUsingDP  "+ testDP.getSubsetSumUsingBottomUp(arr, 15, arr.length));
//		testDP = new subsetsum(arr.length+1, 30+1);
//		System.out.println("getSubsetSumUsingDP  "+ testDP.getSubsetSumUsingBottomUp(arr, 30, arr.length));
	}
}
