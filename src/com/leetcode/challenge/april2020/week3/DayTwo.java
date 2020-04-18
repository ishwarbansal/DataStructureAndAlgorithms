package com.leetcode.challenge.april2020.week3;

public class DayTwo {

	public boolean checkValidString(String s) {

		int lo = 0, hi = 0;
		for (char c: s.toCharArray()) {
			lo += c == '(' ? 1 : -1;
			hi += c != ')' ? 1 : -1;
			if (hi < 0) break;
			lo = Math.max(lo, 0);
		}
		return lo == 0;

	}

	public static void main(String[] args) {
		DayTwo dayTwo = new DayTwo();
		System.out.println(dayTwo.checkValidString("(***)()"));
		System.out.println(dayTwo.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
		System.out.println(dayTwo.checkValidString("*)(*"));
	}
}
