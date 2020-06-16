package com.leetcode.challenge.april2020.week4;

public class DayFourth {

	public boolean canJump(int[] nums) {
		if(nums.length==1) {
			if(nums[0]==0 || nums[0]==1) 
				return true;
			else
				return false;
		}

		int cnt = 1;
		for(int i=nums.length-2; i>=0; i--) {
			if(nums[i]==0)
				cnt++;
			else if(nums[i]>=cnt)
				cnt = 1;
			else
				cnt++;
		}
		if(nums[0]>= cnt)
			return true;
		return false;		
	}

	public static void main(String[] args) {
		DayFourth dayFourth = new DayFourth();
		//				System.out.println(dayFourth.canJump(new int[] {0}));
		//				System.out.println(dayFourth.canJump(new int[] {1}));
		System.out.println(dayFourth.canJump(new int[] {2,0}));
		System.out.println(dayFourth.canJump(new int[] {2,3,1,1,4}));
		System.out.println(dayFourth.canJump(new int[] {3,2,1,0,4}));
		System.out.println(dayFourth.canJump(new int[] {3,4,2,0,4}));
	}

}
