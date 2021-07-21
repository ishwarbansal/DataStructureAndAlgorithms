package com.data.structure.array;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {

	/*	Given an array of integers, sort the array into a wave like array and return it,
			In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

			Example

			Given [1, 2, 3, 4]

			One possible answer : [2, 1, 4, 3]
			Another possible answer : [4, 1, 3, 2]
			 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
			So, in example case, you will return [2, 1, 4, 3]*/


	public ArrayList<Integer> wave(ArrayList<Integer> A) {
	
		Collections.sort(A);
	
		int n = A.size();
	
		for(int i=0; i<n-1; i=i+2){
			int temp = A.get(i);
			A.set(i, A.get(i+1));
			A.set(i+1, temp);
		}
	
		return A;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		ArrayList<Integer> result = new WaveArray().wave(list);
		
		for(int val : result) {
			System.out.println(val);
		}
	}
}
