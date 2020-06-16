package com.leetcode.challenge.may2020.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StockSpan{
	int price=0, range=0;
}
public class StockSpanner {

	//	List<StockSpan> list;
	//	public StockSpanner() {
	//		list = new ArrayList<StockSpan>();
	//		
	//	}
	//
	//	public int next(int price) {
	//		StockSpan spanner = new StockSpan();
	//		spanner.price = price;
	//		
	//		if(list.size()==0) {
	//			spanner.range = 1;
	//			list.add(spanner);
	//			return 1;
	//		}
	//		
	//		int range=1;
	//		
	//		for(int i=list.size()-1; i>=0; i--) {
	//			StockSpan sp = list.get(i);
	//			if(sp.price < price) {
	//				i = i - sp.range + 1;
	//				range = range +sp.range;
	//			}else if(sp.price==price) {
	//				range = range + sp.range;
	//				break;
	//			}else {
	//				break;
	//			}
	//		}
	//		spanner.range = range;
	//		list.add(spanner);
	//		return range;
	//	}
	Stack<Integer[]> stack = new Stack<Integer[]>();
	List<Integer> list = new ArrayList<Integer>();
	int index = 0;
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
		StockSpanner spanner = new StockSpanner();
		System.out.println(spanner.next(100));
		System.out.println(spanner.next(80));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(70));
		System.out.println(spanner.next(60));
		System.out.println(spanner.next(75));
		System.out.println(spanner.next(85));

	}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */