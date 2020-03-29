package com.patterns.tree.deapth.first.search;

import com.patterns.tree.breadth.first.search.TreeNode;

public class SumOfPathNumbers {

	static int sum = 0;
	static String levelWiseSum = "";
	public static int findSumOfPathNumbers(TreeNode root) {

		if(root==null)
			return 0;
		
		if(root.left==null && root.right==null) {
//			levelWiseSum = levelWiseSum + root.val;
			sum = sum + Integer.parseInt(levelWiseSum) + root.val;
//			levelWiseSum = levelWiseSum.substring(0, levelWiseSum.length()-1);
		}
		
		levelWiseSum = levelWiseSum + root.val;		

		findSumOfPathNumbers(root.left);
		findSumOfPathNumbers(root.right);
		
		levelWiseSum = levelWiseSum.substring(0, levelWiseSum.length()-1);
		
		return sum;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(1);
//		root.left.left = new TreeNode(1);
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(5);
		
		root.left = new TreeNode(7);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(9);

		
		System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
	}


}
