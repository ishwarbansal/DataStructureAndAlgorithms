package com.data.structure.trees;

import java.util.HashMap;
import java.util.Map;

import com.patterns.tree.breadth.first.search.TreeNode;

/* 106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree 
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * 
 * */
public class ConstructBSTFromPostInOrder {

	int index = 0;
	int[] postOrderList;
	int[] inOrderList;
	Map<Integer,Integer> map = new HashMap<>();

	public void initialize(int[] inOrderList, int[] postOrderList) {
		this.postOrderList = postOrderList;
		this.inOrderList = inOrderList;
		this.index = postOrderList.length-1;
		for(int i=0;i<inOrderList.length;i++){
			map.put(inOrderList[i],i);
		}
	}

	public TreeNode getTree(int start, int end) {
		if(start>end) {
			index++;
			return null;
		}

		TreeNode node = new TreeNode(postOrderList[index]);

		int i = map.get(postOrderList[index]);

		--index;
		node.right= getTree(i+1, end);

		--index;
		node.left = getTree(start, i-1);

		return node;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		initialize(inorder, postorder);
		return getTree(0, inOrderList.length-1);
	}
	
	public static void main(String[] args) {
		int[] inOrderList = new int[] {9,3,15,20,7};
		int[] postOrderList = new int[] {9,15,7,20,3};
		
		ConstructBSTFromPostInOrder obj = new ConstructBSTFromPostInOrder();
		obj.initialize(inOrderList, postOrderList);
		TreeNode node = obj.getTree(0, postOrderList.length-1);
		System.out.println(node);
	}

}