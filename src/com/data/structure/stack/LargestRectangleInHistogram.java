package com.data.structure.stack;

import java.util.Stack;

/*84. Largest Rectangle in Histogram
Hard
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

Example:
Input: [2,1,5,6,2,3]
Output: 10

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4
 
Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
*/

public class LargestRectangleInHistogram {
	
	public int getLaregestRecInHistogram(int[] nums2) {
		//Similar to MaximalRectangle
		int nsr[] = nextSmallerElementToRight(nums2);
		int nsl[] = nextSmallerElementToLeft(nums2);
		
		int maxArea = Integer.MIN_VALUE;
		
		//Difference from MaximalRectangle is that, here we have to multiple with current element.
		for(int i=0; i<nums2.length; i++) {
			maxArea = Math.max(maxArea, (nsr[i] - nsl[i] - 1 ) * nums2[i]);
		}
		
		return maxArea;
	}

	public int[] nextSmallerElementToRight(int[] nums2) {

		Stack<Integer[]> stack = new Stack<Integer[]>();
		int[] result = new int[nums2.length];

		for(int i=nums2.length-1; i>=0; i--){
			while(!stack.isEmpty() && stack.peek()[0]>=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				result[i]=nums2.length;
			}else {
				result[i]=stack.peek()[1];
			}
			stack.push(new Integer[] {nums2[i], i});
		}
		return result;
	}

	public int[] nextSmallerElementToLeft(int[] nums2) {

		Stack<Integer[]> stack = new Stack<Integer[]>();
		int[] result = new int[nums2.length];

		for(int i=0; i<nums2.length; i++){
			while(!stack.isEmpty() && stack.peek()[0]>=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				result[i]=-1;
			}else {
				result[i]=stack.peek()[1];
			}

			stack.push(new Integer[] {nums2[i],i});
		}

		return result;
	}

	public static void main(String[] args) {
		LargestRectangleInHistogram obj = new LargestRectangleInHistogram();
		int[] nums2= new int[] {2,1,5,6,2,3};
		System.out.println("Next Smaller Element to Right");
		int[] result = obj.nextSmallerElementToRight(nums2);
		for(int num : result) {
			System.out.println(num);
		}
		
		System.out.println("Next Smaller Element to Left");
		result = obj.nextSmallerElementToLeft(nums2);
		for(int num : result) {
			System.out.println(num);
		}
		
		System.out.println("");
		System.out.println("Max Rec Area is "+ obj.getLaregestRecInHistogram(nums2));
	}
}
