package com.patterns.sliding.window;

/*Given an array of positive numbers 
 * and a positive number ‘k’, 
 * find the maximum sum of any contiguous subarray of size ‘k’.
*/

public class MaxSumSubArrayOfSizeK {

	//Documented
	public static void findMaxSumSubArray2(int k, int[] arr) {
		int windowSum = 0 , maxSum = 0;
		int windowStart = 0;
		int len = arr.length;
		for(int windowEnd = 0; windowEnd < len; windowEnd++) {
			windowSum += arr[windowEnd];
			if(windowEnd >= k-1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum-=arr[windowStart];
				windowStart++;
			}
		}
		System.out.println(maxSum);
	}
	
	//Ishwar
	public static void findMaxSumSubArray(int k, int[] arr) {
		// TODO: Write your code here
		int len = arr.length;
		int sum = 0;
		int maxSum = -1;
		for(int i=0; i<=len-k; i++) {
			sum = 0;
			for(int j=i; j<i+k; j++) {
				sum += arr[j];
			}
			maxSum = Math.max(sum, maxSum);
		}
		System.out.println("Largest Sum " + maxSum);
	}
	
	public static void main(String[] args) {
		findMaxSumSubArray(2, new int[] {2, 3, 4, 1, 5});
		findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2});
	}


}
