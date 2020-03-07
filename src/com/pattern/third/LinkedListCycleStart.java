package com.pattern.third;

public class LinkedListCycleStart {
	
	public static ListNode findCycleStart(ListNode slow, ListNode fast) {
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast)
				return fast; // found the cycle
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = head.next.next;
	    head.next.next.next.next.next.next = head.next.next.next;
//	    head.next.next.next.next.next.next = head;
		
		ListNode fast = head.next;
		
		while(fast!=null) {
			ListNode cycleStart = findCycleStart(head, fast);
			if(cycleStart==null) {
				fast = fast.next;
			}
			else {
				System.out.println(cycleStart.value);
				break;
			}
			System.out.println("Null");
		}
	}

}
