package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

public class DeleteNode {

	public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return root;
        }else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }else if (key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left==null && root.right==null){
                root=null;
            }else if (root.left==null){
                root = root.right;
            }else if (root.right==null){
                root = root.left;                
            }else{
            	/*
            	 * Choose either in-order predecessor or in-order successor.
            	 * In-Order predecessor means from left subtree, node having maximum value.
            	 * In-Order successor means from right subtree, node having minimum value.
            	 * */
                int val = findMin(root.right);
                root.val = val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    public int findMin(TreeNode node){
        TreeNode current = node;
        
        while(node!=null){
            if(node.val<current.val)
                current = node;
            node = node.left == null ? node.right : node.left;
        }
        return current.val;
    }
    
}
