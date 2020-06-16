package com.leetcode.challenge.may2020.week2;

public class DayFourth {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc]!=newColor) 
			fillNewColor(image, sr, sc, newColor, image[sr][sc]);
		return image;
	}

	private void fillNewColor(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if(sr<0 || sr>=image.length || sc<0 || sc>=image[sr].length || image[sr][sc]!=oldColor) 
			return;

		image[sr][sc] = newColor;
		fillNewColor(image, sr, sc-1, newColor, oldColor);
		fillNewColor(image, sr, sc+1, newColor, oldColor);
		fillNewColor(image, sr-1, sc, newColor, oldColor);
		fillNewColor(image, sr+1, sc, newColor, oldColor);
	}

	public static void main(String[] args) {
		DayFourth dayFourth = new DayFourth();
		//		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int[][] image = {{0,0,0},{0,0,0}};
		int[][] floodFill = dayFourth.floodFill(image, 0, 0, 2);

		for(int i=0; i<floodFill.length; i++) {
			for(int j=0; j<floodFill[i].length; j++) {
				System.out.print(floodFill[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
