package com.data.structure.trees;

import com.patterns.tree.breadth.first.search.TreeNode;

public class InsertNode {

	public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        
        if(val <= root.val){
            root.left = insertIntoBST(root.left, val);
        }else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
