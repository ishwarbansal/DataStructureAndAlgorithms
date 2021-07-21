package com.patterns.tree.deapth.first.search;

import com.patterns.tree.breadth.first.search.TreeNode;

public class PathWithGivenSequence {
	public static boolean findPath(TreeNode root, int[] sequence) {

		return checkPath(root, sequence, 0);
	}

	public static boolean checkPath(TreeNode node, int[] sequence, int index) {

		if(node==null || index>= sequence.length || node.val!=sequence[index])
			return false;

		if(sequence[index] == node.val && node.left==null && node.right==null)
			return true;

		return checkPath(node.left, sequence, index+1) || checkPath(node.right, sequence, index+1);


	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(6);
//		root.right.left.left = new TreeNode(2);
		root.right.right = new TreeNode(5);
		

		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
		System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
	}
}
