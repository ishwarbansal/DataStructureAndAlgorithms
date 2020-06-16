package com.patterns.tree.deapth.first.search;

import java.util.List;

import com.patterns.tree.breadth.first.search.TreeNode;

public class TreeDiameter {

	static int levelWiseHeightSum = 0;

	public static int findDiameter(TreeNode root, int pathLevel, List<Integer> pathLevelArr) {

		if (root==null)
			return 0;

		if(root.left==null && root.right==null) {
			pathLevelArr.add(pathLevel);
			if(pathLevelArr.size()>2) {
				int first = Integer.MIN_VALUE;
				int second = Integer.MIN_VALUE;

				for (int i = 0; i <pathLevelArr.size() ; i ++) 
				{ 
					/* If current element is greater than 
	            first*/
					if (pathLevelArr.get(i) > first) 
					{ 
						second = first; 
						first = pathLevelArr.get(i); 
					} 
					/* If arr[i] is in between first and 
	            second then update second  */
					else if (pathLevelArr.get(i) > second) 
					{ 
						second = pathLevelArr.get(i); 
					} 
				}

				levelWiseHeightSum = first + second;
				
				System.out.println("first "+ first);
				System.out.println("second "+ second);

			}
		}

		findDiameter(root.left, pathLevel+1, pathLevelArr);
		findDiameter(root.right, pathLevel + 1, pathLevelArr);

		return levelWiseHeightSum;
	}

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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameterDoc(root));
//		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root, 1, new ArrayList<Integer>()));

		root.left.left = null;
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.right.left = new TreeNode(9);
		root.right.left.right.left = new TreeNode(10);
		root.right.right.left.left = new TreeNode(11);
//		System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root, 1, new ArrayList<Integer>()));
		System.out.println("Tree Diameter: " + TreeDiameter.findDiameterDoc(root));
	}

}
