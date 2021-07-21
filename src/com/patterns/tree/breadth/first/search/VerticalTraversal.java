package com.patterns.tree.breadth.first.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalTraversal {
	
	Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
	
	public List<List<Integer>> verticalTraversal(TreeNode node) {
		List<List<Integer>> list = new ArrayList<>();
		
		treeView(node, 0, 0);
		
		for(TreeMap<Integer, List<Integer>> cols : map.values()) {
			List<Integer> subList = new ArrayList<>();
			for(List<Integer> levelValues : cols.values()) {
				if(levelValues.size()==1)
					subList.add(levelValues.get(0));
				else {
					Collections.sort(levelValues);
					for(int val : levelValues)
						subList.add(val);
				}
			}
			list.add(subList);
		}
		
		return list;
	}
	
	public void treeView(TreeNode node, int row, int col) {
		if(node==null)
			return;
		
		storeValue(node, row, col);
		
		treeView(node.left, row+1, col-1);
		treeView(node.right, row+1, col+1);
		
	}

	private void storeValue(TreeNode node, int row, int col) {
		
		if(map.get(col)==null) {
			map.put(col, new TreeMap<>());
		}
		
		if(map.get(col).get(row)==null) {
			map.get(col).put(row, new ArrayList<>());
		}
		
		map.get(col).get(row).add(node.val);
	}
	
	public static void main(String[] args) {
		VerticalTraversal traversal = new VerticalTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		traversal.verticalTraversal(root);
		
	}

}
