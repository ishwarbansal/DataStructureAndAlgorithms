package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

/*
 * Check Balanced: Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that the heights
 * of the the two subtrees of any node never differ by more than once.
 * 
 * */
public class CheckBalanced {

	/*
	 * Although this works, it's not very efficient. On each node, we recurse through its entire subtree.
	 * This means that getHeight is called repeatedly on the same nodes.
	 * The algorithm is O(N log N) since each node is "touched" once per node above it.
	 * 
	 * */
	boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;

		int heightDiff = getHeight(root.left) - getHeight(root.right);
		
		if(Math.abs(heightDiff)>1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
		
	}

	int getHeight(TreeNode root) {
		if(root == null)
			return -1; 
		
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	/*
	 * If we inspect this method, we may notice that getHeight could actually check if the tree is balanced
	 * at the same time as it's checking heights. What do we do when we discover that the subtree isn't balanced?
	 * Just return an error code.
	 * 
	 * */
	int checkHeight(TreeNode root) {
		if(root == null)
			return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; //Pass error up
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE)
			return Integer.MIN_VALUE; //Pass error up
		
		int heightDiff = leftHeight - rightHeight;
		
		if(Math.abs(heightDiff)>1)
			return Integer.MIN_VALUE;
		else
			return Math.max(leftHeight, rightHeight) + 1 ;
		
	}
	
	
	public static void main(String[] args) {
		CheckBalanced obj = new CheckBalanced();
		
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(9);
		root.right = new TreeNode(18);

		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(20);

		root.left.left.left = new TreeNode(4);
//		root.left.left.left.left = new TreeNode(2);
		root.left.right = new TreeNode(8);
		
		System.out.println(obj.isBalanced(root));
		System.out.println(obj.checkHeight(root)!=Integer.MIN_VALUE);
		
	}
}
