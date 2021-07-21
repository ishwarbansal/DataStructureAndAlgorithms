package com.patterns.dynamic.programming.aditya.verma.mcm;

public class PalindromePartioning {

	int[][] matrix;
	
	public PalindromePartioning(int len) {
		matrix = new int[len][len];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				matrix[i][j] = -1;
			}
		}
	}
	
	public int getMinimumPalindromePartioningUsingRecurssion(String s, int i, int j) {
		if(i>j)
			return 0;

		if(isPalindrome(s, i, j))
			return 0;
		
		int max = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int temp = 1 + getMinimumPalindromePartioningUsingRecurssion(s, i, k) + getMinimumPalindromePartioningUsingRecurssion(s, k+1, j);
			if(temp<max)
				max = temp;
		}
		return max;
	}
	
	public int getMinimumPalindromePartioningUsingDP(String s, int i, int j) {
		if(i>j)
			return 0;

		if(matrix[i][j]!=-1)
			return matrix[i][j];
		
		if(isPalindrome(s, i, j))
			return 0;
		
		int max = Integer.MAX_VALUE;
		for(int k=i; k<j; k++) {
			int temp = 1 + 
						  (matrix[i][k]==-1?getMinimumPalindromePartioningUsingRecurssion(s, i, k):matrix[i][k]) 
						+ (matrix[k+1][j]==-1?getMinimumPalindromePartioningUsingRecurssion(s, k+1, j):matrix[k+1][j])
					;
			if(temp<max)
				max = temp;
		}
		matrix[i][j] = max;
		return max;
	}

	public boolean isPalindrome(String s, int i, int j) {
		if(i==j)
			return true;
		
		if(i>j)
			return false;
		
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "babad";
		PalindromePartioning palindromePartioning = new PalindromePartioning(s.length());
		System.out.println("getMinimumPalindromePartioningUsingRecurssion  "+ palindromePartioning.getMinimumPalindromePartioningUsingRecurssion(s, 0, s.length()-1));
		System.out.println("getMinimumPalindromePartioningUsingDP  "+ palindromePartioning.getMinimumPalindromePartioningUsingDP(s, 0, s.length()-1));
	}
}
