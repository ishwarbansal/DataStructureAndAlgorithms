package com.patterns.tree.deapth.first.search;

import java.util.ArrayList;
import java.util.List;

import com.patterns.tree.breadth.first.search.TreeNode;

public class FindAllTreePaths {

	List<List<Integer>> allPaths = new ArrayList<>();

	public void findPaths(TreeNode root, List<Integer> path, int sum) {

		if(root==null)
			return;

		if(root.left==null && root.right==null) {
			if(sum==root.val) {
				List<Integer> pathClone =  new ArrayList<Integer>(path);
				pathClone.add(root.val);
				allPaths.add(pathClone);
			}
			return;
		}

		path.add(root.val);

		findPaths(root.left, path, sum-root.val);
		findPaths(root.right, path, sum-root.val);

		path.remove(path.indexOf(root.val));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(7);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(9);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(5);
		
		FindAllTreePaths allTreePaths = new FindAllTreePaths();
		allTreePaths.findPaths(root, new ArrayList<Integer>(), 28);
		
		System.out.println(allTreePaths.allPaths);
	}
}
