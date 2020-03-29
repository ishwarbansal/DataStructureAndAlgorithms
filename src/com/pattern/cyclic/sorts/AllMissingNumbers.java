package com.pattern.cyclic.sorts;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {

	public static List<Integer> findMissingNumbers(int[] nums) {
		List<Integer> missingNumbers = new ArrayList<>();

		int i = 0;
		while (i < nums.length) {
			int j = nums[i] - 1;
			if (nums[i] != nums[j])
				swap(nums, i, j);
			else
				i++;
		}

		for(int k=0; k<nums.length; k++) {
			if(k+1!=nums[k])
				missingNumbers.add(k+1);
		}

		return  missingNumbers;
	}

	public static List<Integer> findDuplicateNumbers(int[] nums) {
		List<Integer> dupNumbers = new ArrayList<>();

		int i = 0;
		while (i < nums.length) {
			int j = nums[i] - 1;
			if (nums[i] != nums[j])
				swap(nums, i, j);
			else
				i++;
		}

		for(int k=0; k<nums.length; k++) {
			if(k+1!=nums[k])
				dupNumbers.add(nums[k]);
		}

		return  dupNumbers;
	}

	public static List<Integer> findNumbersPC1(int[] nums) {
		List<Integer> missingNumbers = new ArrayList<>();

		int i = 0;
		while (i < nums.length) {
			int j = nums[i] - 1;
			if (nums[i] != nums[j])
				swap(nums, i, j);
			else
				i++;
		}

		for(int k=0; k<nums.length; k++) {
			if(k+1!=nums[k]) {
				missingNumbers.add(nums[k]);
				missingNumbers.add(k+1);
			}

		}

		return  missingNumbers;
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	
	public static int findNumbersPC2(int[] arr) {
		int i= 0 ;
		int[] nums = new int[arr.length-1];
		int p=0;
		for(int a: arr) {
			if(a<0)
				continue;
			nums[p++] = a;
		}
		while(i < nums.length) {
			int j = nums[i]-1;
			
			if(nums[i]!= i && j>=0 && nums[i]!=nums[j])
				swap(nums, i , j);
			else
				i++;
		}

		for(int k=0; k<nums.length; k++) {
			if( nums[k]>=0 && k!=nums[k]) {
				return k;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 3, 1, 8, 2, 3, 5, 1 };
		List<Integer> missingNumbers  = AllMissingNumbers.findMissingNumbers(arr);
		for (int num : missingNumbers)
			System.out.print(num + " ");
		System.out.println();

		int[] arr2 = new int[] { 5, 4, 7, 2, 3, 5, 3 };
		List<Integer> dupNumbers  = AllMissingNumbers.findDuplicateNumbers(arr2);
		for (int num : dupNumbers)
			System.out.print(num + " ");
		System.out.println();

		int[] arr3 = new int[] { 3, 1, 2, 5, 2 };
		List<Integer> numbersPC1  = AllMissingNumbers.findNumbersPC1(arr3);
		for (int num : numbersPC1)
			System.out.print(num + " ");
		System.out.println();
		
		int[] arr4 = new int[] {3, -2, 0, 1, 2 };
		System.out.println(AllMissingNumbers.findNumbersPC2(arr4));


	}


}
