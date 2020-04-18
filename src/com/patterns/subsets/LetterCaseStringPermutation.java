package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class LetterCaseStringPermutation {

	public static List<List<Character>> findPermutations(char[] nums) {
		List<List<Character>> permutationList = new ArrayList<>();
		List<Character> initialPermutation = new ArrayList<Character>();
		for(char c:nums)
			initialPermutation.add(c);

		initialPermutation = new ArrayList<Character>();

		for(char c:nums)
			initialPermutation.add(Character.toUpperCase(c));

		permutationList.add(initialPermutation);

		for (int i=0; i<nums.length; i++) {
			int index = i;
			while(index<nums.length) {
				List<Character> permutation = new ArrayList<Character>();
				for(int j=0; j<nums.length; j++) {
					if(j>=i && j<=index)
						permutation.add(Character.toUpperCase(nums[j]));
					else
						permutation.add(nums[j]);
				}
				permutationList.add(permutation);
				index++;
				if(index<nums.length && Character.isDigit(nums[index]))
					index++;
			}
		}
		return permutationList;
	}

	public static void main(String[] args) {
		List<List<Character>> result = findPermutations(new char[] { 'a', 'b', '7', 'c' });
		System.out.print("Here are all the permutations: " + result);
	}

}
