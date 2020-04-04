package com.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {
	
	public static List<List<Integer>> findSubsets(int[] nums) {
	    List<List<Integer>> subsets = new ArrayList<>();
	    Arrays.sort(nums);
	    
	    subsets.add(new ArrayList<>());
	    
	    for (int startIndex=0; startIndex<nums.length; startIndex++) {
			// we will take all existing subsets and insert the current number in them to create new subsets
			int n = subsets.size();
			int i = 0;
			
			if(startIndex>0 && nums[startIndex]==nums[startIndex-1])
				i = n-1 ;
			
			while(i < n) {
				// create a new subset from the existing subset and insert the current element to it
				List<Integer> list = new ArrayList<>(subsets.get(i));
				list.add(nums[startIndex]);
				subsets.add(list);
				i++;
			}
		}
		return subsets;
	  }

	  public static void main(String[] args) {
	    List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3,3 });
	    System.out.println("Here is the list of subsets: " + result);

	    result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3, 3, 5});
	    System.out.println("Here is the list of subsets: " + result);
	  }


}
