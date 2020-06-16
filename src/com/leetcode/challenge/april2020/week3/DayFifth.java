package com.leetcode.challenge.april2020.week3;

import java.util.ArrayList;
import java.util.List;

import com.patterns.tree.breadth.first.search.TreeNode;

public class DayFifth {


	public TreeNode bstFromPreorder2(int[] preorder) {
		return helper(preorder, 0, preorder.length - 1);   
	}

	private TreeNode helper(int[] preorder, int start, int end) {
		if(start > end) return null;

		TreeNode node = new TreeNode(preorder[start]);
		int i;
		for(i=start;i<=end;i++) {
			if(preorder[i] > node.val)
				break;
		}

		node.left = helper(preorder, start+1, i-1);
		node.right = helper(preorder, i, end);
		return node;



	}

	public TreeNode bstFromPreorder(int[] preorder) {
		if(preorder.length==0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		TreeNode root = new TreeNode(preorder[0]);
		for(int i=0; i<preorder.length; i++) {
			list.add(preorder[i]);
		}

		return makeTree(list, root);
	}

	public TreeNode makeTree(List<Integer> list, TreeNode root){

		if(list.size()==1) {
			return new TreeNode(list.get(0));
		}else {

			list.remove(0);

			List<Integer> leftSubList = new ArrayList<Integer>();
			List<Integer> rightSubList = new ArrayList<Integer>();

			for(int val : list) {
				if(val > root.val)
					rightSubList.add(val);
				else
					leftSubList.add(val);
			}

			TreeNode leftTree = null;
			TreeNode rightTree = null;

			if(leftSubList.size()>0)
				leftTree = makeTree(leftSubList, new TreeNode(leftSubList.get(0)));
			if(rightSubList.size()>0)
				rightTree = makeTree(rightSubList, new TreeNode(rightSubList.get(0)));

			root.left = leftTree;
			root.right = rightTree;
		}
		return root;
	}

	public static void main(String[] args) {
		DayFifth dayFifth = new DayFifth();
		TreeNode treeNode = dayFifth.bstFromPreorder2(new int[] {8,5,1,7,10,12});
		//		TreeNode treeNode = dayFifth.bstFromPreorder(new int[] {4,10,7,9,11});
		System.out.println(treeNode.val);
	}
}

