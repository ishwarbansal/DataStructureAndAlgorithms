package com.leetcode.challenge.may2020.week1;

import java.util.HashMap;
import java.util.Map;

public class DayFive {

	public int firstUniqChar(String s) {
		
//		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
//		char[] charArr = s.toCharArray();
//
//		for(int i=0; i<charArr.length; i++) {
//			charMap.put(charArr[i], charMap.getOrDefault(charArr[i], 0)+1);
//		}
//		
//		for(int i=0; i<charArr.length; i++) {
//			if(charMap.get(charArr[i])==1) {
//				return i;
//			}
//		}
//		return -1;
		
//		int freq [] = new int[26];
//        for(int i = 0; i < s.length(); i ++)
//            freq [s.charAt(i) - 'a'] ++;
//        for(int i = 0; i < s.length(); i ++)
//            if(freq [s.charAt(i) - 'a'] == 1)
//                return i;
//        return -1;
		
		if(s == null || s.length() == 0) {
            return -1;
        }
        int res = s.length();
        for(char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)) {
                res = Math.min(res, index);
            }
        }
        return res == s.length() ? -1 : res;
	}

	public static void main(String[] args) {
		DayFive dayFive = new DayFive();
		System.out.println(dayFive.firstUniqChar("leetcode"));
	}
}
