package com.data.structure.stack;

import java.util.EmptyStackException;


/* Three in One: Describe how you could use a single array to implement three stacks*/
public class KStackInSingleArray {
	private int numberOfStacks = 3;
	private int stackCapacity;
	private int[] values;
	private int[] sizes;

	public KStackInSingleArray(int stackSize) {
		stackCapacity = stackSize;
		values = new int[stackSize * numberOfStacks];
		sizes = new int[numberOfStacks];
	}


	/* Push value onto stack. */
	public void push(int stackNum, int value) throws Exception, StackOverflowError {
		/* Check that we have space for the next element */
		if(isFull(stackNum))
			throw new StackOverflowError();
		
		/* Increment stack pointer and then update top value. */
		sizes[stackNum]++;
		System.out.println("Index "+indexOfTop(stackNum));
		values[indexOfTop(stackNum)] = value;
	}
	
	/* Pop from the top stack */
	public int pop(int stackNum) {
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		
		int topIndex = indexOfTop(stackNum);
		int value = values[topIndex]; //Get Top
		values[topIndex] = 0; // Clear
		sizes[stackNum]--; //Shrink
		return value;
	}
	
	/* Return top element */
	public int peek(int stackNum) {
		if(isEmpty(stackNum))
			throw new EmptyStackException();
		
		return values[indexOfTop(stackNum)];
	}
	
	/* Return if stack is empty */
	public boolean isEmpty(int stackNum) {
		return sizes[stackNum] == 0;
	}
	/* Returns index of the top of the stack */
	public int indexOfTop(int stackNum) {
		int offset = stackNum * stackCapacity;
		int size = sizes[stackNum];
		return offset + size - 1;
	}

	/* Return if stack is full */
	public boolean isFull(int stackNum) {
		return sizes[stackNum] == stackCapacity;
	}
	
	public static void main(String[] args) {
		KStackInSingleArray obj = new KStackInSingleArray(10);
		try {
			obj.push(1, 4);
			obj.push(2, 5);
			obj.push(0, 2);
			obj.push(2, 7);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

