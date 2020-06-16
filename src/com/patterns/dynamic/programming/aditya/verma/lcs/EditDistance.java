package com.patterns.dynamic.programming.aditya.verma.lcs;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length()+1][word2.length()+1];
		
		for(int i=0; i<word1.length()+1; i++) {
			for(int j=0; j<word2.length()+1; j++) {
				if(i==0)
					dp[i][j] = j;
				else if(j==0)
					dp[i][j] = i;
			}
		}
		
		for(int i=1; i<word1.length()+1; i++) {
			for(int j=1; j<word2.length()+1; j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					dp[i][j] = Math.min((Math.min(1+ dp[i-1][j], 1+ dp[i-1][j-1])), 1+ dp[i][j-1]);
					//First is delete last character from word1
					//Second replace last character in word1
					//Insert character in last of word1
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("horse", "ros"));
	}

}
