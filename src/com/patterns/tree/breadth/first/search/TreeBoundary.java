package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.List;

public class TreeBoundary {



	public static List<TreeNode> findBoundary(TreeNode root) {
		List<TreeNode>result = new ArrayList<>();
		traverseLeftTree(root, result);
		traverseLeaves(root, result);
		traverseRightTree(root.right, result);
		return result;
	}

	private static void traverseLeaves(TreeNode node, List<TreeNode>result) {

		if(node==null)
			return;

		traverseLeaves(node.left, result);

		if(node.left==null && node.right==null) 
			result.add(node);

		traverseLeaves(node.right, result);

	}


	private static void traverseLeftTree(TreeNode node, List<TreeNode>result) {

		if(node==null)
			return;

		if(node.left!=null) {
			result.add(node);
			traverseLeftTree(node.left, result);
		}else if(node.right!=null) {
			traverseLeftTree(node.right, result);
		}
	}

	private static void traverseRightTree(TreeNode node, List<TreeNode>result) {
		if(node==null)
			return;

		if(node.right!=null) {
			result.add(node);
			traverseLeftTree(node.right, result);
		}else if(node.left!=null) {
			traverseLeftTree(node.left, result);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(9);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(15);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(6);
		List<TreeNode> result = TreeBoundary.findBoundary(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}


}
