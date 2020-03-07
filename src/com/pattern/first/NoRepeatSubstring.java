package com.pattern.first;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

	//Documented
	public static int findLength2(String str) {
	    int windowStart = 0, maxLength = 0;
	    Map<Character, Integer> charIndexMap = new HashMap<>();
	    // try to extend the range [windowStart, windowEnd]
	    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
	      char rightChar = str.charAt(windowEnd);
	      // if the map already contains the 'rightChar', shrink the window from the beginning so that
	      // we have only one occurrence of 'rightChar'
	      if (charIndexMap.containsKey(rightChar)) {
	        // this is tricky; in the current window, we will not have any 'rightChar' after its previous index
	        // and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
	        windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
	      }
	      charIndexMap.put(str.charAt(windowEnd), windowEnd); // insert the 'rightChar' into the map
	      maxLength = Math.max(maxLength, windowEnd - windowStart + 1); // remember the maximum length so far
	    }

	    return maxLength;
	  }

	
	//Ishwar
	public static int findLength(String str) {
		// TODO: Write your code here

		String longestSubArr = "";
		int maxLength = -1;
		String longestStr = "";
		for(int i=0; i<str.length(); i++) {
			if(!longestStr.contains(str.substring(i,i+1))) {
				longestStr += str.charAt(i);
			} else {
				if(longestStr.length() >= maxLength) {
					maxLength = longestStr.length();
					longestSubArr = longestStr ;
				}
				longestStr = str.charAt(i)+"";
			}				
		}

		if(longestStr.length()>0 && longestStr.length() >= maxLength) {
			longestSubArr = longestStr ;
		}

		System.out.println(longestSubArr);
		return maxLength;
	}


	public static void main(String[] args) {
		System.out.println(findLength2("aabcc"));
//		System.out.println("---------------");
//		findLength("abbbb");
//		System.out.println("---------------");
//		findLength("abccde");
	}
}
