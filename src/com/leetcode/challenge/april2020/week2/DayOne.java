package com.leetcode.challenge.april2020.week2;

import com.patterns.fast.slow.pointers.ListNode;

public class DayOne {

	public ListNode middleNode(ListNode head) {

		if(head.next ==null)
			return head;
		
		ListNode startIndex = head;
		ListNode endIndex = head;
		
		while(endIndex!=null  && endIndex.next!=null) {
			startIndex = startIndex.next;
			endIndex = endIndex.next.next;
		}
		
		return startIndex;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
		
		ListNode result = new DayOne().middleNode(head);
		System.out.println(result.value);
	}

}
