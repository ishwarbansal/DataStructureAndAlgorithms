package com.patterns.k.way.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


class Element{
	int val1;
	int val2;
	int sum;
	
	Element(int val1, int val2, int sum){
		this.val1 = val1;
		this.val2 = val2;
		this.sum = sum;
	}
	
}
public class LargestPairs {
	
	public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		PriorityQueue<Element> minHeap = new PriorityQueue<Element>(
				(n1, n2) -> n1.sum - n2.sum);

		for(int i=0; i<nums1.length && i<k; i++) {
			for(int j=0; j<nums2.length &j<k; j++) {
				if(minHeap.size()<3) {
					minHeap.offer(new Element(nums1[i], nums2[j], nums1[i]+nums2[j]));
				} else {
					Element element = minHeap.peek();
					if(element.sum < nums1[i]+nums2[j]) {
						minHeap.poll();
						minHeap.offer(new Element(nums1[i], nums2[j], nums1[i]+nums2[j]));
					}
				}
			}
		}
		
		while(!minHeap.isEmpty()) {
			Element element = minHeap.poll();
			result.add(new int[] {element.val1, element.val2});
		}

		return result;
	}

	public static void main(String[] args) {
		int[] l1 = new int[] { 9, 8, 2 };
		int[] l2 = new int[] { 6, 3, 1 };
		List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 3);
		System.out.print("Pairs with largest sum are: ");
		for (int[] pair : result)
			System.out.print("[" + pair[0] + ", " + pair[1] + "] ");

	}

}
