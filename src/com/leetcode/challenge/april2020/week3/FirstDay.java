package com.leetcode.challenge.april2020.week3;

public class FirstDay {

	public int[] productExceptSelf(int[] nums) {
		if (nums.length==1)
			return nums;

		getProduct(1, nums[0], nums, 0);
		return nums;
	}
	
	public int getProduct(int product, int currentElement, int[] nums, int index) {
		if(nums.length-1 == index) {
			nums[index] = product;
			return currentElement;
		}

		int nextIndex = index+1;
		int element = getProduct(product * nums[index], nums[nextIndex], nums, nextIndex);
		
		int returnValue = nums[index] * element;
		nums[index] = product * element; 

		return returnValue;
	}

	public static void main(String[] args) {
		FirstDay firstDay = new FirstDay();
		int[] arr = firstDay.productExceptSelf(new int[] {5,2,3,4,1});
		
		for(int val : arr) {
			System.out.println(val);
		}
	}
}
