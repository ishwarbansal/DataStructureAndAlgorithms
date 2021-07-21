package com.data.structure.backtracking;

/*79. Word Search
Medium
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
Note: There will be some test cases with a board or a word larger than constraints to test if your solution is using pruning.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */
public class WordSearch {

	static int[] rowMove =  { 0, -1, 0, 1};
	static int[] colMove =  {-1,  0, 1, 0};

	public boolean checkDictionary(char[][] board, String word, int row, int col, int index) {
		if(index == word.length())
			return true;

		for(int i=0; i<rowMove.length; i++) {
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];

			if(newRow >=0 && newCol>=0 && newRow<board.length && newCol<board[newRow].length 
					&& board[newRow][newCol]==word.charAt(index) ) {
				char temp = board[newRow][newCol];
				board[newRow][newCol]=' ';
				if(checkDictionary(board, word, newRow, newCol, index+1))
					return true;
				board[newRow][newCol] = temp;
			}

		}
		return false;
	}
	public boolean exist(char[][] board, String word) {
		for (int row = 0; row < board.length; row++)
		{
			for (int col = 0; col < board[0].length; col++)
			{
				if(board[row][col]==word.charAt(0)) {
					char temp = board[row][col];
					board[row][col]=' ';
					if(checkDictionary(board, word, row, col, 1)) {
						return true;
					}
					board[row][col]=temp;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		WordSearch obj = new WordSearch();
		char[][] board = {{'A','B','C','E' },
				{'S','F','C', 'S' },
				{'A','D','E', 'E' }};

		String word = "ABCCED";
		System.out.println(obj.exist(board, word));
	}
}
