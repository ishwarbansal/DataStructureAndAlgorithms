package com.leetcode.challenge.april2020.week4;

public class DayTwo {

	public int rangeBitwiseAnd(int m, int n) {
		while(n>m)
			n = n & n-1;
		return m&n;
	}

	public int rangeBitwiseAnd2(int m, int n) {
		int shift=0;
		while(m<n) {
			m >>= 1;
			n >>= 1;
			shift++;
		}
		return n << shift;
	}
	
	public static void main(String[] args) {
		DayTwo dayTwo = new DayTwo();
		System.out.println(dayTwo.rangeBitwiseAnd2(5,70000));
	}

}
