package com.data.structure.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateInArray {

	/*	Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.

	Sample Input:

	[3 4 1 4 1]
	Sample Output:

	1
	If there are multiple possible answers ( like in the sample case above ), output any one.

	If there is no duplicate, output -1
	 */

	public int repeatedNumber(final List<Integer> A) {
	
		List<Integer> list = new ArrayList<Integer>();
	
		for(int i=0; i<A.size(); i++){
			if(list.get(A.get(i)-1)>0)
				return A.get(i);
			else
				list.add(i-1, A.get(i));
		}
		return -1;
	}
	
	public int repeatedNumber(final int[] a) {
	    int n=a.length;
	    for(int i=0;i<n;i++)
	    {
	        int temp=Math.abs(a[i]);
	        int temp2=a[temp];
	        if(temp2<0)//if this happens it will mean that a[temp] is already visited
	        return temp;//which means that temp is already present in the array
	            else
	            a[temp]=-a[temp];
	        }
	        return -1;
	 }

}
