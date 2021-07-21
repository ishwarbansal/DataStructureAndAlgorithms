package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {
	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<>();
		
		if(root==null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			double sum= 0;

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();

				sum+=node.val;

				addNode(node.left, queue);
				addNode(node.right, queue);
			}
			result.add(sum/size);
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
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> list = new LevelAverage().findLevelAverages(root);
		System.out.println("Level Average "+list);
	}
}
