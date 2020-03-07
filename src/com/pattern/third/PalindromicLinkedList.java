package com.pattern.third;

public class PalindromicLinkedList {
	//Slow Fast Pointer
	public static boolean isPalindrome(ListNode head) {
		ListNode slow = head, fast = head;
		int nodeCount = 1;
		while(fast!=null && fast.next!=null) {
			nodeCount = nodeCount + 2;
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast==null)
			nodeCount--;
			
		if(nodeCount%2==0)
			return false;
		
		return true;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		System.out.println("Middle Node: " + PalindromicLinkedList.isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		System.out.println("Middle Node: " + PalindromicLinkedList.isPalindrome(head));
	}


}
