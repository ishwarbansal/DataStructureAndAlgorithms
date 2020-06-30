package com.leetcode.challenge.june2021;

public class SurroundingRegion {

	public void solve(char[][] board) {
		
		if(board.length<=2 || board[0].length<=2){
			return;
		}
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(i==0 || j==0 || i==board.length-1 || j==board[i].length-1) {
					if(board[i][j]=='0') {
						DFS(board, i, j);
					}
				}
			}
		}

		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				if(board[i][j]=='O') {
					board[i][j] = 'X';
				}else if(board[i][j]=='A') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void DFS(char[][] board, int i, int j) {
		if(i>=0 && i<board.length && j>=0 && j<board[i].length && board[i][j]=='0') {
			board[i][j] = 'A';
			DFS(board, i+1, j);
			DFS(board, i-1, j);
			DFS(board, i, j+1);
			DFS(board, i, j-1);
		}
	}	

	public static void main(String[] args) {
		SurroundingRegion region = new SurroundingRegion();
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		region.solve(board);
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
		
	}

}
