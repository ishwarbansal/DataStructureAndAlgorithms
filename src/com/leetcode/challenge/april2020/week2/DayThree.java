package com.leetcode.challenge.april2020.week2;

import com.patterns.tree.breadth.first.search.TreeNode;

public class DayThree {

	private int treeDiameter = 1;

	public int diameterOfBinaryTree(TreeNode root) {
		if(root==null || (root.left==null && root.right==null))
			return 0;

		calculateHight(root);
		return treeDiameter-1;
	}

	private int calculateHight(TreeNode currentNode) {
		if (currentNode == null)
			return 0;

		int leftTreeHeight = calculateHight(currentNode.left);
		int rightTreeHeight = calculateHight(currentNode.right);

		int diameter = leftTreeHeight + rightTreeHeight + 1;

		treeDiameter = Math.max(treeDiameter, diameter);

		return Math.max(leftTreeHeight, rightTreeHeight) + 1;
	}

	public static void main(String[] args) {
		DayThree dayThree = new DayThree();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		//		root.right = new TreeNode(3);
		//		root.left.left = new TreeNode(4);
		//		root.left.right = new TreeNode(5);
		//		root.right.right = new TreeNode(6);
		//		root.right.right.right = new TreeNode(7);

		System.out.println(dayThree.diameterOfBinaryTree(root));

	}

}
