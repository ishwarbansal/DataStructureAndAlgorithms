package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelAverage {

	public static List<Double> findLevelAverages(TreeNode root) {
		List<Double> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int levelSize = queue.size();
			Double levelValues = 0.0;
			
			for(int i=0; i<levelSize; i++) {
				TreeNode currentNode = queue.poll();
				
				levelValues = levelValues + currentNode.val;
				
				if(currentNode.left!=null)
					queue.offer(currentNode.left);
				if(currentNode.right!=null)
					queue.offer(currentNode.right);
			}

			result.add(levelValues/levelSize);
		}
		
		return result;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.left.right = new TreeNode(2);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		List<Double> result = LevelAverage.findLevelAverages(root);
		System.out.println("Level of average: " + result);
	}
}
