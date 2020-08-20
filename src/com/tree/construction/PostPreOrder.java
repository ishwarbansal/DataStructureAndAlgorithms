package com.tree.construction;

import java.util.HashMap;
import java.util.Map;

import com.patterns.sliding.window.TreeNode;

public class PostPreOrder {

	int index = 0;
	int[] preOrderList;
	int[] postOrderList;
	Map<Integer,Integer> map = new HashMap<>();

	public void initialize(int[] preOrderList, int[] postOrderList) {
		this.preOrderList = preOrderList;
		this.postOrderList = postOrderList;

		for(int i=0;i<postOrderList.length;i++){
			map.put(postOrderList[i],i);
		}
	}

	public TreeNode getTree(int start, int end) {
		TreeNode node = index>=postOrderList.length ? null :  new TreeNode(preOrderList[index]);
		if(start>=end) {
			return node;
		}
		int i = map.get(preOrderList[index+1]);
		int j = map.get(preOrderList[index])-1;

		++index;
		node.left = getTree(start, i);

		++index;
		node.right= getTree(i+1, j);

		return node;
	}	

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		initialize(pre, post);
		TreeNode root = getTree(0, post.length-1);
		return root;
	}

	public static void main(String[] args) {
		int [] preOrderList = {3,4,1,2};
		int [] postOrderList = {1,4,2,3};
		PostPreOrder postPreOrder = new PostPreOrder();
		postPreOrder.constructFromPrePost(preOrderList, postOrderList);

	}

}
