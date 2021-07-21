package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
	public static List<List<Integer>> traverse(TreeNode root) {
		LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

		if(root==null)
			return result;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();
			
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				levelList.add(node.val);
				
				if(node.left!=null)
					queue.add(node.left);
				
				if(node.right!=null)
					queue.add(node.right);
			}
			
			result.addFirst(levelList);
		}
		
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
		System.out.println("Reverse level order traversal: " + result);
	}
}

