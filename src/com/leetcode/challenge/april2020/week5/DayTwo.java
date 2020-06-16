package com.leetcode.challenge.april2020.week5;

import com.patterns.sliding.window.TreeNode;

public class DayTwo {

	public boolean isValidSequence(TreeNode root, int[] arr) {
		if(root ==null)
			return arr.length==0;
		
		return isValid(root, arr, 0);
	}
	
	public boolean isValid (TreeNode root, int[] arr, int index) {
		if(root.val!=arr[index])
			return false;
		
		if(index == arr.length-1) 
			return root.left==null && root.right ==null;
		
		return 	(root.left!=null && isValid(root.left, arr, index+1))
					||
					(root.right!=null && isValid(root.right, arr, index+1))
				;
		
	}
	public static void main(String[] args) {
		DayTwo dayTwo = new DayTwo();
		int[] arr = {2,9,1,8,0};
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(9);
		
		root.right = new TreeNode(3);
		
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(2);
		root.left.left.left.left = new TreeNode(8);
		
		System.out.println(dayTwo.isValidSequence(root, arr));
//		System.out.println(dayTwo.isValidSequence(root, new int[] {0,1,0,1}));
//		System.out.println(dayTwo.isValidSequence(root, new int[] {0,1,1}));
	}

}
