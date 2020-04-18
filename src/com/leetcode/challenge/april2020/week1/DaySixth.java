package com.leetcode.challenge.april2020.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DaySixth {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groupAnagrams = new ArrayList<List<String>>();
		List<String> values = new ArrayList<String>();

		for(String st:strs) {
			values.add(st);
		}
		
		for(int i=0; i<values.size(); i++) {
			List<String> groupAnagram = new ArrayList<String>();
			groupAnagram.add(values.get(i));
			for(int j=i+1; j<values.size(); j++) {
				if(sameAnagram(values.get(i), values.get(j))) {
					groupAnagram.add(values.get(j));
					values.remove(j);
					j--;
				}
			}
			groupAnagrams.add(groupAnagram);
		}
		return groupAnagrams;
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		
		if(strs.length==0)
			return new ArrayList<List<String>>();
		
		Map<String, List<String>> groups = new HashMap<String, List<String>>();
		
		for(String str : strs) {
			String orderString = orderedString(str);
			if(groups.get(orderString)==null)
				groups.put(orderString, new ArrayList<String>());
			
			groups.get(orderString).add(str);
		}
		Collection<List<String>> lists = groups.values();
		List<List<String>> anagramGroups = new ArrayList<>();
		anagramGroups.addAll(lists);
		return anagramGroups;
	}
	public boolean sameAnagram(String str1, String str2) {
		
		if(str1.length()!=str2.length())
			return false;
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		for(int i=0; i<ch1.length; i++) {
			if(ch1[i]!=ch2[i])
				return false;
		}
		
		return true;
	}
	
	public String orderedString(String str) {
		char[] ch = str.toCharArray();
		Arrays.sort(ch);
		return String.valueOf(ch);
	}


	public static void main(String[] args) {
		List<List<String>> lists = new DaySixth().groupAnagrams2(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		for(List<String> list : lists) {
			for(String st:list) {
				System.out.print(st + "  ");
			}
			System.out.println("");
		}
	}
}
