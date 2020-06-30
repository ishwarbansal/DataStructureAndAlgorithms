package com.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

	public static List<List<Integer>> findPermutations(int[] nums) {
		List<List<Integer>> premutationList = new ArrayList<>();
		Queue<List<Integer>> result = new LinkedList<List<Integer>>();
		result.add(new ArrayList<>());
		for (int currentNumber : nums) {
			int n = result.size();
			for (int i = 0; i < n; i++) {
				List<Integer> oldPermutation = result.poll();
				for(int k=0; k<=oldPermutation.size(); k++) {
					List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
					newPermutation.add(k, currentNumber);
					if(newPermutation.size()==nums.length)
						premutationList.add(newPermutation);
					else
						result.add(newPermutation);
				}
			}
		}
		return premutationList;
	}



	public static void main(String[] args) {
		List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 2, 3 });
		System.out.print("Here are all the permutations: " + result);
	}



}
