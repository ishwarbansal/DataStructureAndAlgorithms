package com.data.structure.array;

import java.util.ArrayList;

public class PascalTriangle {

	//	Given numRows, generate the first numRows of Pascal’s triangle.
	//
	//	Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
	//
	//	Example:
	//
	//	Given numRows = 5,
	//
	//	Return
	//
	//	[
	//	      [1],
	//	     [1,1],
	//	    [1,2,1],
	//	   [1,3,3,1],
	//	  [1,4,6,4,1]
	//	]

	public ArrayList<ArrayList<Integer>> solve(int A) {
	
		int[][] matrix = new int[A][A];
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(A<=0)
			return result;
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		matrix[0][0] = 1;
		list.add(1);
		result.add(list);
		int row = 1;
	
		for(int i=1; i<matrix.length; i++) {
			list = new ArrayList<Integer>();
			for(int j=0; j<=row; j++) {
				if(j==0) {
					matrix[i][j] = 1;
					list.add(1);
				}else {
					int val = matrix[i-1][j] + matrix[i-1][j-1];
					matrix[i][j] = val;
					list.add(val);
				}
			}
			result.add(list);
			row++;
		}
		
		for(int a=0;a<matrix.length;a++) {
			for(int b=0;b<matrix[0].length;b++) {
				System.out.print(matrix[a][b]+" ");
			}
			System.out.println();
		}
		
		return result;    
	}
	
	public static void main(String[] args) {
		new PascalTriangle().solve(5);
	}
}
