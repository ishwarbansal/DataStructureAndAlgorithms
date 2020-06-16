package com.leetcode.challenge.may2020.week1;

import java.util.HashMap;
import java.util.Map;

public class DayThree {

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> magzineCharMap = new HashMap<Character, Integer>();

		for(int i=0; i<magazine.length(); i++) {
			char ch = magazine.charAt(i);
			magzineCharMap.put(ch, magzineCharMap.getOrDefault(ch, 0)+1);
		}

		for(int i=0; i<ransomNote.length(); i++) {
			char ch = ransomNote.charAt(i);
			if(magzineCharMap.get(ch)==null) {
				return false;
			}else {
				if(magzineCharMap.get(ch)==1)
					magzineCharMap.remove(ch);
				else
					magzineCharMap.put(ch, magzineCharMap.getOrDefault(ch, 0)-1);
			}
		}
		return true;
	}


	public boolean canConstruct2(String ransomNote, String magazine) {
		int[] table = new int[128];
		
		for (char c : magazine.toCharArray())   
			table[c]++;
		
		for (char c : ransomNote.toCharArray()) {
			if (--table[c] < 0) 
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		System.out.println(new DayThree().canConstruct("a", "b"));
		System.out.println(new DayThree().canConstruct("aa", "ab"));
		System.out.println(new DayThree().canConstruct2("aa", "aab"));
	}
}
