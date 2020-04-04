package com.leetcode.challenge.april2020;

import java.util.Arrays;

public class DayThree {

	public int maxSubArray(int[] nums) {
		
		int arrMaxSum = Arrays.stream(nums).max().getAsInt();
		if(arrMaxSum<0)
			return arrMaxSum;
		
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int val : nums) {
			sum = sum + val < 0 ? 0 : sum + val;

			maxSum = Math.max(maxSum,  sum);
			
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(new DayThree().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		System.out.println(new DayThree().maxSubArray(new int[] {-2}));
	}

}
