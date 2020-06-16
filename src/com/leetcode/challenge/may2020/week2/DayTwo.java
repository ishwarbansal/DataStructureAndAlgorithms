package com.leetcode.challenge.may2020.week2;

public class DayTwo {

	public boolean isPerfectSquare(int num) {
		
		if(num<=1)
			return true;
		
		if(num<4)
			return false;
		
		long start = 1;
		long end = num-1;
		
		while(start<end) {
			long mid = start + ((end-start)/2);
			System.out.println("mid "+ mid + " start " +start);
			if(mid*mid==num)
				return true;
			
			if(num < mid*mid) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		
		return (start*start==num);
	}

	public static void main(String[] args) {
		DayTwo dayTwo = new DayTwo();
		System.out.println(dayTwo.isPerfectSquare(808201));
	}
}
