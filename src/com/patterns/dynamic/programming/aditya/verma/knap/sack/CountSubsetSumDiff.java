package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class CountSubsetSumDiff {

	int[][] b;

	public CountSubsetSumDiff(int n, int w) {
		b = new int[n][w];
	}

	public int getCountSubsetSumDiffUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0)
			return 1;
		if(n==0)
			return 0;

		if(arr[n-1]<=sum) {
			return getCountSubsetSumDiffUsingRecurssion(arr, sum-arr[n-1], n-1) + getCountSubsetSumDiffUsingRecurssion(arr, sum, n-1);
		}else {
			return getCountSubsetSumDiffUsingRecurssion(arr, sum, n-1);
		}
	}

	public int getCountSubsetSumDiffUsingDP(int[] arr, int sum, int n) {
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
					b[i][j] =  b[i-1] [j-arr[i-1]] + b[i-1][j];
				}else
					b[i][j]= b[i-1][j];
			}
		}		
		printSelectedElements(b, arr, sum);
		return b[n][sum];
	}

	private void printSelectedElements(int bp[][], int[] arr, int sum){
		System.out.println("-----------");

		for(int i=0; i<bp.length; i++) {
			for(int j=0; j<bp[i].length; j++) {
				System.out.print(bp[i][j] + "  ");
			}
			System.out.println("");
		}

		System.out.print("Selected sums:");

		int isSum = bp[arr.length][sum];

		//		for(int i=arr.length; i > 0; i--) {
		//			if(isSum != bp[i-1][sum]) {
		//				System.out.print(" " + arr[i-1]);
		//				sum -= arr[i-1];
		//				isSum = bp[i][sum];
		//			}
		//		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] arr = {1,1,2,3};

		int sum = 0, minDiff = 1;

		for(int val : arr)
			sum+=val;


		CountSubsetSumDiff testDP = new CountSubsetSumDiff(arr.length+1, ((minDiff+sum)/2)+1);
		//		System.out.println("getCountSubsetSumDiffUsingRecurssion " + testDP.getCountSubsetSumDiffUsingRecurssion(arr, (minDiff+sum)/2, arr.length));

		int result = testDP.getCountSubsetSumDiffUsingDP(arr, (minDiff+sum)/2, arr.length);
		System.out.println("getCountSubsetSumDiffUsingDP " + result);
		//		int[] minDiffArr = new int[result];
		//		int row = 0;
		//		for(int i=testDP.b.length-1; i>=testDP.b.length-1; i--) {
		//			for(int j=0; j<testDP.b[i].length/2; j++) {
		//				System.out.println("Arr : "  + testDP.b[i][j]);
		//				if(testDP.b[i][j]>=1) {
		//					minDiffArr[row++] = j;
		//				}
		//			}
		//		}
		//		for(int val : minDiffArr) {
		//			System.out.println(val);
		//		}
		//		System.out.println("minSubsetSumDiff " + minSubsetSumDiff);

	}
}
