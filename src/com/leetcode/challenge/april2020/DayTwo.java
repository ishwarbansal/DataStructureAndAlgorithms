package com.leetcode.challenge.april2020;

public class DayTwo {

	public boolean isHappy(int n) {
		int slowPointer = n;
		int fastPointer = n;
		
		do{
			slowPointer = getSequareSum(slowPointer);
			fastPointer = getSequareSum(getSequareSum(fastPointer));
			System.out.println(slowPointer + "  <> " + fastPointer);
		}while(slowPointer != fastPointer);
		
		return slowPointer==1;
	}

	public int getSequareSum(int n) {
		int sum = 0;
		while (n > 9) {
			int remainder = n%10;
			n = n/10;
			sum = sum + (remainder*remainder);
		}
		sum = sum + (n*n);

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(new DayTwo().isHappy(12));
	}


}
