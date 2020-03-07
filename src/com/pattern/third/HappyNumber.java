package com.pattern.third;

public class HappyNumber {

	public static boolean find(int num) {
		int slow=num, fast=num;
		do {
			slow = getSum(0, slow);
			fast = getSum(0,getSum(0, fast));
			System.err.println(slow+ " "+fast);
		}while(slow!=fast);
		return slow==1;		
	}


	private static int getSum(int sum, int num) {
		if(num < 10) {
			return sum + (num * num) ;
		}else {
			int divider = num / 10;
			int remainder = num % 10;
			return sum + getSum(remainder*remainder, divider);
		}
	}


	public static void main(String[] args) {
		System.out.println(find(23));
	}
}
