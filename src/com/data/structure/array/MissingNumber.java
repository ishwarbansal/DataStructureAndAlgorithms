package com.data.structure.array;

public class MissingNumber {

	public static int findMissingNumber(int[] nums) {
		int i= 0 ;
		int missingNo = -1;
		while(i < nums.length) {
			int j = nums[i];
			
			if(j==nums.length) {
				missingNo = i; 
				i++;
				continue;
			}
			
			if(nums[i]!= i)
				swap(nums, i , j);
			else
				i++;
		}

		return missingNo;
	}


	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 7, 3, 2, 4, 6, 0, 1 };
		System.out.println(MissingNumber.findMissingNumber(nums));
	}
}
