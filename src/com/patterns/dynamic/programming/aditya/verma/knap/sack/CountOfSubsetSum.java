package com.patterns.dynamic.programming.aditya.verma.knap.sack;

import java.util.ArrayList;
import java.util.List;

public class CountOfSubsetSum {

	List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public int getCountSubsetSumUsingRecurssion(int[] arr, int sum, int n, List<Integer> list) {
		if(sum==0) {
			result.add(new ArrayList<>(list));
			return 1;
		}
		if(n==0)
			return 0;

		if(arr[n-1]<=sum) {
			List<Integer> list2 = new ArrayList<Integer>(list);
			list.add(arr[n-1]);
			int count = getCountSubsetSumUsingRecurssion(arr, sum-arr[n-1], n-1, list) + getCountSubsetSumUsingRecurssion(arr, sum, n-1, list2);
			list.remove(list.size()-1);
			return count;
		}else {
			return getCountSubsetSumUsingRecurssion(arr, sum, n-1, list);
		}
	}

	public int getCountSubsetSumUsingDP(int[] arr, int sum, int n) {
		int[][] b = new int[arr.length+1][sum+1];
		
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
//		printSelectedElements(b, arr, sum);
		return b[n][sum];
	}

	private void printSelectedElements(int bp[][], int[] arr, int sum){
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

		CountOfSubsetSum testDP = new CountOfSubsetSum();
		System.out.println("getCountSubsetSumUsingRecurssion  "+ testDP.getCountSubsetSumUsingRecurssion(arr, sum, arr.length, new ArrayList()));
		System.out.println("getCountSubsetSumUsingDP  "+ testDP.getCountSubsetSumUsingDP(arr, sum, arr.length));
		
		for(List<Integer> list : testDP.result) {
			for(Integer val : list) {
				System.out.print(val + "   ");
			}
			System.out.println("");
		}
	}
}
