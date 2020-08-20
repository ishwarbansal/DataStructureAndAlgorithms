package com.data.structure.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubArrayProduct {


	public static List<List<Integer>> findSubarrays(int[] arr, int target) {
		int count = 0;
		
		List<List<Integer>> result = new ArrayList<>();
		int product = 1, left = 0;
		for (int right = 0; right < arr.length; right++) {
			product *= arr[right];
			while (product >= target && left < arr.length)
				product /= arr[left++];
			// since the product of all numbers from left to right is less than the target therefore,
			// all subarrays from lef to right will have a product less than the target too; to avoid
			// duplicates, we will start with a subarray containing only arr[right] and then extend it
			List<Integer> tempList = new LinkedList<>();
			for (int i = right; i >= left; i--) {
				tempList.add(0, arr[i]);
				result.add(new ArrayList<>(tempList));
			}
			count+=(right-left+1);
		}
		System.out.println(count);
		return result;
	}



	public static void main(String[] args) {
		findSubarrays(new int[] {10,5,2,6}, 100);
	}
}


