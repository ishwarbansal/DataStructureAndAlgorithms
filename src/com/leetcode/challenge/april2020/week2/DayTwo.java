package com.leetcode.challenge.april2020.week2;

public class DayTwo {

	public boolean backspaceCompare(String S, String T) {
		String str1 = getBackspaceString(S);
		String str2 = getBackspaceString(T);
		return str1.equals(str2);
	}

	public String getBackspaceString(String str) {
		int backSpaceCnt = 0;
		StringBuilder st = new StringBuilder();
		
		for(int i=str.length()-1; i>=0; i--) {
			if(str.charAt(i)=='#')
				backSpaceCnt++;
			else
				if(backSpaceCnt==0)
					st.insert(0, str.charAt(i));
				else
					backSpaceCnt--;
		}
		return st.toString();
	}
	public static void main(String[] args) {
		DayTwo dayTwo = new DayTwo();
		System.out.println(dayTwo.backspaceCompare("ab#c", "ad#c"));
		System.out.println(dayTwo.backspaceCompare("ab##", "c#d#"));
		System.out.println(dayTwo.backspaceCompare("a##c", "#a#c"));
		System.out.println(dayTwo.backspaceCompare("a#c", "b"));
		System.out.println(dayTwo.backspaceCompare("j##xfix", "j###xfix"));
	}

}
