package com.patterns.dynamic.programming.aditya.verma.lcs;

public class DistinctLongestCommonSubSequence {

	public int getLongestCommonSubSequenceUsingBottomUp(String st1, String st2, int st1Length, int st2Length) {
		int[][] dp = new int[st2Length+1][st1Length+1];

		for(int j=0; j<st1.length()+1; j++) {
			dp[0][j] = 1;
		}

		for(int i=1; i<st2.length()+1; i++) {
			for(int j=1; j<st1.length()+1; j++) {
				if(st2.charAt(i-1)==st1.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
				}else {
					dp[i][j] = dp[i][j-1] ;
				}
			}
		}
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}
		return dp[st2Length][st1Length];
	}

	public int numDistinct(String s, String t) {
		return getLongestCommonSubSequenceUsingBottomUp(s, t, s.length(), t.length());
	}

	public static void main(String[] args) {
		String st1= "rabbbit";
		String st2 = "rabbit";

		DistinctLongestCommonSubSequence longestCommonSubSequence = new DistinctLongestCommonSubSequence();

		System.out.println("getLongestCommonSubSequenceUsingBottomUp " + longestCommonSubSequence.numDistinct(st1, st2));

	}
}
