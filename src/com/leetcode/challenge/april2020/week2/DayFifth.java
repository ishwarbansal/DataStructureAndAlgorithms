package com.leetcode.challenge.april2020.week2;

import java.util.HashMap;
import java.util.Map;

public class DayFifth {

	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int maxlen = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			System.out.println(i);
			count = count + (nums[i] == 1 ? 1 : -1);
			System.out.println("Count " + count);
			if (map.containsKey(count)) {
				maxlen = Math.max(maxlen, i - map.get(count));
				System.out.println("Max Len " + maxlen);
			} else {
				System.out.println("Count "+ count + " I "+i);
				map.put(count, i);
			}
			System.out.println("");
		}
		return maxlen;
	}

	public static void main(String[] args) {
		DayFifth dayFifth = new DayFifth();
//		System.out.println(dayFifth.findMaxLength(new int[] {0,1,0}));
		System.out.println(dayFifth.findMaxLength(new int[] {0,1,1,0,1,1,1,0}));
//		System.out.println(dayFifth.findMaxLength(new int[] {0,0,1,0,0,0,1,1}));
//		System.out.println(dayFifth.findMaxLength(new int[] {0,1,1,1,0,0,1,0,1}));
//		System.out.println(dayFifth.findMaxLength(new int[] {1,1,1,1,1,1,1}));
	}
}
