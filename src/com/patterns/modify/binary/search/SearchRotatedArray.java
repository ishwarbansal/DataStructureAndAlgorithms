package com.patterns.modify.binary.search;

public class SearchRotatedArray {

	public static int search(int[] nums, int target) {

		int start=0; int end=nums.length-1;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			
			if(nums[mid]==target)
				return mid;
			
			if(nums[start]<= nums[mid]) {
				//Ascending order
				if(target >= nums[start] && target<nums[mid]) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}else {
				//Desending order
				if(target > nums[mid] && target <= nums[end]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
		System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
		System.out.println(SearchRotatedArray.search(new int[] { 4,5,6,7,0,1,2 }, 0));
		System.out.println(SearchRotatedArray.search(new int[] { 4,5,6,7,0,1,2 },3));
	}


}
