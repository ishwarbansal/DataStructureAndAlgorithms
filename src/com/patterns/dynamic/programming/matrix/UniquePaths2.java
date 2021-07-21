package com.patterns.dynamic.programming.matrix;


/*63. Unique Paths II
Medium
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space is marked as 1 and 0 respectively in the grid.

Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1

Constraints:
m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		int[][] dp = new int[m][n];
		
		for(int i=0; i<n; i++) {
			if(obstacleGrid[0][i]==0)
				dp[0][i]=1;
			else
				break;
		}
		
		for(int j=0; j<m; j++) {
			if(obstacleGrid[j][0]==0)
				dp[j][0]=1;
			else
				break;
		}

		for(int i=1; i<m; i++) {
			for(int j=1; j<n; j++) {
				int way = 0;
				if(obstacleGrid[i][j-1]==0)
					way+= dp[i][j-1];
				if(obstacleGrid[i-1][j]==0)
					way+= dp[i-1][j];
				
				dp[i][j]= way;
			}
		}

		return dp[m-1][n-1];
	}

	public static void main(String[] args) {
		UniquePaths2 obj = new UniquePaths2();
		int [][] matrix = new int[][] {{0,0,0},{0,1,0},{0,0,0}};
		System.out.println(obj.uniquePathsWithObstacles(matrix));
	}
}
