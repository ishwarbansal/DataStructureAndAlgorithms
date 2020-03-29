package com.patterns.inplace.reversal;

public class ReverseEveryKElements {
	
	public static ListNode reverseEveryK(ListNode head, int k) {
		ListNode current = head;
		head = null;
		
		ListNode next = null;
		ListNode previous = null;
		ListNode firstNode = null;
		ListNode lastNode = null;
		int m = 1;
		int i = 1;
		
		while(current!=null) {
			firstNode = current;
			for(i=m; i<k+m && current!=null; i++) {
				next = current.next;
				current.next = previous;
				previous = current;
				current = next;
			}
			m = i; 

			if(head == null) {
				head = previous;
				lastNode = firstNode;
			}else {
				lastNode.next = previous;
				lastNode = firstNode;
				previous = null;
			}
		}
	    return head;
	  }

	public static ListNode reverseAlternateK(ListNode head, int k) {
		ListNode current = head;
		head = null;
		
		ListNode next = null;
		ListNode previous = null;
		ListNode firstNode = null;
		ListNode lastNode = null;
		int m = 1;
		int i = 1;
		boolean alternate = true;
		while(current!=null) {
			firstNode = current;
			
			for(i=m; i<k+m && current!=null; i++) {
				if(alternate) {
					next = current.next;
					current.next = previous;
					previous = current;
					current = next;
				}else {
					next = current.next;
					if(previous!=null)
						previous.next = current;
					else
						previous = current;
					firstNode = current;
					current = next;;
				}
			}
			
			alternate = !alternate;			
			m = i;

			if(head == null) {
				head = previous;
				lastNode = firstNode;
			}else {
				lastNode.next = previous;
				lastNode = firstNode;
			}
			previous = null;
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
	    head.next.next.next.next.next.next.next.next = new ListNode(9);
	    head.next.next.next.next.next.next.next.next.next = new ListNode(10);

//	    ListNode result = ReverseEveryKElements.reverseEveryK(head, 3);
//	    System.out.print("Nodes of the reversed LinkedList are: ");
//	    while (result != null) {
//	      System.out.print(result.value + " ");
//	      result = result.next;
//	    }
	    
	    ListNode result = ReverseEveryKElements.reverseAlternateK(head, 2);
	    System.out.print("Nodes of the reversed LinkedList are: ");
	    while (result != null) {
	      System.out.print(result.value + " ");
	      result = result.next;
	    }

	    
	  }


}
