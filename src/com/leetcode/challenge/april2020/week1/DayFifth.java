package com.leetcode.challenge.april2020.week1;

public class DayFifth {

	public int maxProfit(int[] prices) {
		int maxProfit = 0;

		int startIndex = 0;
		int buy = -1;
		int sell = 0;

		while(startIndex<prices.length-1){
			if(prices[startIndex+1]>prices[startIndex]) {
				buy = prices[startIndex];
			}

			while(startIndex < prices.length-1 && prices[startIndex+1]>prices[startIndex]) {
				startIndex++;
			}
			
			if(buy>=0) {
				sell = prices[startIndex--];
				maxProfit = maxProfit +  sell - buy;
				buy = -1;
			}
			startIndex++;
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		System.out.println(new DayFifth().maxProfit(new int[] {2,1,2,0,1}));
		System.out.println(new DayFifth().maxProfit(new int[] {7,1,5,3,6,4}));
		System.out.println(new DayFifth().maxProfit(new int[] {1,2,3,4,5}));
		System.out.println(new DayFifth().maxProfit(new int[] {5,3,2,1}));
	}


}
