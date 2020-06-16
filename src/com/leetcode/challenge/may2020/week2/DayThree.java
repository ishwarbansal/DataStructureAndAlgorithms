package com.leetcode.challenge.may2020.week2;

public class DayThree {

	public int findJudge(int N, int[][] trust) {
		int[] countArr = new int[N];

		for (int i = 0; i < trust.length; i++) {
			countArr[trust[i][0]-1]--;
			countArr[trust[i][1]-1]++;
		}

		for (int j=0; j<N; j++) {
			if(countArr[j] == N-1)
				return j+1;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		DayThree dayThree = new DayThree();
		System.out.println(dayThree.findJudge(2, new int[][] {{1,2}}));
		System.out.println(dayThree.findJudge(3, new int[][] {{1,3},{2,3}}));
		System.out.println(dayThree.findJudge(3, new int[][] {{1,3},{2,3},{3,1}}));
		System.out.println(dayThree.findJudge(3, new int[][] {{1,2},{2,3}}));
		System.out.println(dayThree.findJudge(4, new int[][] {{1,3},{1,4},{2,3},{2,4},{4,3}}));
	}
}
