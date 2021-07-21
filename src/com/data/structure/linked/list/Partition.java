package com.data.structure.linked.list;

import com.patterns.fast.slow.pointers.ListNode;

/*
 * Partition: Write code to partition a linked list around a value x, 
 * such that all node less than x come before all node greater than or equal to x. 
 * IMPORTANT: The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 * The additional spacing the example below indicates the partition.)
 * EXAMPLE
 * Input 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5] 
 * Output 3 -> 1 -> 2     ->     10 -> 5  -> 5 -> 8
 * 
 */
public class Partition {

	ListNode getPartition(ListNode node, int x) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;

		while(node!=null) {
			ListNode next = node.next;
			node.next = null;
			if(node.value<x) {
				if(beforeStart==null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				}else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			}else {
				if(afterStart==null) {
					afterStart=node;
					afterEnd = afterStart;
				}else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node =  next;
		}
		if(beforeStart!=null) {
			beforeEnd.next = afterStart;
		}			
		return beforeStart==null?afterStart:beforeStart;
	}

	/*  Instead of four variables, let's make it more shorter*/

	ListNode partition(ListNode node, int x) {
		ListNode head = node;
		ListNode tail =node;

		while(node!=null) {
			ListNode next = node.next;
			if(node.value<x) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(5);
		node.next.next = new ListNode(8);
		node.next.next.next = new ListNode(5);
		node.next.next.next.next = new ListNode(10);
		node.next.next.next.next.next = new ListNode(2);
		node.next.next.next.next.next.next = new ListNode(1);

		Partition obj = new Partition();
		/*ListNode result = obj.getPartition(node, 5);

		while(result!=null) {
			System.out.println(result.value);
			result = result.next;
		}
		 */

		ListNode result = obj.partition(node, 5);

		while(result!=null) {
			System.out.println(result.value);
			result = result.next;
		}
	}
}
