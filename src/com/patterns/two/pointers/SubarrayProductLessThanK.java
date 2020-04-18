package com.patterns.two.pointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubarrayProductLessThanK {

	public static void findSubarrays(int[] arr, int target) {
		int index = 0;
		while(index < arr.length) {
			int product = 1;
			int j = index;
			while(j<arr.length && product < target) {
				product = product * arr[j];
				if(product<target) {
					for(int k=index; k<=j; k++)
						System.out.print(arr[k] + " ");
					System.out.println("");
				}
				j++;
			}
			index++;
		}
	}


	public static void main(String[] args) {
		int arr[] = {2, 5, 3, 10};
		findSubarrays(arr, 30);
		System.out.println("************");
		SubarrayProductLessThanK.findSubarraysDocs(new int[] { 2, 5, 3, 10 }, 30);

	}

	public static List<List<Integer>> findSubarraysDocs(int[] arr, int target) {
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
				print(tempList);
			}
		}
		return result;
	}

	public static void print(List<Integer> result) {
		for(Integer in : result) 
			System.out.print(in + " ");
			System.out.println("");
	}


}
