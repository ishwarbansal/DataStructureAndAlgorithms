package com.leetcode.challenge.may2020.week1;

public class DayOne {

	public int firstBadVersion(int n) {
		if(isBadVersion(1))
			return 1;
		
		int start=1, end=n;
		
		while(start<end) {
			int mid = start + (end-start)/2;
			
			if(isBadVersion(mid)) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
	}

	public boolean isBadVersion(int n) {
		return n > 5;
	}
	
	public static void main(String[] args) {
		DayOne dayOne = new DayOne();
		System.out.println(dayOne.firstBadVersion(10));
	}

}
