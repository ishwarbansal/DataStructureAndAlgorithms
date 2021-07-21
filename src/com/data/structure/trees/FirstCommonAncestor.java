package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

public class FirstCommonAncestor {

	/*	236. Lowest Common Ancestor of a Binary Tree
	Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
	According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined 
	between two nodes p and q as the lowest node in T that has both p and q as descendants 
	(where we allow a node to be a descendant of itself).

	Example 1:
	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
	Output: 3
	Explanation: The LCA of nodes 5 and 1 is 3.

	Example 2:
	Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
	Output: 5
	Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

	Example 3:
	Input: root = [1,2], p = 1, q = 2
	Output: 1

	Constraints:
	The number of nodes in the tree is in the range [2, 105].
	-109 <= Node.val <= 109
	All Node.val are unique.
	p != q
	p and q will exist in the tree.
	 */	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//Error check - one node is not in the tree;
		if(!covers(root, p) || !covers(root, q))
			return null;
		
		return ancestorHelper(root, p, q);
	}

	TreeNode ancestorHelper (TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q)
			return root;
		
		boolean pIsOnLeft = covers(root.left, p);
		boolean qIsOnLeft = covers(root.left, q);
		
		//Nodes are on different side
		if(pIsOnLeft != qIsOnLeft)
			return root;
		
		TreeNode childSide = pIsOnLeft ? root.left : root.right;
		return ancestorHelper(childSide, p, q);
		
	}
	
	boolean covers(TreeNode root, TreeNode p) {
		if(root==null)
			return false;

		if(root == p)
			return true;
		
		return covers(root.left, p) || covers(root.right, p);
	}
	
	public static void main(String[] args) {
		FirstCommonAncestor obj = new FirstCommonAncestor();
		TreeNode root = new TreeNode(3);
		
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		
		TreeNode result = obj.lowestCommonAncestor(root, p, q);
		System.out.println(result.val);
	}
	
	


}
