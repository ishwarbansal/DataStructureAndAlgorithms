package com.patterns.inplace.reversal;

public class RotateList {

	public static ListNode rotate(ListNode head, int rotations) {
		int countNode = 0;
		ListNode current = head;
		while(current!=null) {
			countNode ++;
			current = current.next;
		}

		current = head.next;
		ListNode firstPart = head;
		ListNode next, previous = null;
		
		for(int i=1; i<countNode; i++) {
			if(i<rotations) {
				firstPart = firstPart.next;
				current = current.next;
			}else {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
		}
		firstPart.next = previous;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode result = RotateList.rotate(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
