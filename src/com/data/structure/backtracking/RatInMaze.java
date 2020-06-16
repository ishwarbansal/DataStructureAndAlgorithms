package com.data.structure.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {

	static int[] rowMove =  {0, -1, 0, 1};
	static int[] colMove =  {-1, 0, 1, 0};

	public void checkRateInMaze(int[][] dictionary, boolean[][] visited, int row, int col, List<int[]> result) {
//		System.out.println("row "+ row + " col " +col +" length "+rowMove.length);
		if(row==rowMove.length-1 && col==colMove.length-1) {
			System.out.println("reached");
			printMatrix(visited);
			return;
		}

		for(int i=0; i<rowMove.length; i++) {
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];

			if(newRow >=0 && newCol>=0 && newRow<dictionary.length && newCol<dictionary[newRow].length && !visited[newRow][newCol] && dictionary[newRow][newCol]==1) {
				visited[newRow][newCol] = true;
				checkRateInMaze(dictionary, visited, newRow, newCol, result);
				visited[newRow][newCol] = false;
			}
		}


	}
	
	public void printMatrix(boolean[][] visited) {
		for (int row = 0; row < visited.length; row++)
        {
            for (int col = 0; col < visited[row].length; col++)
            {
            	if(visited[row][col])
            		System.out.println(row + "  " + col);
            }
        }
		
	}

	public static void main(String[] args) {
		RatInMaze ratInMaze = new RatInMaze();
		int[][] dictionary = {{1,1,0,1},{0,1,1,1},{0,1,0,1},{0,1,1,1}};
		boolean[][] visited = new boolean[4][4];
		visited[0][0] = true;
		List<int[]> result = new ArrayList<int[]>();
		result.add(new int[]{0,0});
		ratInMaze.checkRateInMaze(dictionary, visited, 0, 0, result);
	}
}
