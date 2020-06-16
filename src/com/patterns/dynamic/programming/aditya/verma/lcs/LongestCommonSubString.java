package com.patterns.dynamic.programming.aditya.verma.lcs;

public class LongestCommonSubString {

	int maxLengthRecurssion;
	public int getLongestCommonSubStringUsingRecurssion(String st1, String st2, int st1Length, int st2Length) {
		int max = 0;
		if(st1Length == 0 || st2Length == 0) {
			max = 0;
			return 0;
		}

		if(st1.charAt(st1Length-1)==st2.charAt(st2Length-1)){
			max = 1 + getLongestCommonSubStringUsingRecurssion(st1, st2, st1Length-1, st2Length-1);
			maxLengthRecurssion = Math.max(maxLengthRecurssion, max);
		}else {
			max = 0;
			getLongestCommonSubStringUsingRecurssion(st1, st2, st1Length-1, st2Length);
			getLongestCommonSubStringUsingRecurssion(st1, st2, st1Length, st2Length-1);
		}
		return max;
	}

	int maxLength = Integer.MIN_VALUE;
	
	public int getLongestCommonSubSequenceUsingBottomUp(String st1, String st2, int st1Length, int st2Length) {
		int[][] dp = new int[st1.length()+1][st2.length()+1];


		for(int i=0; i<st1.length()+1; i++) {
			for(int j=0; j<st2.length()+1; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}

		for(int i=1; i<st1.length()+1; i++) {
			for(int j=1; j<st2.length()+1; j++) {
				if(st1.charAt(i-1)==st2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
					maxLength = Math.max(dp[i][j], maxLength);
				}else {
					dp[i][j] = 0;
				}
			}
		}
		System.out.println(printSelectedElements(dp, st1, st2));
		return maxLength;
	}

	private String printSelectedElements(int bp[][], String st1, String st2){
		int row = bp.length-1;
		int col = bp[0].length-1;
		String lcs = "";
		while(row>0 && col >0) {
			if(st1.charAt(row-1)==st2.charAt(col-1)){
				lcs = st1.charAt(row-1) + lcs;
				row--;
				col--;
			}else {
				if(bp[row-1][col]>bp[row][col-1]) {
					row--;
				}else {
					col--;
				}
			}
		}
		return lcs;
	}

	public static void main(String[] args) {
		String st1= "abcd";
		String st2 = "cdabc";

		LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
//		longestCommonSubString.getLongestCommonSubStringUsingRecurssion(st1, st2, st1.length(), st2.length());
//		System.out.println("getLongestCommonSubStringUsingRecurssion " + longestCommonSubString.maxLengthRecurssion);

		System.out.println("getLongestCommonSubSequenceUsingBottomUp " + longestCommonSubString.getLongestCommonSubSequenceUsingBottomUp(st1, st2, st1.length(), st2.length()));

	}
}
