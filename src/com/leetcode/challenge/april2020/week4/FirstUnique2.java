package com.leetcode.challenge.april2020.week4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstUnique2 {


	Map<Integer, Integer> uniqueMap = new LinkedHashMap<Integer, Integer>();
	Map<Integer, Integer> duplicateMap = new LinkedHashMap<Integer, Integer>();
	
	public FirstUnique2(int[] nums) {
		for(int val : nums) {
			if(uniqueMap.get(val)==null && duplicateMap.get(val)==null) {
				uniqueMap.put(val, 1);
			}else {
				uniqueMap.remove(val);
				duplicateMap.put(val, 1);
			}
		}
	}

	public int showFirstUnique() {
		if(uniqueMap.size()==0) {
			return -1;
		}
		Set<Integer> keySet = uniqueMap.keySet(); 
		Iterator<Integer> itr = keySet.iterator();
		return itr.next();
	}

	public void add(int value) {
		if(uniqueMap.get(value)==null && duplicateMap.get(value)==null) {
			uniqueMap.put(value, 1);
		}else {
			uniqueMap.remove(value);
			duplicateMap.put(value, 1);
		}
	}



	public static void main(String[] args) {
		FirstUnique2 firstUnique = new FirstUnique2(new int[]{633,2,3,5,633,8,9,10,633,12});
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(5);            // the queue is now [2,3,5,5]
		System.out.println(firstUnique.showFirstUnique()); // return 2
		firstUnique.add(2);            // the queue is now [2,3,5,5,2]
		System.out.println(firstUnique.showFirstUnique()); // return 3
		firstUnique.add(3);            // the queue is now [2,3,5,5,2,3]
		System.out.println(firstUnique.showFirstUnique()); // return -1

//		FirstUnique firstUnique = new FirstUnique(new int[] {7,7,7,7,7,7});
//		System.out.println(firstUnique.showFirstUnique()); // return -1
//		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7]
//		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
//		firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
//		firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
//		firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
//		System.out.println(firstUnique.showFirstUnique()); // return 17
		
	}

}
