package com.data.structure.array;

import java.util.ArrayList;

public class FirstMissingInteger {

	/*Given an unsorted integer array, find the first missing positive integer.
	Example:
	Given [1,2,0] return 3,
	[3,4,-1,1] return 2,
	[-8, -7, -6] returns 1
	Your algorithm should run in O(n) time and use constant space.*/
	
	public int firstMissingPositive(ArrayList<Integer> A) {

		if(A.size()==0 || !A.contains(1))
			return 1;

		int n = A.size();

		if(n==1)
			return 2;

		for(int i=0; i<n; i++){
			if(A.get(i)<=0 || A.get(i) > n)
				A.set(i, 1);
		}

		for(int i=0; i<n; i++){
			int indexVal = Math.abs(A.get(i))-1;
			if(A.get(indexVal)>0){
				A.set(indexVal, -1 * A.get(indexVal));
			}
		}


		for(int i=0; i<n; i++){
			if(A.get(i)>0){
				return i+1;
			}
		}

		return n+1;
	}

}
