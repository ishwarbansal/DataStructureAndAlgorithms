package com.patterns.tree.breadth.first.search;

public class TreeNode2 {

	public char val;
	public TreeNode2 left;
	public TreeNode2 right;
	public TreeNode2 next;

	public TreeNode2(char val) {
		this.val = val;
	}

	// level order traversal using 'next' pointer
	public void printLevelOrder() {
		TreeNode2 nextLevelRoot = this;
		while (nextLevelRoot != null) {
			TreeNode2 current = nextLevelRoot;
			nextLevelRoot = null;
			while (current != null) {
				System.out.print(current.val + " ");
				if (nextLevelRoot == null) {
					if (current.left != null)
						nextLevelRoot = current.left;
					else if (current.right != null)
						nextLevelRoot = current.right;
				}
				current = current.next;
			}
			System.out.println();
		}
	};

	// tree traversal using 'next' pointer
	public void printTree() {
		TreeNode2 current = this;
		System.out.print("Traversal using 'next' pointer: ");
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.next;
		}
	}




}
