package com.patterns.sliding.window;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CharacterReplacement {

	public static int findLength2(String str, int k) {
		int windowStart = 0, maxLength = 0, maxRepeatLetterCount = 0;
		Map<Character, Integer> letterFrequencyMap = new HashMap<>();
		// try to extend the range [windowStart, windowEnd]
		for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
			char rightChar = str.charAt(windowEnd);
//			System.out.println(rightChar);
			letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0) + 1);
			maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));
			// current window size is from windowStart to windowEnd, overall we have a letter which is
			// repeating 'maxRepeatLetterCount' times, this means we can have a window which has one letter 
			// repeating 'maxRepeatLetterCount' times and the remaining letters we should replace.
			// if the remaining letters are more than 'k', it is the time to shrink the window as we
			// are not allowed to replace more than 'k' letters
			if (windowEnd - windowStart + 1 - maxRepeatLetterCount > k) {
				char leftChar = str.charAt(windowStart);
				letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar) - 1);
				windowStart++;
			}
			maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
		}
//		System.out.println(maxLength);
		return maxLength;
	}
	//Ishwar
	public static int findLength(String str, int k) {
		// TODO: Write your code here

		int maxLen = -1;
		Map<Character, Integer> longestSubArr = new LinkedHashMap<Character, Integer>();
		int currentLen = 0 ;

		for(int endIndex=0; endIndex<str.length(); endIndex++) {
			longestSubArr.put(str.charAt(endIndex), longestSubArr.getOrDefault(str.charAt(endIndex), 0)+1);
			if(longestSubArr.size() > 2  )  {
				maxLen = Math.max(maxLen, currentLen);
				currentLen -= longestSubArr.get((Character) longestSubArr.keySet().toArray()[0]);
				longestSubArr.remove(longestSubArr.keySet().toArray()[0]);
			}else if(longestSubArr.size() == 2  && checkLenExceed(longestSubArr, k)) {
				maxLen = Math.max(maxLen, currentLen);
				currentLen -= longestSubArr.get((Character) longestSubArr.keySet().toArray()[0]);
				longestSubArr.remove(longestSubArr.keySet().toArray()[0]);
			}else {
				maxLen = Math.max(maxLen, currentLen+1);
			} 
			currentLen ++;
		}

		return maxLen;
	}

	private static boolean checkLenExceed(Map<Character, Integer> map, int k) {
		boolean valueExceeds = true;

		for(Map.Entry<Character, Integer> entries : map.entrySet()) {
			if (entries.getValue() <= k ) {
				valueExceeds = false;
			}
		}

		return valueExceeds;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findLength2("aaaaabccbb", 2));
//		System.out.println(findLength2("abbcb", 1));
//		System.out.println(findLength2("abccde", 1));
//		System.out.println(findLength2("abbaaabbabb", 2));
//		System.out.println(findLength2("abaabbabbaabb", 3));
	}

}
