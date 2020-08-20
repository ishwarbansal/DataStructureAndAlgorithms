package com.tree.construction;

import com.patterns.sliding.window.TreeNode;

public class PreInOrder {

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
		int [] preorder = {1,2,4,8,9,10,11,5,3,6,7};
		int [] inorder = {8,4,10,9,11,2,5,1,6,3,7};

		PreInOrder preInOrder = new PreInOrder();
		preInOrder.buildTree(preorder, inorder);
	}

}
