package com.data.structure.stack;

import java.util.EmptyStackException;


public class MinStack {

	private static class Node{
		private int data;
		private Node next;
		private int min;
		
		private Node(int data, int min){
			this.data = data;
			this.min = min;
		}

	}

	private Node top;

	public boolean isEmpty() {
		return top == null;
	}
	
	public int minValue() {
		if(peek()==null)
			return Integer.MAX_VALUE;
		
		return peek().min;
	}

	public Node peek() {
		if(top==null)
			throw new EmptyStackException();

		return top;			
	}

	public int pop() {
		int data = top.data;
		top = top.next;
		return data;
	}

	public void push(int data) {
		Node node = new Node(data, Math.min(data, minValue()));
		node.next = top;
		top = node;

	}

/*	class MinValue{
		int vlaue;
		int min;

		MinValue(int value, int min){
			this.vlaue = value;
			this.min = min;
		}
	}
*/
}
