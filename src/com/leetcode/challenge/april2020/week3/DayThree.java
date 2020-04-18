package com.leetcode.challenge.april2020.week3;

public class DayThree {

	public int numIslands(char[][] grid) {
		int h = grid.length;
		if (h == 0)
			return 0;
		int l = grid[0].length;
		int result = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < l; j++) {
				if (grid[i][j] == '1') {
					DFS(grid, i,  j);
					result++;
				}
			}
		}
		return result;
	}

	public void DFS(char[][] islandGrid, int row, int col) {
		System.out.println("Row "+row+ " Col "+ col);
		int H = islandGrid.length;
		int L = islandGrid[0].length;

		if (row < 0 || col < 0 || row >= H || col >= L || islandGrid[row][col] != '1')
			return;
		islandGrid[row][col] = '0'; //marking it visited
		System.out.println("Updated to zero");
		DFS(islandGrid, row+ 1, col); // go right
		DFS(islandGrid, row- 1, col); //go left
		DFS(islandGrid, row, col + 1); //go down
		DFS(islandGrid, row, col - 1); // go up
	}

	public static void main(String[] args) {

		char [][] islandGrid = new char[][] {
			{'1', '1', '1', '1', '0'},
			{'1', '1', '0', '1', '0'},
			{'1', '1', '0', '0', '0'},
			{'0', '0', '0', '0', '0'}};
			DayThree dayThree = new DayThree();
			System.out.println("No of Islands: " + dayThree.numIslands(islandGrid));

			islandGrid = new char[][] {
				{'1', '1', '0', '0', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '1', '0', '0'},
				{'0', '0', '0', '1', '1'}};
				System.out.println("No of Islands: " + dayThree.numIslands(islandGrid));
	}
}
