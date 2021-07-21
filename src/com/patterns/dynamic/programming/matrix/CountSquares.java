package com.patterns.dynamic.programming.matrix;

public class CountSquares {

	/*	1277. Count Square Submatrices with All Ones
	Medium

	Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

	Example 1:

	Input: matrix =
	[
	  [0,1,1,1],
	  [1,1,1,1],
	  [0,1,1,1]
	]
	Output: 15
	Explanation: 
	There are 10 squares of side 1.
	There are 4 squares of side 2.
	There is  1 square of side 3.
	Total number of squares = 10 + 4 + 1 = 15.
	Example 2:

	Input: matrix = 
	[
	  [1,0,1],
	  [1,1,0],
	  [1,1,0]
	]
	Output: 7
	Explanation: 
	There are 6 squares of side 1.  
	There is 1 square of side 2. 
	Total number of squares = 6 + 1 = 7.


	Constraints:

	1 <= arr.length <= 300
	1 <= arr[0].length <= 300
	0 <= arr[i][j] <= 1
	 */

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
		CountSquares countSquares = new CountSquares();
		
//		int [][] matrix1 = new int[][]{{0,1,1,1}};
//		System.out.println(countSquares.countSquares(matrix1));
		
		int [][] matrix2 = new int[][]{{0,1,1,1},{0,1,0,0}};
		System.out.println(countSquares.countSquares(matrix2));
		
//		int [][] matrix3 = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
//		System.out.println(countSquares.countSquares(matrix3));
	}
}
