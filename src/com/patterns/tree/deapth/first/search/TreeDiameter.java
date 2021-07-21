package com.patterns.tree.deapth.first.search;

import com.patterns.tree.breadth.first.search.TreeNode;

public class TreeDiameter {

	static int treeDiameter = 0;
	
	public static int findDiameterDoc(TreeNode root) {
		calculateHight(root);
		return treeDiameter;
	}

	private static int calculateHight(TreeNode root) {
		if (root==null)
			return 0;

		int leftTreeHeight = calculateHight(root.left);
		int rightTreeHeight = calculateHight(root.right);
		
		int diameter = leftTreeHeight + rightTreeHeight + 1;
		
		treeDiameter = Math.max(treeDiameter, diameter);
		
		return Math.max(leftTreeHeight, rightTreeHeight) + 1; 
				
	}


	public static void main(String[] args) {
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(3);
//		root.left.left = new TreeNode(4);
//		root.right.left = new TreeNode(5);
//		root.right.right = new TreeNode(6);
////		System.out.println("Tree Diameter: " + TreeDiameter.findDiameterDoc(root));
////		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root, 1, new ArrayList<Integer>()));
//
//		root.left.left = null;
//		root.right.left.left = new TreeNode(7);
//		root.right.left.right = new TreeNode(8);
//		root.right.right.left = new TreeNode(9);
//		root.right.left.right.left = new TreeNode(10);
//		root.right.right.left.left = new TreeNode(11);
////		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root, 1, new ArrayList<Integer>()));
//		System.out.println("Tree Diameter: " + TreeDiameter.findDiameterDoc(root));
		
		
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		root.right.right.right = new TreeNode(9);
		
		root.left.right.right.right = new TreeNode(10);
		
		root.right.right.right.right = new TreeNode(11);

		System.out.println("Tree Diameter: " + TreeDiameter.findDiameterDoc(root));
	}

}
