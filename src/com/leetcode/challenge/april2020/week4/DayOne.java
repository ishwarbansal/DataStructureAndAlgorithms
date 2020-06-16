package com.leetcode.challenge.april2020.week4;

import java.util.HashMap;

public class DayOne {

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap <>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
	}

	public static void main(String[] args) {
		DayOne dayOne = new DayOne();
		int[] arr1 = {1,2,2,2,3,3,4,5,7,8,10};
		System.out.println(dayOne.subarraySum(arr1, 12));
//		
//		int[] arr2 = {1,1,1};
//		System.out.println(dayOne.subarraySum(arr2, 2));
//		
//		int[] arr3 = {1};
//		System.out.println(dayOne.subarraySum(arr3, 0));
//		
//		int[] arr4 = {1,2,3};
//		System.out.println(dayOne.subarraySum(arr4, 3));
		
//		int[] arr5 = {1};
//		System.out.println(dayOne.subarraySum(arr5, 1));
		
//		int[] arr6 = {-1,-1,1};
//		System.out.println(dayOne.subarraySum(arr6, 1));
	}

}
