package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class EqualSubsetSum {


	public boolean getEqualSubsetSumUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0)
			return true;
		if(n==0)
			return false;

		if(arr[n-1]<=sum) {
			return getEqualSubsetSumUsingRecurssion(arr, sum-arr[n-1], n-1) || getEqualSubsetSumUsingRecurssion(arr, sum, n-1);
		}else {
			return getEqualSubsetSumUsingRecurssion(arr, sum, n-1);
		}
	}

	private void printSelectedElements(boolean bp[][], int[] arr, int sum){
		System.out.println("-----------");

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

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;

		for(int val : nums)
			sum+=val;

		if(sum%k==0) {
			return getEqualSubsetSumUsingDP(nums, sum/k, nums.length);
		}else {
			return false;
		}

	}

	public boolean canPartition(int[] nums) {
		int sum = 0;

		for(int val:nums)
			sum+=val;

		if(sum%2==0) {
			return getEqualSubsetSumUsingDP(nums, sum/2, nums.length);
		}
		return false;
	}
	public boolean getEqualSubsetSumUsingDP(int[] arr, int sum, int n) {
		boolean[][] b = new boolean[n+1][sum+1];
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
		int[] arr = {4, 3, 2, 3, 5, 2, 1};


		//		if(sum%4==0) {
		//			EqualSubsetSum testDP = new EqualSubsetSum();
		//			//			System.out.println("getEqualSubsetSumUsingRecurssion  "+ testDP.getEqualSubsetSumUsingRecurssion(arr, (sum/2)+1, arr.length));
		//			System.out.println("getEqualSubsetSumUsingDP  "+ testDP.getEqualSubsetSumUsingDP(arr, sum/3, arr.length));
		//		}

		EqualSubsetSum testDP = new EqualSubsetSum();
//		System.out.println(testDP.canPartitionKSubsets(arr, 4));
		System.out.println(testDP.canPartition(arr));
	}
}
