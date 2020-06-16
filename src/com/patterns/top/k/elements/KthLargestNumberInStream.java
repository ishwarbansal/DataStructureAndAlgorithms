package com.patterns.top.k.elements;

import java.util.PriorityQueue;

public class KthLargestNumberInStream {

	PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b) -> a-b);

	public KthLargestNumberInStream(int[] nums, int k) {
		for(int i=0; i<k; i++)
			pQueue.add(nums[i]);
		
		for(int i=k; i<nums.length; i++) {
			if(nums[i]>pQueue.peek()) {
				pQueue.poll();
				pQueue.add(nums[i]);
			}
		}
	}

	public int add(int val) {
		if(val>pQueue.peek()) {
			pQueue.poll();
			pQueue.add(val);
		}
		
		return pQueue.peek();
	}

	public static void main(String[] args) {
		int[] input = new int[] { 3, 1, 5, 12, 2, 11 };
		KthLargestNumberInStream kthLargestNumber = new KthLargestNumberInStream(input, 4);
		System.out.println("4th largest number is: " + kthLargestNumber.add(6));
		System.out.println("4th largest number is: " + kthLargestNumber.add(13));
		System.out.println("4th largest number is: " + kthLargestNumber.add(4));
	}


}
