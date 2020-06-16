package com.leetcode.challenge.may2020.week3;

import com.patterns.inplace.reversal.ListNode;

public class DayTwo {

	public ListNode oddEvenList(ListNode head) {
		if(head==null || head.next == null)
			return head;

		ListNode oddNode = head;
		
		ListNode evenNode = head.next;
		ListNode even = head.next;

		while(evenNode!=null) {
			if(evenNode.next!=null) {
				oddNode.next = evenNode.next;
				oddNode = oddNode.next;
			}else {
				evenNode.next = null;
				oddNode.next = even;
				return head;
			}
			if(oddNode.next!=null) {
				evenNode.next = oddNode.next;
				evenNode = evenNode.next;
			}else {
				evenNode.next = null;
				evenNode = null;
			}
		}
		oddNode.next = even;
		return head;
	}

	public static void main(String[] args) {
		DayTwo dayTwo = new DayTwo();
		ListNode root = new ListNode(1);
		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);
		root.next.next.next.next.next = new ListNode(6);
//				root.next.next.next.next.next.next = new ListNode(7);

		ListNode result = dayTwo.oddEvenList(root);

		while(result!=null) {
			System.out.println(result.value);
			result = result.next;
		}

	}
}
