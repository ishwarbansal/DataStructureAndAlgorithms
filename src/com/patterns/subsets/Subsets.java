package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> findSubsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		// start by adding the empty subset
		subsets.add(new ArrayList<>());
		for (int currentNumber : nums) {
			// we will take all existing subsets and insert the current number in them to create new subsets
			int n = subsets.size();
			for (int i = 0; i < n; i++) {
				// create a new subset from the existing subset and insert the current element to it
				List<Integer> list = new ArrayList<>(subsets.get(i));
				list.add(currentNumber);
				subsets.add(list);
			}
		}
		return subsets;
	}

	public static void main(String[] args) {
		List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
		System.out.println("Here is the list of subsets: " + result);

		result = Subsets.findSubsets(new int[] { 1, 5, 3 });
		System.out.println("Here is the list of subsets: " + result);
	}

}
