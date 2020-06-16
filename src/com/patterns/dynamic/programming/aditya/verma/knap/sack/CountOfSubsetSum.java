package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class CountOfSubsetSum {

	int[][] b;

	public CountOfSubsetSum(int n, int w) {
		b = new int[n][w];
	}

	public int getCountSubsetSumUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0)
			return 1;
		if(n==0)
			return 0;

		if(arr[n-1]<=sum) {
			return getCountSubsetSumUsingRecurssion(arr, sum-arr[n-1], n-1) + getCountSubsetSumUsingRecurssion(arr, sum, n-1);
		}else {
			return getCountSubsetSumUsingRecurssion(arr, sum, n-1);
		}
	}

	public int getCountSubsetSumUsingDP(int[] arr, int sum, int n) {
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



		int isSum = bp[arr.length][sum];
		int tempSum = sum;
		int nextElement = 0;
		for(int i=arr.length; i > 0; i--) {
			if(sum==tempSum) {
				System.out.println("Selected sums:");
				System.out.println("*****");
			}
			if(isSum != bp[i-1][tempSum]) {
				System.out.print(" " + arr[i-1]);
				tempSum -= arr[i-1];
				if(tempSum<=0) {
					nextElement++;
					if(bp[arr.length-nextElement][sum]>0) {
						tempSum = sum;
						System.out.println("");
						System.out.println("*****");
						isSum = bp[arr.length-nextElement][tempSum];
						i=arr.length-nextElement+1;
					}
				}else {
					isSum = bp[i][tempSum];
				}
			}else {
				if(sum==tempSum)
					nextElement++;
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int[] arr = {2,3,5,6,8,10};

		int sum = 10;

		CountOfSubsetSum testDP = new CountOfSubsetSum(arr.length+1, sum+1);
		System.out.println("getCountSubsetSumUsingRecurssion  "+ testDP.getCountSubsetSumUsingRecurssion(arr, sum, arr.length));
		System.out.println("getCountSubsetSumUsingDP  "+ testDP.getCountSubsetSumUsingDP(arr, sum, arr.length));
	}
}
