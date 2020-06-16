package com.leetcode.challenge.may2020.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {

	Stack<Integer> stack = null;
	List<Integer> list = null;

	public void arrangeElementForRight(int[] arr) {
		stack = new Stack<Integer>();
		list = new ArrayList<Integer>();
		
		for(int i=arr.length-1; i>=0; i--) {
			if(stack.isEmpty()) {
				list.add(-1);
			}else if(stack.peek()>arr[i]) {
				list.add(stack.peek());
			}else if(stack.peek()<=arr[i]) {
				while(!stack.isEmpty() && stack.peek()<=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}else {
					list.add(stack.peek());
				}
			}
			stack.add(arr[i]);
		}
	}
	
	public void arrangeElementForLeft(int[] arr) {
		stack = new Stack<Integer>();
		list = new ArrayList<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			if(stack.isEmpty()) {
				list.add(-1);
			}else if(stack.peek()>arr[i]) {
				list.add(stack.peek());
			}else if(stack.peek()<=arr[i]) {
				while(!stack.isEmpty() && stack.peek()<=arr[i]) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					list.add(-1);
				}else {
					list.add(stack.peek());
				}
			}
			stack.add(arr[i]);
		}
	}
	
	public int getNearestGreaterToRight(int index) {
		return list.get(list.size()-1-index);
	}
	public int getNearestGreaterToLeft(int index) {
		return list.get(index);
	}
	public static void main(String[] args) {
		Test test = new Test();
		
		test.arrangeElementForRight(new int[] {1,3,5,0,2,4});
		System.out.println(test.getNearestGreaterToRight(2));
	
		test.arrangeElementForLeft(new int[] {1,3,5,0,2,4});
		System.out.println(test.getNearestGreaterToLeft(3));

	}
	
}

