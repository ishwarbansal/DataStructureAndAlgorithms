package com.leetcode.challenge.april2020.week1;

import java.util.Arrays;

public class DayOne {

	public static int findUnique(int[] arr) {
		if(arr.length==1)
			return arr[0];

		Arrays.sort(arr); 

		int i=0;
		while(i<arr.length) {
			if(i<arr.length-1 && arr[i]==arr[i+1]) {
				i = i+2;
				continue;
			}
			return arr[i];
		}
		return -1;
	}

	public static int singleNumber(int[] nums) {
		int a = 0;
		for (int i : nums) {
			a ^= i;
		}
		return a;
	}

	public static void main(String[] args) {
		int [] arr1 = {4,1,2,1,2};
//		System.out.println(findUnique(arr1));
		System.out.println(singleNumber(arr1));

		int [] arr = {2,2,1,1,5,6,7,8,8,7,6};
//		System.out.println(findUnique(arr));
		System.out.println(singleNumber(arr));
	}



}
