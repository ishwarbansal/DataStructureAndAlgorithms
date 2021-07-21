package com.data.structure.backtracking;

import java.util.ArrayList;
import java.util.List;

/*A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] 
		and destination block is lower rightmost block i.e., maze[N-1][N-1]. 
A rat starts from source and has to reach the destination. The rat can move only in two directions: forward and down. 

In the maze matrix, 0 means the block is a dead end and 1 means the block can be used in the path from source to destination.
 */
public class RatInMaze {

	static int[] rowMove =  {0, 1};
	static int[] colMove =  {1, 0};

	public void checkRateInMaze(int[][] maze, int row, int col, List<int[]> result) {
		if(row==maze.length-1 && col==maze.length-1) {
			return;
		}

		for(int i=0; i<rowMove.length; i++) {
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];

			if(newRow >=0 && newCol>=0 && newRow<maze.length && newCol<maze[newRow].length 
					&& maze[newRow][newCol]==1) {
				result.add(new int[]{newRow, newCol});
				int temp = maze[newRow][newCol] ;
				maze[newRow][newCol] = -1;
				checkRateInMaze(maze, newRow, newCol, result);
				maze[newRow][newCol] = temp;
				result.remove(result.size()-1);
			}
		}


	}


	public static void main(String[] args) {
		RatInMaze ratInMaze = new RatInMaze();
		int[][] maze = {{1,1,0,1},{0,1,1,1},{0,1,0,1},{0,1,1,1}};

		List<int[]> result = new ArrayList<int[]>();
		result.add(new int[]{0,0});
		maze[0][0] = -1;
		ratInMaze.checkRateInMaze(maze, 0, 0, result);
	}
}
