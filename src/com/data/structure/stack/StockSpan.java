package com.data.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpan {
	
	/*901. Online Stock Span
	Medium

	Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

	The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

	For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
	Example 1:
	Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
	Output: [null,1,1,1,2,1,4,6]
	Explanation: 
	First, S = StockSpanner() is initialized.  Then:
	S.next(100) is called and returns 1,
	S.next(80) is called and returns 1,
	S.next(60) is called and returns 1,
	S.next(70) is called and returns 2,
	S.next(60) is called and returns 1,
	S.next(75) is called and returns 4,
	S.next(85) is called and returns 6.

	Note that (for example) S.next(75) returned 4, because the last 4 prices
	(including today's price of 75) were less than or equal to today's price.

	Note:
	Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
	There will be at most 10000 calls to StockSpanner.next per test case.
	There will be at most 150000 calls to StockSpanner.next across all test cases.
	The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.*/

	Stack<Integer[]> stack = new Stack<Integer[]>();
	List<Integer> list = new ArrayList<Integer>();
	int index = 0;

	//Here we are using next greater element to right
	//Difference is that instead of adding only element to stack, will add index position as well.
	public int next(int price) {
		if(stack.isEmpty()) {
			list.add(-1);
		}else if(stack.peek()[0]>price) {
			list.add(stack.peek()[1]);
		}else if(stack.peek()[0]<=price) {
			while(!stack.isEmpty() && stack.peek()[0]<=price) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				list.add(-1);
			}else {
				list.add(stack.peek()[1]);
			}
		}
		stack.add(new Integer[] {price,index});
		int nextVal = this.index - list.get(this.index);
		this.index++;
		
		return nextVal;
	}
	
	public static void main(String[] args) {
		StockSpan span = new StockSpan();
		System.out.println(span.next(100));
		System.out.println(span.next(80));
		System.out.println(span.next(60));
		System.out.println(span.next(70));
		System.out.println(span.next(60));
		System.out.println(span.next(75));
		System.out.println(span.next(85));
		System.out.println(span.next(120));
		
	}
}