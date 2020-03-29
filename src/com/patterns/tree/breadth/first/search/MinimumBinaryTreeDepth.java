package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumBinaryTreeDepth {

	public static List<Integer> largestValue(TreeNode root) {
		List<Integer> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			int maxValue = Integer.MIN_VALUE;

			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();

				maxValue = Math.max(maxValue, currentNode.val);

				if(currentNode.left!=null)
					queue.offer(currentNode.left);
				if(currentNode.right!=null)
					queue.offer(currentNode.right);
			}

			result.add(maxValue);
		}

		return result;

	}

	public static int findMinDepth(TreeNode root) {

		int minimumDepth = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);

		while(!queue.isEmpty()) {
			int levelSize = queue.size();

			minimumDepth++;

			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();

				if(currentNode.left==null && currentNode.right==null)
					return minimumDepth;

				if(currentNode.left!=null)
					queue.offer(currentNode.left);
				if(currentNode.right!=null)
					queue.offer(currentNode.right);
			}

		}

		return minimumDepth;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);

		System.out.println("Minimum Depth : " + MinimumBinaryTreeDepth.findMinDepth(root));
		root.left.left = new TreeNode(9);
		root.right.left.left = new TreeNode(11);
		System.out.println("Minimum Depth : " + MinimumBinaryTreeDepth.findMinDepth(root));

		//	    System.out.println("Level wise Larget value : " + MinimumBinaryTreeDepth.largestValue(root));
		//	    root.left.left = new TreeNode(9);
		//	    root.right.left.left = new TreeNode(11);
		//	    System.out.println("Level wise Larget value : " + MinimumBinaryTreeDepth.largestValue(root));
	}

}
