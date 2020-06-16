package com.leetcode.challenge.may2020.week1;

public class DayTwo {

		public int numJewelsInStones(String J, String S) {
	        int jewelsCnt = 0;
	        
	        for(int i=0; i<S.length(); i++) {
	        	if(J.indexOf(S.charAt(i))>=0)
	        		jewelsCnt++;
	        }
	        return jewelsCnt;
	    }
		
		public static void main(String[] args) {
			DayTwo dayTwo = new DayTwo();
			System.out.println(dayTwo.numJewelsInStones("aA", "aAAbbbb"));
		}
}
