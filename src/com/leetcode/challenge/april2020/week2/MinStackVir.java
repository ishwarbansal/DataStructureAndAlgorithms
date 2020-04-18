package com.leetcode.challenge.april2020.week2;

public class MinStackVir {

	int max=5000;
	private StackNode stackArray[];
	private int top;

	public MinStackVir(){
		stackArray= new StackNode[max];
		top=-1;
	}  
	public void push(int x) {
		if(top==(max-1)) {
			System.out.println("full Array");
			System.exit(1);
		}
		int min=x;
		if(top!=-1){
			StackNode topObj=stackArray[top];
			min = Math.min(topObj.minValue,  x);
		}
		StackNode obj= new StackNode(x,min);
		stackArray[++top]=obj;

	}

	public int pop() {
		if(top==-1) {
			System.out.println("empty Array");
			System.exit(1);
		}
		return stackArray[top--].value;

	}

	public int top() {
		if(top==-1) {
			System.out.println("empty Array");
			System.exit(1);
		}
		return stackArray[top].value;
	}

	public int getMin() {
		if(top==-1) {
			System.out.println("empty Array");
			System.exit(1);
		}
		return stackArray[top].minValue;
	}

	public static void main(String[] args) {

		//Your MinStack object will be instantiated and called as such:
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);

		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());

	}



}
