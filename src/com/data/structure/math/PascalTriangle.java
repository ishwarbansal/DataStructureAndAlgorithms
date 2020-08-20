package com.data.structure.math;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<Integer> getRow(int rowIndex) {
		int[][] matrix = new int[rowIndex+1][rowIndex+1];
		List<Integer> list = new ArrayList<Integer>();

		matrix[0][0] = 1;
		if(rowIndex == 0) {
			list.add(1);
		}

		for(int i=1; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				if(j==0) {
					matrix[i][j] = 1;
				}else if (matrix[i][j-1]>0) {
					matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
				}else {
					break;
				}
				if(i==rowIndex) {
					list.add(matrix[i][j]);
				}
			}
		}
		return list;		
	}
	
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new  PascalTriangle();
		List<Integer> list = pascalTriangle.getRow(5);
		
		for(int val : list) {
			System.out.println(val + " ");
		}
	}

}
