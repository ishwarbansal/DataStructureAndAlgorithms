package com.patterns.tree.breadth.first.search;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {

	public static void connect(TreeNode root) {
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.offer(root);
	    TreeNode previousNode = null;
	    
	    while(!queue.isEmpty()) {
	    	TreeNode currentNode = queue.poll();
	    	if(previousNode!=null)
	    		previousNode.next = currentNode;
	    	previousNode = currentNode;
	    	
	    	
	    	if(currentNode.left!=null)
	    		queue.offer(currentNode.left);
	    	
	    	if(currentNode.right!=null)
	    		queue.offer(currentNode.right);
	    }
	    
	  }

	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(12);
	    root.left = new TreeNode(7);
	    root.right = new TreeNode(1);
	    root.left.left = new TreeNode(9);
	    root.right.left = new TreeNode(10);
	    root.right.right = new TreeNode(5);
	    ConnectAllSiblings.connect(root);

	    // level order traversal using 'next' pointer
	    TreeNode current = root;
	    System.out.println("Traversal using 'next' pointer: ");
	    while (current != null) {
	      System.out.print(current.val + " ");
	      current = current.next;
	    }
	  
	  }
}
