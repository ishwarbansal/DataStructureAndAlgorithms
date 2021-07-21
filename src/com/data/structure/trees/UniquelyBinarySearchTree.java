package com.data.structure.trees;

public class UniquelyBinarySearchTree {

	/*96. Unique Binary Search Trees
	Given an integer n, return the number of structurally unique BST's (binary search trees) 
	which has exactly n nodes of unique values from 1 to n.

	Example 1:
	Input: n = 3
	Output: 5

	Example 2:
	Input: n = 1
	Output: 1

	Constraints:
	1 <= n <= 19*/

	public int numTrees(int n) {
		int countArr[] = new int[n+1];
		countArr[0]=1;
		countArr[1]=1;
		
		for(int i=2; i<=n; i++) {
			for(int j=0; j<i; j++) {
				countArr[i]+=countArr[j] * countArr[i-j-1];
			}
		}
		return countArr[n];
	}

	public static void main(String[] args) {
		UniquelyBinarySearchTree obj = new UniquelyBinarySearchTree();
		System.out.println(obj.numTrees(4));
	}
}
