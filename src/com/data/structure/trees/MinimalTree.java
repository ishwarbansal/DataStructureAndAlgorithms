 package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

/* Minimal Tree
 * 
 * Given a sorted (increasing order) array with unique integer elements, 
 * write an algorithm to create a binary tree with minimal height.
 * */
public class MinimalTree {

	TreeNode createMinimalTree(int[] arr) {
		return getMinimalTree(arr, 0, arr.length-1);
	}

	
	/*
	 * The algorithm is as follows:
	 * 
	 * 1. Insert into the tree the middle element of the array.
	 * 2. Insert (into the left subtree) the left sub array elements.
	 * 3. Insert (into the right subtree) the right sub array elements.
	 * 4. Recurse
	 * */
	TreeNode getMinimalTree(int[] arr, int start, int end) {
		if(end<start) {
			return null;
		}
		
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = getMinimalTree(arr, start, mid-1);
		node.right = getMinimalTree(arr, mid+1, end);
		
		return node;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,6,7,8,9,10,11};
		MinimalTree obj = new MinimalTree();
		obj.createMinimalTree(arr);
	}
}
