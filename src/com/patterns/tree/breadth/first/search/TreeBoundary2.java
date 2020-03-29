package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBoundary2 {

	public static List<TreeNode> findBoundary(TreeNode root) {
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
				
				
				if(i==0 || i==levelSize-1) {
					result.add(currentNode);
				}else if(currentNode.left==null && currentNode.right==null){
					result.add(currentNode);
				}
				
			}

		}

		return result;
	}

	public static void main(String[] args) {

//		TreeNode root = new TreeNode(12);
//	    root.left = new TreeNode(7);
//	    root.right = new TreeNode(1);
//	    root.left.left = new TreeNode(4);
//	    root.left.left.left = new TreeNode(9);
//	    root.left.right = new TreeNode(3);
//	    root.left.right.left = new TreeNode(15);
//	    root.right.left = new TreeNode(10);
//	    root.right.right = new TreeNode(5);
//	    root.right.right.left = new TreeNode(6);
		
//		TreeNode root = new TreeNode(12);
//	    root.right = new TreeNode(1);
//	    root.right.left = new TreeNode(10);
//	    root.right.right = new TreeNode(5);
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(10);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.right = new TreeNode(11);
		
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(12);
		root.right.right.right = new TreeNode(13);
		
	    
	    List<TreeNode> result = TreeBoundary2.findBoundary(root);
	    for (TreeNode node : result) {
	      System.out.print(node.val + " ");
	    }
	  }
}
