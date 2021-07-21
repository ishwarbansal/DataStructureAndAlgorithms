package com.data.structure.array;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousArray {

	
//	Find the contiguous subarray within an array, A of length N which has the largest sum.
//	Input Format:
//	The first and the only argument contains an integer array, A.
//
//	Output Format:
//	Return an integer representing the maximum possible sum of the contiguous subarray.
//	
//	Input 1:
//	    A = [1, 2, 3, 4, -10]
//
//	Output 1:
//	    10
	
	public int maxSubArray(final List<Integer> A) {

		int meh = 0; 
		int msf = Integer.MIN_VALUE;

		for(int i : A){
			meh = meh + i;

			if(meh<i){
				meh = i;
			}

			if(msf<meh){
				msf = meh;
			}
		}
		return msf;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(-10);
		System.out.println(new MaxSumContiguousArray().maxSubArray(list));
	}
}
