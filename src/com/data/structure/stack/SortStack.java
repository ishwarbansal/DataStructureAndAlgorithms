package com.data.structure.stack;


import java.util.Stack;

public class SortStack {

	public void sortStack(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty()) {
			int top = s.pop();
			
			while(!r.isEmpty() && r.peek() > top) {
				s.push(r.pop());
			}
			
			r.push(top);
		}
		
		while(!r.isEmpty()) {
			s.push(r.pop());
		}
	
	}

	public static void main(String[] args) {
		SortStack obj = new SortStack();
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(5);
		obj.sortStack(s);
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}
