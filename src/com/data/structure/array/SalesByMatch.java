package com.data.structure.array;

import java.util.HashSet;
import java.util.Set;

public class SalesByMatch {

/*	Sales By Match
	Alex works at a clothing store. There is a large pile of socks that must be paired by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
	For example, there are  n=7 socks with colors ar=[1,2,1,2,1,3,2]. There is one 1 pair of color  and one of color 2 . There are three odd socks left, one of each color. The number of pairs is 2.

	Function Description
	Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.
	sockMerchant has the following parameter(s):
	•	n: the number of socks in the pile
	•	ar: the colors of each sock
	Input Format
	The first line contains an integer , the number of socks represented in .
	The second line contains  space-separated integers describing the colors  of the socks in the pile.
	Output Format
	Return the total number of matching pairs of socks that Alex can sell.
	Sample Input
	9
	10 20 20 10 10 30 50 10 20

	Sample Output
	3

	Explanation
	 
	Alex can match three pairs of socks.
*/
	public void salesByMatch(int n, int[] c) {
		Set<Integer> colors = new HashSet<>();
	    int pairs = 0;
	
	    for (int i = 0; i < n; i++) {
	        if (!colors.contains(c[i])) {
	            colors.add(c[i]);
	        } else {
	            pairs++;
	            colors.remove(c[i]);
	        }
	    }
	
	    System.out.println(pairs);
	}
	
	public static void main(String[] args) {
		new SalesByMatch().salesByMatch(7, new int[] {1,2,1,2,1,3,2});
	}
}
