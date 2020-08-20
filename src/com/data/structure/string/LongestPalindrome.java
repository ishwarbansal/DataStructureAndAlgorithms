package com.data.structure.string;

import java.util.HashMap;
import java.util.Map;

/*Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.*/

public class LongestPalindrome {

	//Palindrome can be odd or even.
	//Even - abccba
	//Odd - abcdcba 
	//For even palidrome we need all even values. e.g. 2a, 2b, 2c
	//For odd plaindrome we need all even values and one odd value. e.g. 2a, 2b, 2c, 1d
	//abcdddbca 2a, 2b, 2c, 3d
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(char ch : s.toCharArray()){
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}

		int longestPalindrome = 0;
		boolean oddCountExists = false;
		for(Integer value : map.values()){
			if(value%2==0){
				longestPalindrome+=value;
			}else{
				longestPalindrome+=value-1;
				oddCountExists = true;
			}
		}
		if(oddCountExists)
			longestPalindrome+=1;

		return longestPalindrome;
	}

}
