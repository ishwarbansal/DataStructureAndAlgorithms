package com.patterns.dynamic.programming.matrix;

public class MinPathSum {

	public int minPathSum(int[][] grid) {
		int height = grid.length;
		int width = grid[0].length;
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if(row == 0 && col == 0) 
					grid[row][col] = grid[row][col];
				else if(row == 0 && col != 0) 
					grid[row][col] = grid[row][col] + grid[row][col - 1];
				else if(col == 0 && row != 0) 
					grid[row][col] = grid[row][col] + grid[row - 1][col];
				else grid[row][col] = 
						grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
			}
		}
		return grid[height - 1][width - 1]; 
	}
	public static void main(String[] args) {
		MinPathSum obj = new MinPathSum();
		int[][] matrix = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
		System.out.println(obj.minPathSum(matrix));
	}

}
