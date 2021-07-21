package com.data.structure.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class DinnerPlates {

	int capacity;
	ArrayList<Stack<Integer>>stacks;

	public DinnerPlates(int capacity) {
		this.capacity=capacity;
		stacks=new ArrayList<>();
	}

	public void push(int val) {
		Stack<Integer> last = getLastStack();
		if(last==null || last.size()==capacity) {
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(val);
			stacks.add(stack);
		}else {
			last.push(val);
		}
	}

	public int popAtStack(int index) {
		return leftShift(index, true);
	}
	
	public int pop() {
		Stack<Integer> last = getLastStack();
		if(last==null)
			throw new EmptyStackException();
		
		int v = last.pop();
		if(last.size()==0)
			stacks.remove(stacks.size()-1);
		return v;
	}
	
	public int leftShift(int index, boolean removedTop) {
		Stack<Integer> stack = stacks.get(index);
		int removed_item=0;
		
		if(removedTop)
			removed_item = stack.pop();
//		else
//			removed_item = stack.removeBottom();
		
		if(stack.isEmpty())
			stacks.remove(index);
		else if (stacks.size() > index + 1) {
			int v = leftShift(index + 1, false);
			stack.push(v);
		}
		return removed_item;
	}
	
	public Stack<Integer> getLastStack() {
		if(stacks.size()==0) {
			return null;
		}
		return stacks.get(stacks.size()-1);
	}

	public static void main(String[] args) {
		DinnerPlates obj = new DinnerPlates(2);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5); 
		// The stacks are now:  
		//		2  4
		//		1  3  5
		obj.popAtStack(0);   
//		Returns 2.  The stacks are now:     
//		4
//		1  3  5
		obj.push(20);        
//		The stacks are now: 
//		20  4
//		1  3  5
		obj.push(21);        
//		The stacks are now: 
//		20  4 21
//		1  3  5
		obj.popAtStack(0);   
//		Returns 20.  The stacks are now:     
//		4 21
//		1  3  5
		obj.popAtStack(2);   
//		Returns 21.  The stacks are now:     
//		4
//		1  3  5
		obj.pop();            
//		Returns 5.  The stacks are now:      
//		4
//		1  3 
		obj.pop();            
//		Returns 4.  The stacks are now:   1  3 
		obj.pop();            
//		Returns 3.  The stacks are now:   1 
		obj.pop();            
//		Returns 1.  There are no stacks.
		obj.pop();            
//		Returns -1.  There are still no stacks.
		obj.push(9);
		obj.push(5);
	}

}
