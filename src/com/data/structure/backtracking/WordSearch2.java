package com.data.structure.backtracking;

import java.util.ArrayList;
import java.util.List;

/*212. Word Search II
Hard

Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]

Example 2:
Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */
public class WordSearch2 {

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
				if(checkDictionary(board, word, newRow, newCol, index+1)) {
					board[newRow][newCol] = temp;
					return true;
				}
				board[newRow][newCol] = temp;
			}

		}
		return false;
	}
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();

		for(int k=0; k<words.length; k++) {
			String word = words[k];
			boolean wordFound = false;
			for (int row = 0; row < board.length; row++)
			{
				for (int col = 0; col < board[0].length; col++)
				{
					if(board[row][col]==word.charAt(0)) {
						char temp = board[row][col];
						board[row][col]=' ';
						if(checkDictionary(board, word, row, col, 1)) {
							result.add(word);
							board[row][col]=temp;
							wordFound = true;
							break;
						}
						board[row][col]=temp;
					}
				}
				if(wordFound)
					break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		WordSearch2 obj = new WordSearch2();
		char[][] board = new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		
		List<String> result = obj.findWords(board, words);
		for(String str: result) {
			System.out.println(str);
		}
	}
}
