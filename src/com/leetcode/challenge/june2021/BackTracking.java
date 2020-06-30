package com.leetcode.challenge.june2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else { 
			for(int i = start; i < nums.length; i++){
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack2(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack2(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));
		else { 
			for(int i = start; i < nums.length; i++){
				if(i>start && nums[i]==nums[i-1])
					continue;
				tempList.add(nums[i]);
				backtrack2(list, tempList, nums, remain - nums[i], i+1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1); // not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
		}
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrackWithDup(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrackWithDup(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
		list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			if(i>start && nums[i]==nums[i-1])
				continue;
			tempList.add(nums[i]);
			backtrackWithDup(list, tempList, nums, i+1); // not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrackPermute(list, new ArrayList<>(), nums, -1, 0);
		return list;
	}

	private void backtrackPermute(List<List<Integer>> list, List<Integer> tempList, int [] nums, int prevIndex, int start){
		if(tempList.size()==nums.length)
			list.add(new ArrayList<>(tempList));
		for(int i = start; i < nums.length; i++){
			if(i==prevIndex || tempList.contains(nums[i]))
				continue;
			tempList.add(nums[i]);
			backtrackPermute(list, tempList, nums, i, 0); // not i + 1 because we can reuse same elements
			tempList.remove(tempList.size() - 1);
		}
	}
	
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		 List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrackPermuteUnique(list, new ArrayList<>(), nums, new boolean[nums.length]);
		    return list;
	}

	private void backtrackPermuteUnique(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
		if(tempList.size() == nums.length){
	        list.add(new ArrayList<>(tempList));
	    } else{
	        for(int i = 0; i < nums.length; i++){
	            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
	            used[i] = true; 
	            tempList.add(nums[i]);
	            backtrackPermuteUnique(list, tempList, nums, used);
	            used[i] = false; 
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}
	
	public static void main(String[] args) {
		BackTracking backTracking = new BackTracking();
		//		backTracking.combinationSum(new int[] {2,3,6,7}, 10);
		//		backTracking.subsets(new int[] {1,2,3});
		//		backTracking.subsetsWithDup(new int[] {1,2,2});
		//		backTracking.permute(new int[] {1,2,3});
		//		backTracking.permuteUnique(new int[] {1,1,2});
		backTracking.combinationSum2(new int[] {10,1,2,7,6,1,5}, 8);
	}
}
