package com.pattern.first;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringKDistinct {

	//Documented
	public static int findLength3(String str, int k) {
		if (str == null || str.length() == 0 || str.length() < k)
			throw new IllegalArgumentException();

		int windowStart = 0, maxLength = 0;
		Map<Character, Integer> charFrequencyMap = new HashMap<Character, Integer>();
		// in the following loop we'll try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
			// shrink the sliding window, until we are left with 'k' distinct characters in the frequency map
			while (charFrequencyMap.size() > k) {
				char leftChar = str.charAt(windowStart);
				charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
				if (charFrequencyMap.get(leftChar) == 0) {
					charFrequencyMap.remove(leftChar);
				}
				windowStart++; // shrink the window
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
		}

		return maxLength;
	}


	//Documented update on Ishwar
	public static int findLength2(String str, int k) {
		// TODO: Write your code here
		List<String> strList = new ArrayList<String>() ;
		String var = "";
		int distinctChar = 0;
		int maxLen = 0;
		int strLen = str.length();
		String removedStr;
		for(int i=0; i<strLen; i++) {
			if(!var.contains(str.substring(i,i+1))) {
				distinctChar++;
			}
			var += str.charAt(i);

			if(distinctChar > k){
				if(var.length()>=maxLen+1) {
					strList.add(var.substring(0, var.length()-1));
					maxLen = var.length()-1;
				}
				boolean charExists = true;
				while(charExists) {
					removedStr = var.substring(0, 1);
					var = var.substring(1, var.length());
					if(!var.contains(removedStr)) {
						distinctChar--;
						charExists = false;
					}
				}
				if (i==strLen-1 && distinctChar == k && var.length() >= maxLen){
					strList.add(var.substring(0, var.length()));
					maxLen = var.length();
				}
			}else if (i==strLen-1){
				strList.add(var.substring(0, var.length()));
				maxLen = var.length();
			}
		}
		for(String st : strList) {
			System.out.println(st);
		}
		return -1;
	}

	//Ishwar
	public static int findLength(String str, int k) {
		// TODO: Write your code here
		List<String> strList = new ArrayList<String>() ;
		String var = "";
		int startIndex = 0;
		int distinctChar = 0;
		int maxLen = 0;
		int strLen = str.length();
		for(int i=0; i<strLen; i++) {
			if(!var.contains(str.substring(i,i+1))) {
				distinctChar++;
			}
			if(distinctChar <= k) {
				var += str.charAt(i);
			}

			if(distinctChar > k || i==strLen-1){
				if(var.length()>=maxLen) {
					strList.add(var);
					maxLen = var.length();
				}
				distinctChar = 0;
				var = "";
				i = startIndex;
				startIndex++;
			}
		}
		for(String st : strList) {
			System.out.println(st);
		}
		return -1;
	}

	public static void main(String[] args) {
//		findLength("araaci", 2);
//		findLength2("araaci", 2);
//
//		findLength("aabaarrr", 2);
//		findLength2("aabaarrr", 2);
//
//		findLength("cbbebi", 3);
//		findLength2("cbbebi", 3);
		
		findLength3("acd", 2);
	}

}
