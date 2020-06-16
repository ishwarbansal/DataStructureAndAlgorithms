package com.patterns.top.k.elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class MaximumDistinctElements {

	public static int findMaximumDistinctElements(int[] nums, int k) {
		Map<Integer, Integer> elementCntMap = new HashMap<Integer, Integer>();
		
		for(int val :nums)
			elementCntMap.put(val, elementCntMap.getOrDefault(val, 0)+1);
		
		PriorityQueue<Map.Entry<Integer, Integer>> pQueueFreqMorethanOne = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2)->e1.getValue()-e2.getValue());
		PriorityQueue<Map.Entry<Integer, Integer>> pQueueFreqOne = new PriorityQueue<Map.Entry<Integer, Integer>>((e1, e2)->e1.getValue()-e2.getValue());
		
		for(Entry<Integer, Integer> entry: elementCntMap.entrySet()) {
			if(entry.getValue()>1)
				pQueueFreqMorethanOne.add(entry);
			else
				pQueueFreqOne.add(entry);
		}
		
		while(!pQueueFreqMorethanOne.isEmpty()) {
			Map.Entry<Integer, Integer> entry = pQueueFreqMorethanOne.peek();
			if(entry.getValue()>1 && k>0) {
				entry.setValue(entry.getValue()-1);
				k--;
			}else {
				pQueueFreqOne.add(entry);
				pQueueFreqMorethanOne.poll();
			}
		}
		
		return pQueueFreqOne.size()-k;
	}

	public static void main(String[] args) {
		int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);

		result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
		System.out.println("Maximum distinct numbers after removing K numbers: " + result);
	}


}
