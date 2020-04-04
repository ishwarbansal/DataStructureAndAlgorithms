package com.leetcode.challenge.april2020;

public class DayFourth {

	public void moveZeroes(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			int j = i+1;
			while(j<nums.length && nums[j]==0) {
				j++;
			}
			
			if(j>=nums.length)
				break;
			
			if(nums[i]==0 && nums[j]!=0) {
				int previousVal = nums[i];
				nums[i] = nums[j];
				nums[j] = previousVal;
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
