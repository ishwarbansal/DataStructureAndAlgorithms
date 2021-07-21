package com.patterns.tree.breadth.first.search;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
	public static TreeNode findSuccessor(TreeNode root, int key) {
		if(root==null)
			return null;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();

			if(currentNode.left!=null)
				queue.add(currentNode.left);

			if(currentNode.right!=null)
				queue.add(currentNode.right);

			if(currentNode.val==key)
				return queue==null?null :queue.peek();

		}

		return null;    
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 9);
		System.out.println("Level Order Successor " + result.val);

	}
}
