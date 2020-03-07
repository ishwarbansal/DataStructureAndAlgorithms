package com.pattern.third;

public class MiddleOfLinkedList {
	//Brute Force
	public static ListNode findMiddle(ListNode head) {
		// TODO: Write your code here
		int countNode = 0;
		ListNode nextNode = head;
		while(nextNode!=null) {
			nextNode = nextNode.next;
			countNode ++;
		}
		int middle = countNode / 2;
		middle++;
		ListNode middleNode = head;
		while(middle>1) {
			middleNode = middleNode.next;
			middle--;
		}
		return middleNode;
	}

	//Slow Fast Pointer
	public static ListNode findMiddle2(ListNode head) {
		ListNode slow = head, fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle2(head).value);

		head.next.next.next.next.next = new ListNode(6);
		System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle2(head).value);

		head.next.next.next.next.next.next = new ListNode(7);
		System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle2(head).value);
	}


}
