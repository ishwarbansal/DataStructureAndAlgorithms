package com.data.structure.backtracking;

/*Given a N*N board with the Knight placed on the first block of an empty board. 
 * Moving according to the rules of chess knight must visit each square exactly once. 
 * Print the order of each the cell in which they are visited.*/

public class KnightTour {

	static int[] rowMove =  {-2,-2,-1,-1, 1, 1, 2, 2};
	static int[] colMove =  {-1, 1,-2, 2,-2, 2,-1, 1};
	static int moveCount = 1;
	
	public void checkKnightTour(int[][] chess, int row, int col) {
		int count = 1;
		int rowLen = chess.length;
		int colLen = chess[0].length;
		
		for(int i=row; i<chess.length; i++) {
			for(int j=col; j<chess[0].length; j++) {
				for(int k=0; k<rowMove.length; k++) {
					int newRow = i + rowMove[k];
					int newCol = j + colMove[k];
					if(isLegal(newRow, newCol, rowLen, colLen) && chess[newRow][newCol]==0) {
						count++;
						chess[newRow][newCol] = count;
						break;
					}
				}
			}
		}
	}

	private boolean isLegal(int r, int c, int rowLen, int colLen) {
		return r >= 0 && r < rowLen && c >= 0 && c < colLen;
	}
	
	public static void main(String[] args) {
		KnightTour obj = new KnightTour();
		int[][] chess = new int[8][8];
		chess[0][0] = 1;
		obj.checkKnightTour(chess, 0, 0);
	}

}
