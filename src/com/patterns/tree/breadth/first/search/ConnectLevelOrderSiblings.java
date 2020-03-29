package com.patterns.tree.breadth.first.search;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {


	public static void connect(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levelSize = queue.size();

			TreeNode currentNode = null;
			
			for (int i = 0; i < levelSize; i++) {
				TreeNode nextNode = queue.poll();
			
				if(currentNode!=null)
					currentNode.next = nextNode;
				
				currentNode = nextNode;
				
				// insert the children of current node in the queue
				if (currentNode.left != null)
					queue.offer(currentNode.left);
				if (currentNode.right != null)
					queue.offer(currentNode.right);
			}
			currentNode.next = null;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		ConnectLevelOrderSiblings.connect(root);
		System.out.println("Level order traversal using 'next' pointer: ");
		root.printLevelOrder();
	}


}
