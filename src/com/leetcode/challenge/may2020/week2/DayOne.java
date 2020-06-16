package com.leetcode.challenge.may2020.week2;

import java.util.HashSet;
import java.util.Set;

public class DayOne {

	public boolean checkStraightLine(int[][] coordinates) {

		Set<Integer> uniqueValue = new HashSet<Integer>();
		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;
		
		if(coordinates.length==1)
			return true;

		for(int i =0; i <coordinates.length; i++) {
			minValue = Math.min(minValue, Math.min(coordinates[i][0], coordinates[i][1]));
			maxValue = Math.max(maxValue, Math.max(coordinates[i][0], coordinates[i][1]));
			
			if(coordinates[i][0]<coordinates[i][1]) {
				for(int j=coordinates[i][0]; j<=coordinates[i][1]; j++) {
					uniqueValue.add(j);
				}
			}else {
				for(int j=coordinates[i][0]; j>=coordinates[i][1]; j--) {
					uniqueValue.add(j);
				}
			}
			System.out.println("maxValue - minValue " + (maxValue - minValue) );
			System.out.println("uniqueValue size " + (uniqueValue.size()-1));
			
			if(maxValue - minValue != uniqueValue.size()-1)
				return false;
		}

		return true;
	}

	public static void main(String[] args) {
		DayOne dayTwo = new DayOne();
				int[][] coordinates = {{1,1},{2,3},{4,5}};
//		int[][] coordinates = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
		System.out.println(dayTwo.checkStraightLine(coordinates));
	}

}
