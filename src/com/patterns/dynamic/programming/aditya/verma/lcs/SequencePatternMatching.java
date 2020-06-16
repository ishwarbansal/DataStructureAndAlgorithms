package com.patterns.dynamic.programming.aditya.verma.lcs;

public class SequencePatternMatching {

	int[][] dp;
	public SequencePatternMatching(int st1Length, int st2Lenght) {
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


	public boolean getLongestCommonSubSequenceUsingBottomUp(String st1, String st2, int st1Length, int st2Length) {


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
		return printSelectedElements(dp, st1, st2);
	}

	private boolean printSelectedElements(int bp[][], String st1, String st2){
		System.out.println("-----------");
		boolean isMatching = true;
//		for(int i=0; i<bp.length; i++) {
//			for(int j=0; j<bp[i].length; j++) {
//				System.out.print(bp[i][j] + "  ");
//			}
//			System.out.println("");
//		}

		System.out.println("Selected characters:");

		int row = bp.length-1;
		int col = bp[0].length-1;
		int len = st1.length()-1;
		while(row>0 && col >0) {
			if(st1.charAt(row-1)==st2.charAt(col-1)){
				if(st1.charAt(len--)!=st1.charAt(row-1))
					isMatching = false;
				
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
		return isMatching;
	}

	public static void main(String[] args) {
		String st1= "AXY";
		String st2 = "ADXCPY";

		SequencePatternMatching longestCommonSubSequence = new SequencePatternMatching(st1.length(), st2.length());

		//		System.out.println("getLongestCommonSubSequenceUsingRecurssion " + longestCommonSubSequence.getLongestCommonSubSequenceUsingRecurssion(st1, st2, st1.length(), st2.length()));


		System.out.println("getLongestCommonSubSequenceUsingBottomUp " + longestCommonSubSequence.getLongestCommonSubSequenceUsingBottomUp(st1, st2, st1.length(), st2.length()));

	}
}
