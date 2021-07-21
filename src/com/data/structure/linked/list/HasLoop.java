package com.data.structure.linked.list;

import com.patterns.fast.slow.pointers.ListNode;

/* Determine Linked List has a loop. */
public class HasLoop {

	public ListNode checkLinkedListHasLoop(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			//Collision happened
			if(slow==fast)
				break;
		}
		
		/* Error checking - no meeting point and therefore no loop*/
		if(fast==null || fast.next==null)
			return null;
		
		slow = head;
		
		while(slow!=fast) {
			slow = slow.next;
			fast = fast.next;
		}
		
		return slow;
	
	}

}
