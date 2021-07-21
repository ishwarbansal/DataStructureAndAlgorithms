package com.patterns.dynamic.programming.matrix;

/*174. Dungeon Game
Hard

The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
Return the knight's minimum initial health so that he can rescue the princess.
Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

Example 1:
Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
*/
public class DungeonGame {

	public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
		int col = dungeon[row-1].length;
		
		int[][] matrix = new int[row][col];
		
		matrix[row-1][col-1] = dungeon [row-1][col-1] > 0 ? 1 :  1 - dungeon[row-1][col-1];
		
		for(int i=row-2; i>=0; i--) {
			matrix[i][col-1] = Math.max(matrix [i+1][col-1] - dungeon[i][col-1],1); 
		}
		
		for(int j=col-2; j>=0; j--) {
			matrix[row-1][j] = Math.max(matrix [row-1][j+1] - dungeon[row-1][j],1); 
		}
		
		for(int i=row-2; i>=0; i--) {
			for(int j=col-2; j>=0; j--) {
				matrix[i][j] = Math.max(Math.min(matrix[i+1][j],matrix[i][j+1]) - dungeon[i][j],1);
			}
		}
		return matrix[0][0];
    }
	
	public static void main(String[] args) {
		DungeonGame obj = new DungeonGame();
		int [][] matrix = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		System.out.println(obj.calculateMinimumHP(matrix));
	}

}
