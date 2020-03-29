package com.patterns.tree.deapth.first.search;

import com.patterns.tree.breadth.first.search.TreeNode;

public class PathWithGivenSequence {

	static int row = 0;

	public static boolean findPath(TreeNode root, int[] sequence) {
		return findSequence(root, sequence, 0);
	}

	private static boolean findSequence(TreeNode root, int[] sequence, int level) {

		if(root==null)
			return false;

		if(sequence[level]!=root.val || level >= sequence.length)
			return false;

		if(root.left==null && root.right==null && level == sequence.length-1) {
			return true;
		}

		boolean isExist = findSequence(root.left, sequence, level+1) ||  findSequence(root.right, sequence, level+1);

		return isExist;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}


}
