package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

import com.patterns.sliding.window.TreeNode;

public class UniqueTrees {

	public List<TreeNode> findUniqueTrees(int n) {
		if(n==1) {
			List<TreeNode> treeList = new ArrayList<TreeNode>();
			treeList.add(new TreeNode(n));
			return treeList;
		}
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		return makeTree(list);
	}

	public List<TreeNode> makeTree(List<Integer> list){
		List<TreeNode> result = new ArrayList<>();
		for(int i=0; i<list.size(); i++) {
			if(list.size()==2) {
				if(i==0) {
					result.add(getTree(list.get(i), list.get(i+1)));
					result.add(getTree(list.get(i+1), list.get(i)));
				}
			}else {
				List<Integer> subList = new ArrayList<Integer>(list);
				subList.remove(i);
				List<TreeNode> subTree = makeTree(subList);
				for(TreeNode subNode : subTree) {
					if(subNode.val < list.get(i)) {
						int subNodeVal = subNode.left!=null?subNode.left.val:subNode.right.val;
						if(subNodeVal < list.get(i)) {
							TreeNode node = new TreeNode(list.get(i));
							node.left = subNode;
							result.add(node);
						}
					}else {
						int subNodeVal = subNode.left!=null?subNode.left.val:subNode.right.val;
						if(subNodeVal > list.get(i)) {
							TreeNode node = new TreeNode(list.get(i));
							node.right = subNode;
							result.add(node);
						}
					}
				}
			}
		}
		return result;
	}

	public static TreeNode getTree(int val1, int val2) {
		TreeNode treeNode = new TreeNode(val1);

		if(val1>val2)
			treeNode.left = new TreeNode(val2);
		else
			treeNode.right = new TreeNode(val2);

		return treeNode;
	}


	public static void main(String[] args) {
		UniqueTrees trees = new UniqueTrees();
		List<TreeNode> result = trees.findUniqueTrees(3);
		System.out.print("Total trees: " + result.size());
		System.out.println("");

		int i=1;
		for(TreeNode treeNode : result) {
			System.out.println("Tree "+ i++);
			System.out.println("Value " +treeNode.val);

			while(treeNode!=null) {
				if(treeNode.left!=null) {
					System.out.println("Left Value "+ treeNode.left.val);
					treeNode = treeNode.left;
				}
				else if (treeNode.right!=null) {
					System.out.println("Right Value "+ treeNode.right.val);
					treeNode = treeNode.right;
				}else {
					break;
				}
			}
			System.out.println("----------------");
		}
	}

}
