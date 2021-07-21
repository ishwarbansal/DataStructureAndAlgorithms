package com.data.structure.linked.list;

import com.patterns.fast.slow.pointers.ListNode;

/* Find the intersecting node */
public class Intersection {

	/* Declare the class to store the tail and size of each node list*/
	class Result{
		ListNode tail = null;
		int size = 0;
		Result(ListNode node, int size){
			this.tail = node;
			this.size = size;
		}
	}
	public ListNode checkIntersection(ListNode l1, ListNode l2) {
		//Get the tail and size of each node list
		Result r1 = getTailandSize(l1);
		Result r2 = getTailandSize(l2);

		/* If tail's are not matching, means there is no intersection*/
		if(r1.tail!=r2.tail)
			return null;
		

		ListNode longer = r1.size > r2.size ? l1 : l2;
		ListNode shorter = r1.size > r2.size ? l2 : l1;
		
		/* Advance the pointer for the longer linked list by the difference in lengths. */
		longer = getKthNode(longer, Math.abs(r1.size-r2.size));
		
		/* Move both the pointers until they have collision */
		while(shorter!=longer) {
			shorter = shorter.next;
			longer = longer.next;
		}
		return longer;
	}

	/* Get the Tail and size of list node*/
	public Result getTailandSize(ListNode node) {
		int size = 1;
		ListNode current = node;
		while(current.next!=null) {
			size++;
			current=current.next;
		}
		return new Result(current, size);
	}
	
	public ListNode getKthNode(ListNode node, int k) {
		while(k>0) {
			node = node.next;
			k--;
		}
		return node;
		
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(7);
		l1.next.next.next.next.next = new ListNode(2);
		l1.next.next.next.next.next.next = new ListNode(1);

		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(6);
		l2.next.next = l1.next.next.next.next;

		
		Intersection intersection = new  Intersection();
		ListNode result = intersection.checkIntersection(l1, l2);
		if(result==null)
			System.out.println("No Intersection");
		else
			System.out.println(result.value);
	}

}
