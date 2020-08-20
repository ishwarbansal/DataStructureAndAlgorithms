package com.data.structure.math;

public class HIndex {

	//Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher, 
	//write a function to compute the researcher's h-index.
	public int hIndex(int[] citations) {
		int n = citations.length;
		int start = 0;
		int end = citations.length-1;
		int mid = 0;

		while(start<=end) {
			mid = start + (end-start)/2;
			if(citations[mid] < n - mid) {
				start = mid + 1;
			}else {
				end = mid -1;
			}
		}
		return n - start;
	}

	public static void main(String[] args) {
		System.out.println(new HIndex().hIndex(new int[] {0,1,3,5,6}));
	}
}
