package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {

	public static List<TreeNode> traverse(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();
			TreeNode currentNode = null;
			for (int i = 0; i < levelSize; i++) {
				currentNode = queue.poll();
				
				// insert the children of current node in the queue
				if (currentNode.left != null) 
					queue.offer(currentNode.left);

				if (currentNode.right != null) 
					queue.offer(currentNode.right);
			}
			result.add(new TreeNode(currentNode.val));
		}

		return result;
	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(12);
//		root.left = new TreeNode(7);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(9);
//		root.right.left = new TreeNode(10);
//		root.right.right = new TreeNode(5);
//		root.left.left.left = new TreeNode(3);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		List<TreeNode> result = RightViewTree.traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}


}
