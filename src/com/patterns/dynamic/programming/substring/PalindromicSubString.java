package com.patterns.dynamic.programming.substring;

public class PalindromicSubString {

	/*647. Palindromic Substrings
Medium

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:
The input string length won't exceed 1000.
	 */


	public int countSubstrings(String s) {
		int count = 0;
		int[][] dp = new int[s.length()][s.length()];

		//each letter at own index position is palindromic string
		//So we are counting them as 1
		//e.g. 0 0, 1 1, 2 2 index position
		for(int i=0; i<s.length(); i++) {
			dp[i][i] = 1;
			count++;
		}

		for(int col=1; col<s.length(); col++){
			for(int row=0; row<col; row++) {
				//For two length, checking both the character are same.
				if(row==col-1 && s.charAt(row)==s.charAt(col)) {
					dp[row][col] = 1;
					count++;
				//For more than two length check, left and right end character is same 
				//and for middle string will check diagonally solved value.
				}else if(dp[row+1][col-1]==1 && s.charAt(row)==s.charAt(col)) {
					dp[row][col] = 1;
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		PalindromicSubString obj = new PalindromicSubString();
		System.out.println(obj.countSubstrings("cbbd"));
	}
}
