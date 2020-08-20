package com.tree.construction;

import java.util.HashMap;
import java.util.Map;

import com.patterns.sliding.window.TreeNode;

public class PostInOrder {

	int index = 0;
	int[] postOrderList;
	int[] inOrderList;
	Map<Integer,Integer> map = new HashMap<>();
	
	public PostInOrder(int[] postOrderList, int[] inOrderList) {
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
	
	

	public static void main(String[] args) {
		int [] postOrderList = {9,1,2,12,7,5,3,11,4,8};
		int [] inOrderList = {9,5,1,7,2,12,8,4,3,11};
		
		TreeNode treeNode = new PostInOrder(postOrderList, inOrderList).getTree(0, inOrderList.length-1);
		System.out.println(treeNode);

	}

}
