package com.patterns.top.k.elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

	public static String sortCharacterByFrequency(String str) {
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char ch : str.toCharArray())
			charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0) + 1);

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		// add all characters to the max heap
		maxHeap.addAll(charFrequencyMap.entrySet());
		
	    StringBuilder sortedString = new StringBuilder(str.length());
	    while (!maxHeap.isEmpty()) {
	      Map.Entry<Character, Integer> entry = maxHeap.poll();
	      for (int i = 0; i < entry.getValue(); i++)
	        sortedString.append(entry.getKey());
	    }
	    return sortedString.toString();

	}

	public static void main(String[] args) {
		String result = FrequencySort.sortCharacterByFrequency("Programming");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);

		result = FrequencySort.sortCharacterByFrequency("abcbab");
		System.out.println("Here is the given string after sorting characters by frequency: " + result);
	}

}
