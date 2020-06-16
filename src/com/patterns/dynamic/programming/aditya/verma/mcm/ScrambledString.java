package com.patterns.dynamic.programming.aditya.verma.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {

	Map<String, Boolean> map = new HashMap<String, Boolean>();

	
	public boolean isScrambledString(String s1, String s2) {
		if(s1.compareTo(s2)==0)
			return true;

		if(s1.length()<=1)
			return false;
		
		int n = s1.length();
		boolean flag = false;

		for(int i=1; i<=n-1; i++) {
			flag = (
					(isScrambledString(s1.substring(0,i), s2.substring(n-i, n))
							&&
							(isScrambledString(s1.substring(i,n), s2.substring(0, n-i)))
							)
					||
					(isScrambledString(s1.substring(0,i), s2.substring(0, i))
							&&
							(isScrambledString(s1.substring(i,n), s2.substring(i, n)))
							)
					);
			if(flag)
				return true;
		}
		return flag;
	}

	
	public boolean isScrambledStringUsingDP(String s1, String s2) {
		if(s1.compareTo(s2)==0)
			return true;

		if(s1.length()<=1)
			return false;
		
		String tempKey = s1 + " " + s1;
		if(map.get(tempKey)!=null)
			return map.get(tempKey);
		
		
		int n = s1.length();
		boolean flag = false;

		for(int i=1; i<=n-1; i++) {
			flag = (
					(isScrambledString(s1.substring(0,i), s2.substring(n-i, n))
							&&
							(isScrambledString(s1.substring(i,n), s2.substring(0, n-i)))
							)
					||
					(isScrambledString(s1.substring(0,i), s2.substring(0, i))
							&&
							(isScrambledString(s1.substring(i,n), s2.substring(i, n)))
							)
					);
			if(flag) {
				map.put(tempKey, flag);
				return true;
			}
		}
		map.put(tempKey, flag);
		return flag;

	}

	public static void main(String[] args) {
		ScrambledString scrambledString = new ScrambledString();
		String s1 = "great";
		String s2 = "egeat";
		System.out.println(scrambledString.isScrambledString(s1, s2));
		System.out.println(scrambledString.isScrambledStringUsingDP(s1, s2));
	}

}
