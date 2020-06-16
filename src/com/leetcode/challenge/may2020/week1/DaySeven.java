package com.leetcode.challenge.may2020.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.patterns.tree.breadth.first.search.TreeNode;

public class DaySeven {

	public boolean isCousins(TreeNode root, int x, int y) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		List<TreeNode> list = new ArrayList<TreeNode>();

		while(!queue.isEmpty()) {
			int size = queue.size();

			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();

				if(node.val==x || node.val==y) {
					list.add(node);
				}

				if(node.left!=null && node.right!=null) {
					if (node.left.val == x && node.right.val == y) { 
						return false;
					}
					if (node.left.val == y && node.right.val == x) { 
						return false;
					}
				}

				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
			if(list.size()==2) {
				return true;
			}
			list = new ArrayList<TreeNode>();
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(6);
		System.out.println(new DaySeven().isCousins(root, 4, 6));
	}

}
