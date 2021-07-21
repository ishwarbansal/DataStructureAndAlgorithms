package com.data.structure.array;

public class SpiralOrderMatrixII {

//	Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//	Input: n = 3
//	Output: [[1,2,3],[8,9,4],[7,6,5]]
	
//	Example 2:
//	Input: n = 1
//	Output: [[1]]
			
	public int[][] generateMatrix(int A) {
		int[][] matrix=new int[A][A];
		int n=1;
		int top=0,left=0,bottom=A-1,right=A-1;
		while(n<=A*A) {
			for(int i=left;i<=right;i++) matrix[top][i]=n++;
			top++;
			for(int i=top;i<=bottom;i++) matrix[i][right]=n++;
			right--;
			for(int i=right;i>=left;i--) matrix[bottom][i]=n++;
			bottom--;
			for(int i=bottom;i>=top;i--) matrix[i][left]=n++;
			left++;             
		}

		for(int a=0;a<matrix.length;a++) {
			for(int b=0;b<matrix[0].length;b++) {
				System.out.print(matrix[a][b]+" ");
			}
			System.out.println();
		}
		return matrix;
	}
	public static void main(String[] args) {
		SpiralOrderMatrixII obj=new SpiralOrderMatrixII();
		obj.generateMatrix(4);
	}

}