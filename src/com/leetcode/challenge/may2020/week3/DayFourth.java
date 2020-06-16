package com.leetcode.challenge.may2020.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayFourth {

	public boolean checkInclusion(String s1, String s2) {

		Map<Character, Integer> inputMap = new HashMap<Character, Integer>();
		for(char ch: s1.toCharArray()) {
			inputMap.put(ch, inputMap.getOrDefault(ch, 0)+1);
		}

		int start=0, end = s2.length();
		StringBuilder target = new StringBuilder();
		boolean matched = true;
		while(start<end) {
			target.append(s2.charAt(start++));

			if(target.length()==s1.length()) {
				if(target.toString().equals(s1)) {
					return true;
				}else {
					for(char ch: target.toString().toCharArray()) {
						if(inputMap.get(ch)==null) {
							matched = false;
							break;
						}else {
							if(inputMap.get(ch)>0) {
								inputMap.put(ch, inputMap.get(ch)-1);
							}else {
								matched = false;
								break;
							}
						}
					}
					if(matched) {
						return true;
					}else {
						inputMap = new HashMap<Character, Integer>();
						for(char ch: s1.toCharArray()) {
							inputMap.put(ch, inputMap.getOrDefault(ch, 0)+1);
						}
					}
					target.deleteCharAt(0);
					matched = true;
				}
			}
		}
		return false;
	}



	public boolean checkInclusion3(String s1, String s2) {
		int[] counts = new int[128];
		for(int i=0;i<s1.length();i++){
			counts[s1.charAt(i)]++;
		}
		int n = s1.length();

		int left=0;
		int right=0;
		char[] arr = s2.toCharArray();
		while(right<arr.length){
			while(right<arr.length && counts[arr[right]]>0){
				counts[arr[right]]--;
				right++;
			}

			if(right-left==n)return true;

			while(right<arr.length && counts[arr[right]]<=0){
				counts[arr[left++]]++;
			}
		}
		return false;
	}


	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> matchedList = new ArrayList<Integer>();
		int windowStart = 0, matched = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char chr : p.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

		// our goal is to match all the characters from the 'charFrequencyMap' with the current window
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
			char rightChar = s.charAt(windowEnd);
			if (charFrequencyMap.containsKey(rightChar)) {
				// decrement the frequency of the matched character
				charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
				if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
					matched++;
			}

			if (matched == charFrequencyMap.size()) {
				matchedList.add(windowStart);
			}

			if (windowEnd >= p.length() - 1) { // shrink the window by one character
				char leftChar = s.charAt(windowStart++);
				if (charFrequencyMap.containsKey(leftChar)) {
					if (charFrequencyMap.get(leftChar) == 0)
						matched--; // before putting the character back, decrement the matched count
					// put the character back for matching
					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
				}
			}
		}

		return matchedList;

	}
	public boolean checkInclusion2(String s1, String s2) {
		int windowStart = 0, matched = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<>();
		for (char chr : s1.toCharArray())
			charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);

		// our goal is to match all the characters from the 'charFrequencyMap' with the current window
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < s2.length(); windowEnd++) {
			char rightChar = s2.charAt(windowEnd);
			if (charFrequencyMap.containsKey(rightChar)) {
				// decrement the frequency of the matched character
				charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) - 1);
				if (charFrequencyMap.get(rightChar) == 0) // character is completely matched
					matched++;
			}

			if (matched == charFrequencyMap.size())
				return true;

			if (windowEnd >= s1.length() - 1) { // shrink the window by one character
				char leftChar = s2.charAt(windowStart++);
				if (charFrequencyMap.containsKey(leftChar)) {
					if (charFrequencyMap.get(leftChar) == 0)
						matched--; // before putting the character back, decrement the matched count
					// put the character back for matching
					charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) + 1);
				}
			}
		}

		return false;
	}
	public static void main(String[] args) {
		DayFourth dayFourth = new DayFourth();
		
		List<Integer> list = dayFourth.findAnagrams("baa","aa");
		
		for(int val:list) {
			System.out.println(val);
		}
	}

}
