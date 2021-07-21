package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

/*Given two integer arrays preorder and inorder 
 * where preorder is the preorder traversal of a binary tree 
 * and inorder is the inorder traversal of the same tree, 
 * construct and return the binary tree.*/
public class ConstructBTFromPreInOrder {

	int index = 0;
	int[] preOrderList;
	int[] inOrderList;

	public void initilize(int[] preOrderList, int[] inOrderList) {
		this.preOrderList = preOrderList;
		this.inOrderList = inOrderList;
	}

	public TreeNode getTree(int start, int end) {
		if(start>end) {
			index--;
			return null;
		}

		TreeNode node = new TreeNode(preOrderList[index]);

		int i = start;

		while(inOrderList[i]!=preOrderList[index]) {
			i++;
		}
		++index;
		node.left = getTree(start, i-1);

		++index;
		node.right= getTree(i+1, end);

		return node;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		initilize(preorder, inorder);
		return getTree(0, inorder.length-1);
	}
	
	public static void main(String[] args) {
		ConstructBTFromPreInOrder obj = new ConstructBTFromPreInOrder();
		int[] preOrderList = new int[] {3,9,20,15,7};
		int[] inOrderList = new int[] {9,3,15,20,7};
		obj.initilize(preOrderList, inOrderList);
		TreeNode node = obj.getTree(0, preOrderList.length-1);
	}

}
