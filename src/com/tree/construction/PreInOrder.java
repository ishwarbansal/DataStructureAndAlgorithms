package com.tree.construction;

import com.patterns.tree.breadth.first.search.TreeNode;

public class PreInOrder {

	int index = 0;
	int[] preOrderList;
	int[] inOrderList;
	
	public PreInOrder(int[] preOrderList, int[] inOrderList) {
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
	
	

	public static void main(String[] args) {
		int [] preOrderList = {1,2,4,8,9,10,11,5,3,6,7};
		int [] inOrderList = {8,4,10,9,11,2,5,1,6,3,7};
		
		TreeNode treeNode = new PreInOrder(preOrderList, inOrderList).getTree(0, inOrderList.length-1);

	}

}
