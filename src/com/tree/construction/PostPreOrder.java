package com.tree.construction;

import java.util.HashMap;
import java.util.Map;

import com.patterns.tree.breadth.first.search.TreeNode2;

public class PostPreOrder {

	int index = 0;
	char[] preOrderList;
	char[] postOrderList;
	Map<Character,Integer> map = new HashMap<>();
	
	public PostPreOrder(char[] preOrderList, char[] postOrderList) {
		this.preOrderList = preOrderList;
		this.postOrderList = postOrderList;
		
        for(int i=0;i<preOrderList.length;i++){
            map.put(preOrderList[i],i);
        }
	}
	
	public TreeNode2 getTree(int start, int end) {
		TreeNode2 node = index>=preOrderList.length ? null :  new TreeNode2(postOrderList[index]);
		if(start>=end) {
			return node;
		}
		int i = map.get(postOrderList[index+1]);
		int j = map.get(postOrderList[index])-1;
		
		++index;
		node.left = getTree(start, i);
		
		++index;
		node.right= getTree(i+1, j);
		
		return node;
	}
	
	

	public static void main(String[] args) {
		char [] postOrderList = {'F','B','A','D','C','E','G','I','H'};
		char [] preOrderList = {'A','C','E','D','B','H','I','G','F'};
		
		TreeNode2 treeNode = new PostPreOrder(preOrderList, postOrderList).getTree(0, postOrderList.length-1);
		treeNode.printLevelOrder();

	}

}
