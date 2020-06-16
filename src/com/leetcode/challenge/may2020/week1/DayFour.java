package com.leetcode.challenge.may2020.week1;

public class DayFour {

	public int findComplement(int num) {
		if (num==0)
			return 1;
		
		int bitLength = (int)(Math.log(num)/Math.log(2)) + 1;
		return (1<<(bitLength))-1 ^ num;
		
	}
	
	public static void main(String[] args) {
		System.out.println(new DayFour().findComplement(5));
	}

}
