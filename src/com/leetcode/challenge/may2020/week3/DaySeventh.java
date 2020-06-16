package com.leetcode.challenge.may2020.week3;

public class DaySeventh {

	public int countSquares(int[][] matrix) {
		int squareCnt = 0;
		for(int row = 0; row<matrix.length; row++) {
			for(int col = 0; col<matrix[row].length; col++) {
				if(row ==0 || col== 0) {
					squareCnt+= matrix[row][col];
				}else if(matrix[row][col]!=0){
					matrix[row][col] = Math.min(Math.min(matrix[row-1][col], matrix[row][col-1]), matrix[row-1][col-1])+1;
					squareCnt+= matrix[row][col];
				}
			}
		}
		return squareCnt;
	}

	public static void main(String[] args) {
		DaySeventh daySeventh = new DaySeventh();

		int[][] matrix = {{0,1,1,1},{1,1,0,1},{1,1,1,1},{1,0,1,0}};

		System.out.println(daySeventh.countSquares(matrix));
	}

}
