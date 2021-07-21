package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class MinimumSubsetSumDiff {

	
	public boolean getMinimumSubsetSumDiffUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0)
			return true;
		if(n==0)
			return false;

		if(arr[n-1]<=sum) {
			return getMinimumSubsetSumDiffUsingRecurssion(arr, sum-arr[n-1], n-1) || getMinimumSubsetSumDiffUsingRecurssion(arr, sum, n-1);
		}else {
			return getMinimumSubsetSumDiffUsingRecurssion(arr, sum, n-1);
		}
	}

	private void printSelectedElements(boolean bp[][], int[] arr, int sum){
		System.out.println("-----------");

		//		for(int i=0; i<bp.length; i++) {
		//			for(int j=0; j<bp[i].length; j++) {
		//				System.out.print(bp[i][j] + "  ");
		//			}
		//			System.out.println("");
		//		}

		System.out.print("Selected sums:");

		boolean isSum = bp[arr.length][sum];

		for(int i=arr.length; i > 0; i--) {
			if(isSum != bp[i-1][sum]) {
				System.out.print(" " + arr[i-1]);
				sum -= arr[i-1];
				isSum = bp[i][sum];
			}
		}
		System.out.println("");
	}
	
	public boolean[][] b = null;
	
	public int lastStoneWeightII(int[] stones) {
		int sum = 0;
		for(int val : stones)
			sum+=val;		
	
		getMinimumSubsetSumDiffUsingDP(stones, sum, stones.length);
	
		int minSubsetSumDiff = Integer.MAX_VALUE;
		int max = sum/2;
		for(int j=0; j<=max; j++) {
			if(b[b.length-1][j]) {
				minSubsetSumDiff = Math.min(minSubsetSumDiff,  sum-(2*j));
			}
		}
		return minSubsetSumDiff;
	}
	public boolean getMinimumSubsetSumDiffUsingDP(int[] arr, int sum, int n) {
		b = new boolean[arr.length+1][sum+1]; 
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
	
		return b[n][sum];
	}

	public static void main(String[] args) {
//				int[] arr = {1,2,3,9};
//				int[] arr = {2,7,4,1,8,1};
		int[] arr = {1,1,4,2,2};
		MinimumSubsetSumDiff testDP = new MinimumSubsetSumDiff();
		System.out.println(testDP.lastStoneWeightII(new int[]{2,7,4,1,8,1}));
		System.out.println(testDP.lastStoneWeightII(new int[]{1,1,4,2,2}));
	}
}
