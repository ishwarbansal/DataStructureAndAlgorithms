package com.patterns.dynamic.programming.aditya.verma.lcs;

public class MinimumNoOfDeletionToMakePalindromicSubSequence {
	
	int[][] dp;
	public MinimumNoOfDeletionToMakePalindromicSubSequence(int st1Length, int st2Lenght) {
		dp = new int[st1Length+1][st2Lenght+1];
	}

	public int getMinimumNoOfDeletionToMakePalindromicSubSequenceUsingRecurssion(String st1, String st2, int st1Length, int st2Length) {

		if(st1Length == 0 || st2Length == 0)
			return 0;
		
		if(st1.charAt(st1Length-1)==st2.charAt(st2Length-1)){
			return 1 + getMinimumNoOfDeletionToMakePalindromicSubSequenceUsingRecurssion(st1, st2, st1Length-1, st2Length-1);
		}else {
			return Math.max(getMinimumNoOfDeletionToMakePalindromicSubSequenceUsingRecurssion(st1, st2, st1Length-1, st2Length), getMinimumNoOfDeletionToMakePalindromicSubSequenceUsingRecurssion(st1, st2, st1Length, st2Length-1));
		}
	}

	
	public int getgetMinimumNoOfDeletionToMakePalindromicSubSequenceUsingBottomUp(String st1, String st2, int st1Length, int st2Length) {

		
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
		printSelectedElements(dp, st1, st2);
		return dp[st1Length][st2Length];
	}
	
	private void printSelectedElements(int bp[][], String st1, String st2){
		System.out.println("-----------");
				
//				for(int i=0; i<bp.length; i++) {
//					for(int j=0; j<bp[i].length; j++) {
//						System.out.print(bp[i][j] + "  ");
//					}
//					System.out.println("");
//				}

		System.out.println("Selected characters:");

		int row = bp.length-1;
		int col = bp[0].length-1;
		
		while(row>0 && col >0) {
			if(st1.charAt(row-1)==st2.charAt(col-1)){
				System.out.print(st1.charAt(row-1) + "  ");
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
		System.out.println("");
	}
	
	public static void main(String[] args) {
		String st1= "agbcba";
		StringBuilder st2 = new StringBuilder();
		char[] ch = st1.toCharArray();
		for(int i= ch.length-1; i>=0; i--) {
			st2.append(ch[i]);
		}
		

		MinimumNoOfDeletionToMakePalindromicSubSequence longestCommonSubSequence = new MinimumNoOfDeletionToMakePalindromicSubSequence(st1.length(), st2.length());
		
		int result = longestCommonSubSequence.getMinimumNoOfDeletionToMakePalindromicSubSequenceUsingRecurssion(st1, st2.toString(), st1.length(), st2.length());
		int deletion = st1.length()-result;
		System.out.println("getLongestCommonSubSequenceUsingRecurssion  Deletion " + deletion);
		
		result = longestCommonSubSequence.getgetMinimumNoOfDeletionToMakePalindromicSubSequenceUsingBottomUp(st1, st2.toString(), st1.length(), st2.length());
		deletion = st1.length()-result;
		System.out.println("getLongestCommonSubSequenceUsingBottomUp " + deletion);
		
	}
}
