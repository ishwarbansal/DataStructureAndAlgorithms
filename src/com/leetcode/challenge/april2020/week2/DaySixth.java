package com.leetcode.challenge.april2020.week2;

public class DaySixth {

	public String stringShift(String s, int[][] shift) {

		if(shift.length == 0)
			return s;

		int sum = 0;

		for(int[] arr : shift) {
			if(arr[0]==1)
				sum = sum + arr[1];
			else
				sum = sum - arr[1];
		}

		System.out.println(sum);
		
		if (sum == 0)
			return s;

		if(sum < 0) {
			for(int i = sum ; i< 0; i++) {
				System.out.println("Beofre " +s);
				s = s.substring(1, s.length()) + s.charAt(0);
				System.out.println("After " +s);
			}
		}else {
			for(int i = 0 ; i< sum; i++) {
				s= s.charAt(s.length()-1) + s.substring(0,s.length()-1);
			}
		}

		return s;
	}

	public static void main(String[] args) {
		DaySixth daySixth = new DaySixth();
		//				int[] arrLeft = new int[] {0,1};
		//				int[] arrRight = new int[] {1,2};

		int[] arrLeft = new int[] {0,7};
		int[] arrRight = new int[] {1,7};
		int[] arrRight2 = new int[] {1,0};
		int[] arrRight3 = new int[] {1,3};
		int[] arrLeft2 = new int[] {0,3};
		int[] arrLeft3 = new int[] {0,6};
		int[] arrRight4 = new int[] {1,2};
		
		int[][] arr = new int[][] {arrLeft, arrRight, arrRight2, arrRight3, arrLeft2, arrLeft3, arrRight4};

		System.out.println(daySixth.stringShift("wpdhhcj", arr));
	}

}
