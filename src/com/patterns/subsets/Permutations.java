package com.patterns.subsets;

import java.util.ArrayList;
import java.util.Collections;
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

	public static String solve(String A) {
        long[] nums = new long[A.length()];
        int j = 0;
        for(char ch : A.toCharArray()){
            nums[j++] = Character.getNumericValue(ch);
        }
        
        List<List<Long>> premutationList = new ArrayList<>();
		Queue<List<Long>> result = new LinkedList<List<Long>>();
		result.add(new ArrayList<>());
		for (long currentNumber : nums) {
			int n = result.size();
			for (int i = 0; i < n; i++) {
				List<Long> oldPermutation = result.poll();
				for(int k=0; k<=oldPermutation.size(); k++) {
					List<Long> newPermutation = new ArrayList<Long>(oldPermutation);
					newPermutation.add(k, currentNumber);
					if(newPermutation.size()==nums.length)
						premutationList.add(newPermutation);
					else
						result.add(newPermutation);
				}
			}
		}


        List<Long> list = new ArrayList<Long>();
		for(List<Long> item : premutationList) {
			StringBuilder st = new StringBuilder();
			for(Long num : item) {
				st.append(num);
			}
			long l = Long.parseLong(st.toString());
			String s = l+"";
			if(s.length()==A.length())
				list.add(l);
		}
		
		Collections.sort(list);
		
		for(Long num : list){
		    if(num>Long.parseLong(A))
		        return num.toString();
		}
        return "-1";
    }

	public static void main(String[] args) {
//		List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 2, 3 });
//		System.out.print("Here are all the permutations: " + result);
		
		Permutations.solve("740948");
	}



}
