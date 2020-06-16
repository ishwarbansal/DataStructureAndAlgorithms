package com.data.structure.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Boggle {

	static int[] rowMove =  {0,  -1, -1, -1, 0, 1, 1, 1};
	static int[] colMove =  {-1, -1,  0,  1, 1, 1, 0, -1};
	
	public void checkDictionary(char[][] dictionary, List<String> words, boolean[][] visited, int row, int col, String word) {
		if(words.contains(word)) {
			System.out.println(word);
			return;
		}
		
		for(int i=0; i<rowMove.length; i++) {
			int newRow = row + rowMove[i];
			int newCol = col + colMove[i];
			
			if(newRow >=0 && newCol>=0 && newRow<dictionary.length && newCol<dictionary[newRow].length && !visited[newRow][newCol]) {
				visited[newRow][newCol] = true;
				checkDictionary(dictionary, words, visited, newRow, newCol, word + dictionary[newRow][newCol]);
				visited[newRow][newCol] = false;
			}
		}
		
		
	}

	public static void main(String[] args) {
		Boggle boggle = new Boggle();
		char[][] dictionary = {{'G','I','Z' },
                {'U','E','K' },
                {'Q','S','E' }};
		boolean[][] visited = new boolean[3][3];
		List<String>  words = new ArrayList<String>();
		words.add("GEEKS");
		words.add("QUIZ");
		words.add("FOR");
		words.add("GO");
		words.add("EUGE");
		
		String word = "";
		
		for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
            	visited[row][col] = true;
                boggle.checkDictionary(dictionary, words, visited, 0, 0, word+dictionary[row][col]);
                visited[row] [col] = false;
            }
        }
		
		
		
	}
}
