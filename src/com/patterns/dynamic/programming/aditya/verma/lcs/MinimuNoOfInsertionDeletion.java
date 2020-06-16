package com.patterns.dynamic.programming.aditya.verma.lcs;

public class MinimuNoOfInsertionDeletion {
	
	int[][] dp;
	public MinimuNoOfInsertionDeletion(int st1Length, int st2Lenght) {
		dp = new int[st1Length+1][st2Lenght+1];
	}

	public int getLongestCommonSubSequenceUsingRecurssion(String st1, String st2, int st1Length, int st2Length) {

		if(st1Length == 0 || st2Length == 0)
			return 0;
		
		if(st1.charAt(st1Length-1)==st2.charAt(st2Length-1)){
			return 1 + getLongestCommonSubSequenceUsingRecurssion(st1, st2, st1Length-1, st2Length-1);
		}else {
			return Math.max(getLongestCommonSubSequenceUsingRecurssion(st1, st2, st1Length-1, st2Length), getLongestCommonSubSequenceUsingRecurssion(st1, st2, st1Length, st2Length-1));
		}
	}

	
	public int getLongestCommonSubSequenceUsingBottomUp(String st1, String st2, int st1Length, int st2Length) {

		
		for(int i=0; i<st1.length()+1; i++) {
			for(int j=0; j<st2.length()+1; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}
		
		for(int i=1; i<st1.length()+1; i++) {
			for(int j=1; j<st2.length()+1; j++) {
				if(st1.charAt(i-1)==st2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[st1Length][st2Length];
	}
	
	public static void main(String[] args) {
		String st1= "heap";
		String st2 = "pea";

		MinimuNoOfInsertionDeletion longestCommonSubSequence = new MinimuNoOfInsertionDeletion(st1.length(), st2.length());
		
		int result = longestCommonSubSequence.getLongestCommonSubSequenceUsingRecurssion(st1, st2, st1.length(), st2.length());
		int deletion = st1.length() - result;
		int insertion = st2.length() - result;
		System.out.println("getLongestCommonSubSequenceUsingRecurssion >>  Deletion " + deletion + "  Insertion  " + insertion);
		
		result = longestCommonSubSequence.getLongestCommonSubSequenceUsingBottomUp(st1, st2, st1.length(), st2.length());
		deletion = st1.length() - result;
		insertion = st2.length() - result;
		System.out.println("getLongestCommonSubSequenceUsingBottomUp >>  Deletion " + deletion + "  Insertion  " + insertion);
		
	}
}
