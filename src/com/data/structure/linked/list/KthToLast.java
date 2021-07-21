package com.data.structure.linked.list;

import com.patterns.fast.slow.pointers.ListNode;

//Return Kth to Last: Implement an algorithm to find the Kth to last element of a singly linked list
public class KthToLast {

	//Approach #1 (Don't return the element)
	//Using Recursion
	//Each of these recursive solutions takes O(n) space due to the recursive calls
	
	/*
	 * This algorithm recurses through the linked list. When it hits the end, the method passes back a counter set to 0.
	 * Each parent call adds 1 to the counter. When the counter equals k, we know we have reached the kth to last element
	 * of the linked list.
	 */
	
	int printKthToLast(ListNode head, int k) {
		if(head==null)
			return 0;
		
		int index = printKthToLast(head.next, k)+1;
		
		if(index == k) {
			System.out.println("Kth Element to Last is "+ head.value);
		}
		
		return index;
	}
	
	
	//Approach #2 (Return the element)
	//Using recursion using wrapper class
	//Each of these recursive solutions takes O(n) space due to the recursive calls
	class Index{
		public int value = 0;
	}
	
	int printKthToLastUsingWrapperClass(ListNode node, int k) {
		Index idx = new Index();
		ListNode result = printKthToLast(node, idx, k);
		return result.value;
	}
	
	ListNode printKthToLast(ListNode head, Index idx, int k) {
		if(head==null) {
			return null;
		}
		
		ListNode node = printKthToLast(head.next, idx, k);
		idx.value++;
		
		if(idx.value == k) {
			return head;
		}
		
		return node;
	}
	
	//Approach # 3
	//Iterative
	//This algorithm takes O(n) time and O(1) space.
	
	/*
	 * A more optimal, but less straightforward, solution is to implement this iteratively.
	 * We can use two pointers p1 and p2. We place them k nodes apart in the liked list by putting p2 at the beginning
	 * and moving p1 k nodes into the list. Then, when we move them at the same pace, p1 will hit the end of the linked list
	 * after LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end.
	 */
	
	ListNode nthToLast(ListNode head, int k) {
		ListNode p1 = head;
		ListNode p2 = head;
		
		// Move p1 k nodes into the list
		for(int i=0; i<k; i++) {
			if(p1==null)
				return null; //Out of bounds
			p1=p1.next;
		}
		
		while(p1!=null) {
			p1=p1.next;
			p2=p2.next;
		}
		
		return p2;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(8);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(16);
		node.next.next.next.next = new ListNode(6);
		node.next.next.next.next.next = new ListNode(7);
		node.next.next.next.next.next.next = new ListNode(1);
		node.next.next.next.next.next.next.next = new ListNode(9);
		node.next.next.next.next.next.next.next.next = new ListNode(4);
		node.next.next.next.next.next.next.next.next.next = new ListNode(0);
		
		KthToLast obj = new KthToLast();
		obj.printKthToLast(node, 3);
		
		System.out.println("printKthToLastUsingWrapperClass  "+ obj.printKthToLastUsingWrapperClass(node, 5));
		
		System.out.println("nthToLast  " + obj.nthToLast(node, 4).value);
	}
}
