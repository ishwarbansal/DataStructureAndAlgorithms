package com.patterns.dynamic.programming.aditya.verma.lcs;

public class MinimumASCIIDelete {

	public int minimumDeleteSum(String s1, String s2) {
		int[][] dp = new int[s1.length()+1][s2.length()+1];

		for(int i=1; i<s1.length()+1; i++) {
			dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
		}
		for(int j=1; j<s2.length()+1; j++) {
			dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
		}

		for(int i=1; i<s1.length()+1; i++) {
			for(int j=1; j<s2.length()+1; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}else {
					System.out.println(dp[i-1][j]);
					int n = s1.charAt(i-1);
					System.out.println(n);
					System.out.println(dp[i][j-1]);
					int m = s2.charAt(j-1);
					System.out.println(m);
					System.out.println("-----------");
					dp[i][j] = Math.min( dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1));
				}
			}
		}
		
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}
		
		return dp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		String st1= "delete";
		String st2 = "leet";

		MinimumASCIIDelete longestCommonSubString = new MinimumASCIIDelete();

		System.out.println("getLongestCommonSubSequenceUsingBottomUp " + longestCommonSubString.minimumDeleteSum(st2, st1));

	}
}
