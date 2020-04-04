package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> premutationList = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int startIndex=0; startIndex<nums.length; startIndex++) {
			// we will take all existing subsets and insert the current number in them to create new subsets
			int n = result.size();
			for (int i = 0; i < n; i++) {
				// create a new subset from the existing subset and insert the current element to it
				List<Integer> list = new ArrayList<>(result.get(i));
				list.add(nums[startIndex]);
				result.add(list);
				if(list.size()==nums.length)
					premutationList.add(list);
			}
		}
		
		return premutationList;
	}
	
	

	public static void main(String[] args) {
		List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
		System.out.print("Here are all the permutations: " + result);
	}



}
