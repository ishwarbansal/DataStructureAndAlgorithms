package com.leetcode.challenge.may2020.week1;

import java.util.HashMap;
import java.util.Map;

public class DaySix {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
		
		int maxNum = 0;
		int val =0 ;
		
		for(int num : nums) {
			int value = numCountMap.getOrDefault(num,0)+1;
			numCountMap.put(num, value);
			if(value > maxNum) {
				maxNum = value;
				val = num;
				if(maxNum>nums.length/2)
					break;
			}
			
		}
		return val;
	}
	
	public static void main(String[] args) {
		DaySix daySix = new DaySix();
		System.out.println(daySix.majorityElement(new int[] {2,2,1,1,1,2,2}));
	}

}
