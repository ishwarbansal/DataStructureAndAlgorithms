package com.leetcode.challenge.april2020.week1;

public class DayFourth {

	public void moveZeroes(int[] nums) {
		int left = 0;
		for(int right=0; right<nums.length; right++) {
			if(nums[right]!=0) {
				int previousVal = nums[left];
				nums[left] = nums[right];
				nums[right] = previousVal;
				left++;
			}
		}

		for(int val : nums) {
			System.out.println(val);
		}
	}

	
	public static void main(String[] args) {
		new DayFourth().moveZeroes(new int[] {0,1,0,3,12});
	}
}
