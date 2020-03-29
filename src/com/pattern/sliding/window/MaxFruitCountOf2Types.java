package com.pattern.sliding.window;

public class MaxFruitCountOf2Types {

	public static int findLength(String str, int k) {
	    // TODO: Write your code here
		String strList = "";
		String var = "";
		int startIndex = 0;
		int distinctChar = 0;
		int maxLen = 0;
		int strLen = str.length();
		int maxStartIndex = -1;
		int maxEndIndex = -1;
		for(int i=0; i<strLen; i++) {
			if(!var.contains(str.substring(i,i+1))) {
				distinctChar++;
			}
			if(distinctChar <= k) {
				var += str.charAt(i);
			}
			
			if(distinctChar > k || i==strLen-1){
				if(var.length() > maxLen) {
					strList = var;
					maxLen = var.length();
					maxStartIndex = startIndex;
					maxEndIndex = i;
				}
				distinctChar = 0;
				var = "";
				i = startIndex;
				startIndex++;
			}
		}
		
		System.out.println(strList);
		
		System.out.println("maxStartIndex " + maxStartIndex);
		System.out.println("maxEndIndex " + maxEndIndex);
		return -1;
	  }

	public static void main(String[] args) {
		findLength("araaci", 2);
		findLength("aabaarrr", 2);
		findLength("ABCCBAAABBDDDDD", 2);
	}
	
}
