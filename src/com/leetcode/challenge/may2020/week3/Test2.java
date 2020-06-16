package com.leetcode.challenge.may2020.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test2 {

	Stack<Integer[]> stack = new Stack<Integer[]>();
	List<Integer> list = new ArrayList<Integer>();
	int index = 0;
	public void arrangeElementForLeft(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			if(stack.isEmpty()) {
				list.add(-1);
			}else if(stack.peek()[0]>arr[i]) {
				list.add(stack.peek()[1]);
			}else if(stack.peek()[0]<=arr[i]) {
				while(!stack.isEmpty() && stack.peek()[0]<=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}else {
					list.add(stack.peek()[1]);
				}
			}
			stack.add(new Integer[] {arr[i],i});
		}
	}
	
	public int getNearestGreaterToLeft(int element) {
		int index = this.index;
		this.index++;
		return index - list.get(index);
		
	}
	public static void main(String[] args) {
		Test2 test = new Test2();
		test.arrangeElementForLeft(new int[] {100,80,60,70,60,75,85});
		System.out.println(test.list);
		System.out.println(test.getNearestGreaterToLeft(100));
		System.out.println(test.getNearestGreaterToLeft(80));
		System.out.println(test.getNearestGreaterToLeft(60));
		System.out.println(test.getNearestGreaterToLeft(70));
		System.out.println(test.getNearestGreaterToLeft(60));
		System.out.println(test.getNearestGreaterToLeft(75));
		System.out.println(test.getNearestGreaterToLeft(85));
		
		

	}
	
}

