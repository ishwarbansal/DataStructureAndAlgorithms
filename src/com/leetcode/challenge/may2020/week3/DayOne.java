package com.leetcode.challenge.may2020.week3;

public class DayOne {

	public int maxSubarraySumCircular(int[] A) {
		int totalSum=0;
		int maxEndingAt=0;
		int minEndingAt=0;
		int maxSum = Integer.MIN_VALUE;
		int minSum = Integer.MAX_VALUE;
		
		for(int val : A) {
			totalSum += val;

			maxEndingAt = Math.max(maxEndingAt + val, val);
			maxSum = Math.max(maxEndingAt, maxSum);

			minEndingAt = Math.min(minEndingAt + val, val);
			minSum = Math.min(minEndingAt, minSum);
		}
		if(maxSum>0)
			return Math.max(maxSum, totalSum-minSum);

		return maxSum;
	}

	public static void main(String[] args) {
		DayOne dayOne = new DayOne();
//		System.out.println(dayOne.maxSubarraySumCircular(new int[] {1,-2,3,-2}));
		System.out.println(dayOne.maxSubarraySumCircular(new int[] {5,-3,5}));
//		System.out.println(dayOne.maxSubarraySumCircular(new int[] {3,-1,2,-1}));
//		System.out.println(dayOne.maxSubarraySumCircular(new int[] {3,-2,2,-3}));
//		System.out.println(dayOne.maxSubarraySumCircular(new int[] {-2,-3,-1}));
	}

}
