package com.pattern.sliding.window;

/*Given an array of positive numbers and a positive number ‘S’, 
 * find the length of the smallest contiguous subarray 
 * whose sum is greater than or equal to ‘S’. 
 * Return 0, if no such subarray exists.
 * */

public class MinSizeSubArraySum {

	//Documented
	public static void findMinSumSubArray2(int k, int[] arr) {
		int windowSum = 0;
		int windowStart = 0;
		int len = arr.length;
		int minLen = Integer.MAX_VALUE;
		for(int windowEnd = 0; windowEnd < len; windowEnd++) {
			windowSum += arr[windowEnd];
			while(windowSum >= k) {
				minLen = Math.min(minLen, (windowEnd - windowStart + 1));
				windowSum -= arr[windowStart];
				windowStart++;
			}
		}
		System.out.println(minLen);
	}
	
	//Ishwar
	public static void findMinSumSubArray(int k, int[] arr) {
		int windowSum = 0;
		int windowStart = 0;
		int len = arr.length;
		int minLen = 0;
		for(int windowEnd = 0; windowEnd < len; windowEnd++) {
			windowSum += arr[windowEnd];
			if(windowSum >= k) {
				if(minLen > 0)
					minLen = Math.min(minLen, (windowEnd - windowStart + 1));
				else
					minLen = windowEnd - windowStart + 1;
				
				windowSum=0;
				windowEnd = windowStart;
				windowStart++;
			}
		}
		System.out.println(minLen);
	}

	public static void main(String[] args) {
		findMinSumSubArray2(7, new int[] {2,1,5,4,2,3,2});
		findMinSumSubArray2(7, new int[] {2,1,5,2,8});
		findMinSumSubArray2(8, new int[] {3,4,1,1,6});
	}


}
