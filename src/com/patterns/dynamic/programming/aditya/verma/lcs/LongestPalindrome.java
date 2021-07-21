package com.patterns.dynamic.programming.aditya.verma.lcs;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
		int max = 0;
		int max_i = 0;
		int max_j = 0;

		if(s==null || s.length()==0) return s;

		//dp[i,j] represents whether substring(i,j) is palindrome
		boolean dp[][] = new boolean[s.length()][s.length()];


		for(int i=0;i<s.length();i++){
			dp[i][i] = true;
		}

		for(int i=s.length()-1;i>=0;i--){
			for(int j=i+1;j<s.length();j++){
				if(s.charAt(i)==s.charAt(j)){
					if(j-i==1 || dp[i+1][j-1]==true){
						dp[i][j]=true;
						if(j-i+1>max){
							max = j-i+1;
							max_i = i;
							max_j = j;
						}
					}
				}
			}
		}

		return s.substring(max_i,max_j+1);
	}
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindrome().longestPalindrome("babad"));
	}
}
