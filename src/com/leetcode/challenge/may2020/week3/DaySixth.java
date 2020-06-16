package com.leetcode.challenge.may2020.week3;

import com.patterns.tree.breadth.first.search.TreeNode;

public class DaySixth {

	boolean found  = false;

	public int kthSmallest(TreeNode root, int k) {
		int level = 0;
		int result = 0;

		if(root==null) 
			return k;

		if(!found) {
			level = kthSmallest(root.left, k);
			result = level;
		}

		if(!found) {
			if(level-1==0) {
				found = true;
				return root.val;
			}
		}

		if(!found) {
			level = kthSmallest(root.right, level-1);
			result = level;
		}
		return result;
	}

	public static void main(String[] args) {
		DaySixth daySixth = new DaySixth();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		
		System.out.println(daySixth.kthSmallest(root, 1));
	}
}
