package com.patterns.k.way.merge.min.heap;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
	
	public static int findKthSmallest(int[][] matrix, int k) {
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
				(n1, n2) -> matrix[n1.arrayIndex][n1.elementIndex] - matrix[n2.arrayIndex][n2.elementIndex]);

		// put the 1st element of each array in the min heap
		for (int i = 0; i < matrix.length; i++) {
			minHeap.add(new Node(0, i));
		}

		// take the smallest (top) element form the min heap, if the running count is equal to k return the number
		// if the array of the top element has more elements, add the next element to the heap
		int numberCount = 0, result = 0;
		while (!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			result = matrix[node.arrayIndex][node.elementIndex];
			if (++numberCount == k)
				break;
			node.elementIndex++;
			if (matrix[node.arrayIndex].length > node.elementIndex)
				minHeap.add(node);
		}
		return result;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
		int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
		System.out.print("Kth smallest number is: " + result);
	}
}