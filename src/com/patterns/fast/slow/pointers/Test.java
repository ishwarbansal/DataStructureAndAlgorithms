package com.patterns.fast.slow.pointers;

public class Test {
	
	public static ListNode findCycleStart(ListNode head) {
	    int cycleLength = 0;
	    // find the LinkedList cycle
	    ListNode slow = head;
	    ListNode fast = head;
	    while (fast != null && fast.next != null) {
	      fast = fast.next.next;
	      slow = slow.next;
	      if (slow == fast) { // found the cycle
	        cycleLength = calculateCycleLength(slow);
	        break;
	      }
	    }

	    return findStart(head, cycleLength);
	  }

	  private static int calculateCycleLength(ListNode slow) {
	    ListNode current = slow;
	    int cycleLength = 0;
	    do {
	      current = current.next;
	      cycleLength++;
	    } while (current != slow);
	    
	    return cycleLength;
	  }

	  private static ListNode findStart(ListNode head, int cycleLength) {
	    ListNode pointer1 = head, pointer2 = head;
	    // move pointer2 ahead 'cycleLength' nodes
	    while (cycleLength > 0) {
	      pointer2 = pointer2.next;
	      cycleLength--;
	    }

	    // increment both pointers until they meet at the start of the cycle
	    while (pointer1 != pointer2) {
	      pointer1 = pointer1.next;
	      pointer2 = pointer2.next;
	    }

	    return pointer1;
	  }

	  public static void main(String[] args) {
	    ListNode head = new ListNode(1);
	    head.next = new ListNode(2);
	    head.next.next = new ListNode(3);
	    head.next.next.next = new ListNode(4);
	    head.next.next.next.next = new ListNode(5);
	    head.next.next.next.next.next = new ListNode(6);
	    
	    Test test = new Test();
	    ListNode returnValue = test.reverseListUsingRecursive(head);
	    
	    while(returnValue.next!=null) {
	    	System.out.println(returnValue.value);
	    	returnValue = returnValue.next;
	    }

//	    head.next.next.next.next.next.next = head.next.next;
//	    System.out.println("LinkedList cycle start: " + Test.findCycleStart(head).value);

//	    head.next.next.next.next.next.next = head.next.next.next;
//	    System.out.println("LinkedList cycle start: " + Test.findCycleStart(head).value);
//
//	    head.next.next.next.next.next.next = head;
//	    System.out.println("LinkedList cycle start: " + Test.findCycleStart(head).value);
	  }

	  
	  public void reverseList(ListNode listNode) {
		  
		  ListNode currentNode = listNode;
		  ListNode previousNode = null;
		  ListNode nextNode = null;
		  
		  while(currentNode!=null) {
			  nextNode = currentNode.next;
			  currentNode.next = previousNode;
			  previousNode = currentNode;
			  currentNode = nextNode;
		  }
		  
		  while(previousNode!=null) {
			  System.out.println(previousNode.value);
			  previousNode = previousNode.next;
		  }
	  }
	  
  public ListNode reverseListUsingRecursive(ListNode head) {
	  
//	  if(listNode.next==null) {
//		  return new ListNode(listNode.value);
//	  }
//	  
//	  ListNode list = reverseListUsingRecursive(listNode.next);
//	  listNode.next = null;
//	  list.next = listNode;
//	  return list;
	  
	  if(head == null) { 
          return head; 
      } 

      // last node or only one node 
      if(head.next == null) { 
          return head; 
      } 

      ListNode newHeadNode = reverseListUsingRecursive(head.next); 

      // change references for middle chain 
      head.next.next = head; 
      head.next = null; 

      // send back new head node in every recursion 
      return newHeadNode; 
		  
  }
}
