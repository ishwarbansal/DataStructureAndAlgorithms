package com.patterns.tree.deapth.first.search;

import com.patterns.tree.breadth.first.search.TreeNode;

public class SumOfPathNumbers {

	public static int findSumOfPathNumbers(TreeNode root) {
		return findRootToLeafPathNumbers(root, 0);
	}

	private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
		if (currentNode == null)
			return 0;

		// calculate the path number of the current node
		pathSum = 10 * pathSum + currentNode.val;

		// if the current node is a leaf, return the current path sum.
		if (currentNode.left == null && currentNode.right == null) {
			System.out.println(pathSum);
			return pathSum;
		}

		// traverse the left and the right sub-tree
		return findRootToLeafPathNumbers(currentNode.left, pathSum) +
				findRootToLeafPathNumbers(currentNode.right, pathSum);
	}

	public static void main(String[] args) {
		//		TreeNode root = new TreeNode(1);
		//		root.left = new TreeNode(0);
		//		root.right = new TreeNode(1);
		//		root.left.left = new TreeNode(1);
		//		root.right.left = new TreeNode(6);
		//		root.right.right = new TreeNode(5);

		//		root.left = new TreeNode(7);
		//		root.right = new TreeNode(9);
		//		root.right.left = new TreeNode(2);
		//		root.right.right = new TreeNode(9);

		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}


}
