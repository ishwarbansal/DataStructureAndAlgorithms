package com.data.structure.linked.list;

import com.patterns.fast.slow.pointers.ListNode;

/* Delete Node: Implement an algorithm to delete a node in the middle(i.e. any node
*  but the first and last node, not necessarily the exact middle) of a singly linked list, 
*  given only access to that node.
*
*  Example
*  Input: the node c from the linked list a -> b -> c -> -> d -> e -> f
*  Result: nothing is returned, but the new linked list looks like a -> b -> d -> e -> f
*/
public class DeleteMiddleNode {

	/*
	 * In this problem, you are not given access to the head of the linked list. You only havve access to that node.
	 * The solution is simply to copy the data from the next node over to the current node, and then to delete the next node.
	 * 
	 */
	boolean deleteNode(ListNode node) {
		if(node==null || node.next ==null) {
			return false; // failure
		}
		
		ListNode next = node.next;
		node.value = next.value;
		node.next = next.next;
		return true;
	
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(8);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(16);
		node.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next = new ListNode(7);
		ListNode middleNode = node.next.next.next.next.next;
		node.next.next.next.next.next.next = new ListNode(1);
		node.next.next.next.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next.next.next.next.next = new ListNode(0);
		
		DeleteMiddleNode obj = new DeleteMiddleNode();
		System.out.println(obj.deleteNode(middleNode));
		
		while(node!=null) {
			System.out.println(node.value);
			node = node.next;
		}
	}

}
