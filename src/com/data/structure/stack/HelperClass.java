package com.data.structure.stack;

import java.util.Stack;

public class HelperClass {

	/*Helper Method to solve stack problems 
	 * nextGreaterElementToRight
	 * nextGreaterElementToLeft
	 * nextSmallerElementToRight
	 * nextSmallerElementToLeft
		e.g. Stock Span, Maximum Rectangle, Largest Rectangle in Histogram, Rain water Trapping*/

	/* Logic
	 * If stack is empty means there is no element exists in the right or left side which is greater/smaller.
	 * if stack is not empty, will delete the element from stack if it's less/greater than or equal to current element.
	 * In the last of each iteration, will insert the current element into stack. 
	 * 
	 * Minor changes in different method:
	 * Comparison logic will be changed based on what is the problem, is it to find greater or smaller value.
	 * if problem is for right side element then loop will start from last element of array which means from right side element.
	 * if problem is for left side element then loop will start from first element of array which means from left side element.
	 * at the end of each iteration we will add current element to stack.
	 * 
	 * if stack is empty return -1
	 * if stack is not empty, pick the top element and return.
	 * */


	public int[] nextGreaterElementToRight(int[] nums2) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[nums2.length];

		for(int i=nums2.length-1; i>=0; i--){
			while(!stack.isEmpty() && stack.peek()<=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				result[i]=-1;
			}else {
				result[i]=stack.peek();
			}

			stack.push(nums2[i]);
		}
		return result;
	}

	public int[] nextSmallerElementToRight(int[] nums2) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[nums2.length];

		for(int i=nums2.length-1; i>=0; i--){
			while(!stack.isEmpty() && stack.peek()>=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				result[i]=-1;
			}else {
				result[i]=stack.peek();
			}
			stack.push(nums2[i]);
		}

		return result;
	}

	public int[] nextGreaterElementToLeft(int[] nums2) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[nums2.length];

		for(int i=0; i<nums2.length; i++){
			while(!stack.isEmpty() && stack.peek()<=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				result[i]=-1;
			}else {
				result[i]=stack.peek();
			}

			stack.push(nums2[i]);
		}

		return result;
	}

	public int[] nextSmallerElementToLeft(int[] nums2) {

		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[nums2.length];

		for(int i=0; i<nums2.length; i++){
			while(!stack.isEmpty() && stack.peek()>=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				result[i]=-1;
			}else {
				result[i]=stack.peek();
			}

			stack.push(nums2[i]);
		}

		return result;
	}

	public static void main(String[] args) {
		//			HelperClass elementI = new HelperClass();
		//			int[] result = elementI.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});
		//			for(int num : result) {
		//				System.out.println(num);
		//			}

		HelperClass elementI = new HelperClass();

		int[] result = elementI.nextGreaterElementToRight(new int[] {100,80,60,70,60,75,85});
		System.out.println("Next Greater Element to Right");
		for(int num : result) {
			System.out.println(num);
		}

		System.out.println("Next Smaller Element to Right");
		result = elementI.nextSmallerElementToRight(new int[] {100,80,60,70,60,75,85});
		for(int num : result) {
			System.out.println(num);
		}

		System.out.println("Next Greater Element to Left");
		result = elementI.nextGreaterElementToLeft(new int[] {100,80,60,70,60,75,85});
		for(int num : result) {
			System.out.println(num);
		}

		System.out.println("Next Smaller Element to Left");
		result = elementI.nextSmallerElementToLeft(new int[] {100,80,60,70,60,75,85});
		for(int num : result) {
			System.out.println(num);
		}

		System.out.println("Next Smaller Element to Right");
		result = elementI.nextSmallerElementToRight(new int[] {2,1,5,6,2,3});
		for(int num : result) {
			System.out.println(num);
		}
	}
}


