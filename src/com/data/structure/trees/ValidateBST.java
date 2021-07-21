package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

/*
 * Validate BST
 * 
 * Implement a function to check if a binary tree is a binary search tree
 * 
 * */
public class ValidateBST {

	
	/*
	 * Solution#1 with Array
	 * 
	 * Our first thought might be to do an in-order traversal, 
	 * copy the elements to an array and then check to see if the array is sorted.
	 * This solution takes up a bit of extra memory, but it works-mostly.
	 * 
	 * However, if we assume that the tree cannot have duplicate values, 
	 * then this approach works. 
	 * */
	int index=0;
	boolean checkBSTWithArray(TreeNode root) {
		int[] array = new int[7];//root.size
		copyBST(root, array);
		for(int i=1; i<array.length; i++) {
			if(array[i]<=array[i-1])
				return false;
		}
		return true;
	}
	void copyBST(TreeNode root, int[] array) {
		if(root == null)
			return;
		copyBST(root.left, array);
		array[index] = root.val;
		index++;
		copyBST(root.right, array);
	}
	
	/*
	 * Solution#1 Without Array
	 * 
	 * */
	Integer lastPrinted = null;
	boolean checkBSTWithoutArray(TreeNode root) {
		if(root == null)
			return true;

		if(!checkBSTWithoutArray(root.left))
				return false;
		
		if(lastPrinted != null && root.val <= lastPrinted)
			return false;
		
		lastPrinted = root.val;
		
		if(!checkBSTWithoutArray(root.right))
			return false;
		
		return true;
	}

	/*
	 *  Solution#2 Min/Max Solution
	 *  
	 *  BST should satisfy the condition left.data <= current.data < right.data
	 * */
	boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	boolean checkBST(TreeNode n, Integer min, Integer max) {
		if(n == null) {
			return true;
		}
		
		boolean isMin = min!=null && n.val <= min;
		boolean isMax = max!=null && n.val >= max;
		
		if(isMin || isMax) {
			return false;
		}
		
		if(!checkBST(n.left, min, n.val) || !checkBST(n.right, n.val, max)) {
			return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ValidateBST obj = new ValidateBST();
		
		TreeNode root = new TreeNode(15);
		
		root.left = new TreeNode(9);
		root.right = new TreeNode(18);

		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(10);

		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(20);
		
		System.out.println(obj.checkBSTWithoutArray(root));
//		System.out.println(obj.checkBSTWithArray(root));
//		System.out.println(obj.checkBST(root));
	}

}
