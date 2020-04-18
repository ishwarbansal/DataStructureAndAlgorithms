package com.leetcode.challenge.april2020.week2;

import java.util.LinkedList;

public class MinStack {

	LinkedList<Integer> list;

	public MinStack() {
		list = new LinkedList<Integer>();
	}

	public void push(int x) {
		list.add(x);
	}

	public void pop() {
		list.removeLast();
	}

	public int top() {
		return list.getLast();
	}

	public int getMin() {
		if(list.size()==0)
			return 0;
		if(list.size()==1)
			return list.get(0);
		
		int minValue = list.get(0);
		
		for(int val : list)
			minValue = Math.min(minValue, val);

		return minValue;
	}
	
	public static void main(String[] args) {
		 MinStack minStack = new MinStack();
		 minStack.push(-2);
		 minStack.push(0);
		 minStack.push(-3);
		 System.out.println(minStack.getMin());  // --> Returns -3.
		 minStack.pop();
		 System.out.println(minStack.top());     // --> Returns 0.
		 System.out.println(minStack.getMin());  // --> Returns -2.
	}
}

