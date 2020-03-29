package com.patterns.inplace.reversal;

public class ReverseSubList {

	public static ListNode reverse(ListNode head, int p, int q) {

		ListNode firstNodeBeforeSubset= null;
		ListNode firstNodeAfterSubset= null;
		ListNode current = head;

		ListNode previous = null;
		ListNode next = null;


		for(int startIndex = 1; startIndex <= q+1; startIndex++) {
			
			if(startIndex < p) {
				firstNodeBeforeSubset = current;
				current = current.next;
				firstNodeAfterSubset = current;
			}
			if(startIndex==1) {
				firstNodeBeforeSubset = current;
			}

			if(startIndex >=p && startIndex <= q) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}

			if(startIndex>q) {
				if(firstNodeAfterSubset!=null) {
					firstNodeAfterSubset.next = current;
					firstNodeBeforeSubset.next = previous;
				}else {
					firstNodeBeforeSubset.next = current;
					head = previous;
				}
				
			}
		}

		return head;
	}


	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = ReverseSubList.reverse(head, 6, 8);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}


}
