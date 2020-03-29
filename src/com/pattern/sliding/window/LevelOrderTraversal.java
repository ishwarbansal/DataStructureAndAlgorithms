package com.pattern.sliding.window;

import java.util.ArrayList;
import java.util.List;

class LevelOrderTraversal {
	static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static List<List<Integer>> traverse(TreeNode root) {
		if(root==null) {
			return result;
		}
		List<Integer> list= new ArrayList<Integer>();
		list.add(root.val);
		result.add(list);
		List<TreeNode> rootNode = new ArrayList<TreeNode>();
		rootNode.add(root);
		getElements(rootNode);
		return result;
	}

	//Ishwar
	private static void getElements(List<TreeNode> root) {
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();

		for(TreeNode treeNode : root) {
			if(root!=null) {
				if(treeNode.left != null) {
					list.add(treeNode.left.val);
					treeNodes.add(treeNode.left);
				}
				if(treeNode.right != null) {
					list.add(treeNode.right.val);
					treeNodes.add(treeNode.right);
				}
			}
		}
		if(list.size()>0) {
			result.add(list);
			getElements(treeNodes);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(6);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(4);
		root.right.right.right = new TreeNode(3);
		List<List<Integer>> result = LevelOrderTraversal.traverse(root);
		System.out.println("Level order traversal: " + result);
	}
}
