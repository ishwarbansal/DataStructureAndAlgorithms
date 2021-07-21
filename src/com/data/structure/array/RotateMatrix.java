package com.data.structure.array;

import java.util.ArrayList;

public class RotateMatrix {

	//	You are given an n x n 2D matrix representing an image.
	//
	//	Rotate the image by 90 degrees (clockwise).
	//
	//	You need to do this in place.
	//
	//	Note that if you end up using an additional array, you will only receive partial score.
	//
	//	Example:
	//
	//	If the array is
	//
	//	[
	//	    [1, 2],
	//	    [3, 4]
	//	]
	//	Then the rotated array becomes:
	//
	//	[
	//	    [3, 1],
	//	    [4, 2]
	//	]

	public void rotate(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();

		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				int temp = a.get(i).get(j);
				a.get(i).set(j,a.get(j).get(i));
				a.get(j).set(i, temp);
			}
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<n/2; j++){
				int temp = a.get(i).get(n-1-j);
				a.get(i).set(n-1-j,a.get(i).get(j));
				a.get(i).set(j, temp);
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);
		list2.add(2);

		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		input.add(list);
		input.add(list2);
		
		new RotateMatrix().rotate(input);
	}

}
