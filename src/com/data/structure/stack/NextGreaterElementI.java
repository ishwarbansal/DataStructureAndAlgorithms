package com.data.structure.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 496. Next Greater Element I
 * 
 * You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.



Example 1:

Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation:
For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
For number 1 in the first array, the next greater number for it in the second array is 3.
For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:

Input: nums1 = [2,4], nums2 = [1,2,3,4]
Output: [3,-1]
Explanation:
For number 2 in the first array, the next greater number for it in the second array is 3.
For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class NextGreaterElementI {
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {

		Stack<Integer> stack = new Stack<Integer>();
		Map<Integer, Integer> greaterElementMap = new HashMap<Integer, Integer>();

		//Find the Next Greater Elemnt to Rigth in Nums2
		for(int i=nums2.length-1; i>=0; i--){
			while(!stack.isEmpty() && stack.peek()<=nums2[i]){
				stack.pop();
			}

			if(stack.isEmpty()){
				greaterElementMap.put(nums2[i], -1);
			}else {
				greaterElementMap.put(nums2[i], stack.peek());
			}

			stack.push(nums2[i]);
		}

		int[] result = new int[nums1.length];

		//Now we have Next Greater To Right for Nums2 in greaterElementMap.
		//Get Nums1 elemnt in map and return the next greater element to right.
		for(int index=0; index<nums1.length; index++){
			result[index] = greaterElementMap.get(nums1[index]);
		}

		return result;
	}

	public static void main(String[] args) {
		NextGreaterElementI elementI = new NextGreaterElementI();
		int[] result = elementI.nextGreaterElement(new int[] {4,1,2}, new int[] {1,3,4,2});
		for(int num : result) {
			System.out.println(num);
		}
	}
}
