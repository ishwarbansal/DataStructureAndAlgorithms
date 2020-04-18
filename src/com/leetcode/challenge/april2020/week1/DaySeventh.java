package com.leetcode.challenge.april2020.week1;

import java.util.HashMap;
import java.util.Map;

public class DaySeventh {

	public int countElements(int[] arr) {
		if(arr.length < 1 || arr.length > 1000)
			return 0;
		
		int count = 0;
		
		Map<Integer, Integer> arrMap = new HashMap<Integer, Integer>();
		
		for(int val : arr) {
			arrMap.put(val, arrMap.getOrDefault(val,0) + 1);
			if(val < 0 || val > 1000)
				return 0;
		}
		
		for (Map.Entry<Integer, Integer> entry : arrMap.entrySet()) {
			if(arrMap.get(entry.getKey()+1)!=null) {
				count = count + entry.getValue();
			}
		}
		
		return count;
		
	}

	public static void main(String[] args) {
		System.out.println(new DaySeventh().countElements(new int[] {1,2,3}));
		System.out.println(new DaySeventh().countElements(new int[] {1,1,3,3,5,5,7,7}));
		System.out.println(new DaySeventh().countElements(new int[] {1,3,2,3,5,0}));
		System.out.println(new DaySeventh().countElements(new int[] {1,1,2,2}));
	}

}
