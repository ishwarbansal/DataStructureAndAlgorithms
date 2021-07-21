package com.patterns.dynamic.programming.aditya.verma.lcs;

public class LongestCommonSubSequence {

/*1143. Longest Common Subsequence
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 
Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
*/
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
		int[][] dp = new int[st1Length+1][st2Length+1];

		for(int i=0; i<st1.length()+1; i++) {
			for(int j=0; j<st2.length()+1; j++) {
				if(i==0 || j==0)
					dp[i][j] = 0;
			}
		}

		for(int i=1; i<st1.length()+1; i++) {
			for(int j=1; j<st2.length()+1; j++) {
				//Last character of both the string is matching.
				if(st1.charAt(i-1)==st2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}else {
					//If last character of both the string is not matching, 
					//We will get max of (st1 with str2 - 1 or str1 -1, str2) 
					//String 1 is full and string 2 without last character.
					//or
					//String 2 is full and string 1 without last character
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[st1Length][st2Length];
	}

	public static void main(String[] args) {
		String st1= "leet";
		String st2 = "delete";

		LongestCommonSubSequence longestCommonSubSequence = new LongestCommonSubSequence();

		System.out.println("getLongestCommonSubSequenceUsingBottomUp " + longestCommonSubSequence.getLongestCommonSubSequenceUsingBottomUp(st1, st2, st1.length(), st2.length()));

	}
}
