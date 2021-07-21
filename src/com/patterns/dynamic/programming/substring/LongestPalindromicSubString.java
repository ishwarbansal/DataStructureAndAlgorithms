package com.patterns.dynamic.programming.substring;

public class LongestPalindromicSubString {

/*5. Longest Palindromic Substring
Medium
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
*/

	public String longestPalindrome(String s) {
		int max = Integer.MIN_VALUE;
		int startIndex=0, endIndex=0;
		int[][] dp = new int[s.length()][s.length()];

		//each letter at own index position is palindromic string
		//So we are counting them as 1
		//e.g. 0 0, 1 1, 2 2 index position
		for(int i=0; i<s.length(); i++) {
			dp[i][i] = 1;
			max = 1;
		}

		for(int col=1; col<s.length(); col++){
			for(int row=0; row<col; row++) {
				//For two length, checking both the character are same.
				if(row==col-1 && s.charAt(row)==s.charAt(col)) {
					dp[row][col] = 1;
					int subMax = col - row + 1;
					if(subMax>max) {
						max = subMax;
						startIndex = row;
						endIndex = col;
					}
				//For more than two length check, left and right end character is same 
				//and for middle string will check diagonally solved value.
				}else if(dp[row+1][col-1]==1 && s.charAt(row)==s.charAt(col)) {
					dp[row][col] = 1;
					int subMax = col - row + 1;
					if(subMax>max) {
						max = subMax;
						startIndex = row;
						endIndex = col;
					}
				}
			}
		}
		return max==1?s.substring(0,1):s.substring(startIndex, endIndex+1);
	}
	
	public static void main(String[] args) {
		LongestPalindromicSubString obj = new LongestPalindromicSubString();
		System.out.println(obj.longestPalindrome("cbbd"));
	}
}
