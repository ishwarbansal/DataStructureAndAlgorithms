package com.patterns.top.k.elements;

import java.util.PriorityQueue;

import com.patterns.tree.breadth.first.search.TreeNode;

public class SumOfElements {


	public static int findSumOfElements(int[] nums, int k1, int k2) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b)-> b-a);

		for(int i=0; i<k2-1; i++)
			maxHeap.add(nums[i]);

		for(int j=k2-1; j<nums.length; j++) {
			if(nums[j]<maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.add(nums[j]);
			}
		}

		int sum = 0;

		System.out.println(maxHeap.size());

		while(maxHeap.size() >k1) 
			sum += maxHeap.poll();

		System.out.println(maxHeap.size());
		return sum==0?-1:sum;
	}

	public static void main(String[] args) {
		int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11,28,30 }, 3, 6);
		System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

		result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
		System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
	}


}
