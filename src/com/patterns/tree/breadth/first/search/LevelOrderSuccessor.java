package com.patterns.tree.breadth.first.search;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

	public static TreeNode findSuccessor(TreeNode root, int key) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();

			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				// insert the children of current node in the queue
				if (currentNode.left != null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right != null) {
					queue.offer(currentNode.right);
				}
				if(currentNode.val==key)
					return queue.poll();

			}

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
		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
		System.out.println("Successor " + result.val);

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.left.right = new TreeNode(5);
//		TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
//		System.out.println("Successor " + result.val);
	}
}
