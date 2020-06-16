package com.leetcode.challenge.may2020.week2;

public class DayFive {

	public int singleNonDuplicate(int[] nums) {
		if(nums.length==1)
			return nums[0];
		
		int start=0; int end = nums.length-1;

		while(start < end) {
			int mid = start + (end-start)/2;

			if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1])
				return nums[mid];

			if(mid%2==0) {
				if(nums[mid]==nums[mid-1])
					end = mid-2;
				else
					start = mid+2;
			}else {
				if(nums[mid]==nums[mid-1])
					start = mid+1;
				else
					end = mid-1;
				
			}

		}
		return nums[start];

	}

	public static void main(String[] args) {
		DayFive dayFourth = new DayFive();
		
		System.out.println(dayFourth.singleNonDuplicate(new int[] {0,1,1,2,2,3,3}));
		System.out.println(dayFourth.singleNonDuplicate(new int[] {1,1,2}));
		System.out.println(dayFourth.singleNonDuplicate(new int[] {1,1,2,3,3,4,4,8,8}));
		System.out.println(dayFourth.singleNonDuplicate(new int[] {3,3,7,7,10,11,11}));
		System.out.println(dayFourth.singleNonDuplicate(new int[] {1,1,2,2,3}));
	}

}
