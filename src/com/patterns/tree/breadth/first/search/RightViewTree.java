package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewTree {

	public static List<TreeNode> traverse(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			TreeNode rightNode = null;
			for(int i=0; i<size; i++) {
				rightNode = queue.poll();

				if(rightNode.left!=null)
					queue.add(rightNode.left);
				
				if(rightNode.right!=null)
					queue.add(rightNode.right);
			}
			
			result.add(rightNode);
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
		root.left.left.left = new TreeNode(3);
		List<TreeNode> result = RightViewTree.traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
		System.out.println("");
		
		root.right.right.left = new TreeNode(4);
		result = RightViewTree.traverse(root);
		for (TreeNode node : result) {
			System.out.print(node.val + " ");
		}
	}


}
