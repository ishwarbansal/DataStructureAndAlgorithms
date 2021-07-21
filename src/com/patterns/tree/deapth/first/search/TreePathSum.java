package com.patterns.tree.deapth.first.search;

import java.util.ArrayList;
import java.util.List;

import com.patterns.tree.breadth.first.search.TreeNode;

public class TreePathSum {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		if(root==null)
			return result;

		hasPathSum(root, sum, list, result);

		return result;
	}

	public void hasPathSum(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {
		if(root==null)
			return;

		list.add(root.val);

		if(root.val==sum && root.left==null && root.right==null){
			result.add(new ArrayList(list));
		}else{        
			hasPathSum(root.left, sum-root.val, list, result);
			hasPathSum(root.right, sum-root.val, list, result);
		}
		list.remove(list.size()-1);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		new TreePathSum().pathSum(root, 22);
		//		System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
	}

}
