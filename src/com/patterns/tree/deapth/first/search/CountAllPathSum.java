package com.patterns.tree.deapth.first.search;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.patterns.tree.breadth.first.search.TreeNode;

public class CountAllPathSum {

	static int[] pathLevelArr= new int[3];
	static int countTargetSum = 0;

	public static int countPaths(TreeNode root, int targetSum, int pathLevel) {

		if (root==null)
			return 0;

		pathLevelArr[pathLevel] = root.val;

		int index = pathLevelArr.length-1;
		int pathLevelSum = 0;
		while (index >=0 && pathLevelSum < targetSum) {
			pathLevelSum = pathLevelSum + pathLevelArr[index--]; 
		}

		if(pathLevelSum == targetSum)
			countTargetSum++;

		countPaths(root.left, targetSum, pathLevel+1);
		countPaths(root.right, targetSum, pathLevel+1);

		pathLevelArr = removeElement(pathLevelArr, pathLevel);

		return countTargetSum;
	}
	public static int countPaths2(TreeNode root, int S) {
		List<Integer> currentPath = new LinkedList<>();
		return countPathsRecursive(root, S, currentPath);
	}


	private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
		if (currentNode == null)
			return 0;

		// add the current node to the path
		currentPath.add(currentNode.val);
		int pathCount = 0, pathSum = 0;
		// find the sums of all sub-paths in the current path list
		ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
		while (pathIterator.hasPrevious()) {
			pathSum += pathIterator.previous();
			// if the sum of any sub-path is equal to 'S' we increment our path count.
			if (pathSum == S) {
				pathCount++;
			}
		}

		// traverse the left sub-tree
		pathCount += countPathsRecursive(currentNode.left, S, currentPath);
		// traverse the right sub-tree
		pathCount += countPathsRecursive(currentNode.right, S, currentPath);

		// remove the current node from the path to backtrack, 
		// we need to remove the current node while we are going up the recursive call stack.
		currentPath.remove(currentPath.size() - 1);

		return pathCount;
	}


	public static int[] removeElement(int[] arr, int endIndex) {
		int[] newArr = new int[arr.length];

		for(int i=0; i<endIndex; i++)
			newArr[i] = arr[i];

		return newArr;

	}

	public static void main(String[] args) {
		//		TreeNode root = new TreeNode(12);
		//		root.left = new TreeNode(7);
		//		root.right = new TreeNode(1);
		//		root.left.left = new TreeNode(4);
		//		root.right.left = new TreeNode(10);
		//		root.right.right = new TreeNode(5);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(3);

		System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 12, 0));
		
		System.out.println("Tree has path: " + CountAllPathSum.countPaths2(root, 12));
	}

}
