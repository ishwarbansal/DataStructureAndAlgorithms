package com.data.structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

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
		PermutationsII obj = new PermutationsII();
		List<List<Integer>> result = obj.permuteUnique(new int[] {1,1,1,2});
		for(List<Integer> list : result) {
			for(Integer val : list) {
				System.out.print(val + "    ");
			}
			System.out.println("");
		}
	}

}
