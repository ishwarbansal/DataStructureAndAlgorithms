package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumBinaryTreeDepth {
	
	public static int findDepth(TreeNode root) {
		if(root==null)
			return 0;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int depth = 1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();

				if(node.left==null && node.right==null)
					return depth;
				
				if(node.left!=null)
					queue.add(node.left);
				
				if(node.right!=null)
					queue.add(node.right);
			}
			
			depth++;
		}

		return depth;
		
	  }
	 
	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	    root.left.left = new TreeNode(9);
	    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
	  }
}
