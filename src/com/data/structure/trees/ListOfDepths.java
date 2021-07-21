package com.data.structure.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.patterns.tree.breadth.first.search.TreeNode;

/*List of Depths
 * 
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth 
 * (e.g., if you have a tree with depth D, you'll have D linked lists).
 * 
 * 
 * Both DFS and BFS will take O(n).
 * 
 * */

public class ListOfDepths {

	/*
	 * We can implement pre-order traversal algorithm, where we pass in level + 1 to the next recursive call.
	 * The code below provides an implementation using Depth-first search.
	 * */
	public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
		if(root==null)
			return;

		LinkedList<TreeNode> list = null;

		if(lists.size()==level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		}else {
			list = lists.get(level);
		}

		list.add(root);

		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);

	}


	/*
	 * Breadth-first search. With this implementation, we want to iterate through the root first, 
	 * then level 2, level 3 and so on.
	 * 
	 * */
	public void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists) {
		if(root==null)
			return;

		LinkedList<TreeNode> list = null;

		Queue<TreeNode> queue = new LinkedList<>();

		if(root!=null)
			queue.add(root);

		while(!queue.isEmpty()) {
			int size = queue.size();
			list = new LinkedList<>();
			for(int i=0; i<size; i++) {
				TreeNode node = queue.poll();
				list.add(node);

				if(node.left!=null)
					queue.add(node.left);

				if(node.right!=null)
					queue.add(node.right);
			}
			lists.add(list);
		}
	}

	public static void main(String[] args) {
		ListOfDepths obj = new  ListOfDepths();
		TreeNode root = new TreeNode(15);
		root.left = new TreeNode(9);
		root.right = new TreeNode(18);

		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(17);
		root.right.right = new TreeNode(20);

		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		obj.createLevelLinkedList(root, lists, 0);

		for(LinkedList<TreeNode> list : lists) {
			for(TreeNode node : list) {
				System.out.print(node.val + " -- ");
			}
			System.out.println("------------------");
		}
	}

}
