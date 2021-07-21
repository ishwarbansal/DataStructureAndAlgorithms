package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagTraversal {
	public static List<List<Integer>> traverse(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root==null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean leftToRight = true;
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();

				if(leftToRight) {
					levelList.add(node.val);
				}else {
					levelList.add(0, node.val);
				}

				addNode(node.left, queue);
				addNode(node.right, queue);
			}
			leftToRight=!leftToRight;
			result.add(levelList);
		}

		return result;
	}

	private static void addNode(TreeNode node, Queue<TreeNode> queue) {
		if(node!=null)
			queue.add(node);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(17);
		List<List<Integer>> result = ZigzagTraversal.traverse(root);
		System.out.println("Zigzag traversal: " + result);
	}
}
