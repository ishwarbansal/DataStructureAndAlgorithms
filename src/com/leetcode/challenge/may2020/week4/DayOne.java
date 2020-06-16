package com.leetcode.challenge.may2020.week4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DayOne {

	public String frequencySort(String s) {

		int[] charArr = new int[58];

		for(char ch:s.toCharArray()) {
			charArr[ch - 'A']++;
		}


		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<charArr.length; i++) {
			if(charArr[i]>0) {
				char c = (char) (i + 'A');
				list.add(charArr[i]+""+c);
			}
		}
		StringBuilder st = new StringBuilder();
		Collections.sort(list, Collections.reverseOrder());
		for(String str : list) {
			int elementCount = Integer.parseInt(str.substring(0,str.length()-1));
			for(int i=0; i<elementCount; i++) {
				st.append(str.substring(str.length()-1));
			}
			
		}
		
		return st.toString();
	}

	
	public static void main(String[] args) {
		DayOne dayOne = new DayOne();
		System.out.println(dayOne.frequencySort("treeaaaAAddDDDDDzzZZZZZ"));
	}
}
