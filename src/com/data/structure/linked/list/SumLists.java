package com.data.structure.linked.list;

import java.util.Stack;

import com.patterns.fast.slow.pointers.ListNode;

/*Given two numbers represented by two lists, write a function that returns the sum list. 
 * The sum list is list representation of the addition of two input numbers.
*/
public class SumLists {

	/*
	 * Both the list can be same length or different length
	 * 	Values are in reverse order
	 * 	Using Recursion
	 * 
	 * Input: 
		List1: 5->6->3 // represents number 365 
		List2: 8->4->2 // represents number 248 
		Output: 
		Resultant list: 3->1->6 // represents number 613 
		Explanation: 365 + 248 = 613
	 */
	
	/*Traverse the two linked lists from start to end
		Add the two digits each from respective linked lists.
		If one of the list has reached the end then take 0 as its digit.
		Continue it until both the lists end.
		If the sum of two digits is greater than 9 then set carry as 1 and the current digit as sum % 10
	*/
	ListNode addLists(ListNode l1, ListNode l2) {
		return addLists(l1, l2, 0);
	}

	ListNode addLists(ListNode l1, ListNode l2, int carry) {
		if(l1==null && l2==null && carry==0) {
			return null;
		}
		
		ListNode result = new ListNode(0);
		
		int value = carry;
		if(l1!=null) {
			value+=l1.value;
		}
		if(l2!=null) {
			value+=l2.value;
		}
		
		result.value = value%10;
		
		/* Recurse */
		if(l1!=null || l2!=null) {
			ListNode more = addLists(l1==null?null:l1.next, l2==null?null:l2.next, value>=10?1:0);
			result.setNext(more);
		}
		return result;
	}
	
	
	/*
	 * Both the list can be same length or different length
	 * Values are in forward order
	 * Using Stack
	 */
	ListNode addListsForward(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		
		while(l1!=null) {
			s1.add(l1.value);
			l1 = l1.next;
		}

		while(l2!=null) {
			s2.add(l2.value);
			l2 = l2.next;
		}

		int carry = 0;
		ListNode result = null;
		while(!s1.isEmpty() || !s2.isEmpty() || carry>0) {
			int val = carry;
			
			if(!s1.isEmpty()) {
				val += s1.pop();
			}
			
			if(!s2.isEmpty()) {
				val += s2.pop();
			}
			
			ListNode node = new ListNode(val%10);
			carry = val/10;
			
			node.next = result;
			result = node;
		}
		
		return result;
	}
	
	
	public static void main(String[] args) {
		SumLists obj = new SumLists();
		
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);
		l1.next.next.next = new ListNode(4);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(7);

		
		ListNode result = obj.addLists(l1, l2);
		System.out.println("Reverse Add List");
		while(result!=null) {
			System.out.println(result.value);
			result = result.next;
		}
		
		System.out.println("----------");
		System.out.println("Forward Add List");
		
		result = obj.addListsForward(l1, l2);
		System.out.println("Reverse Add List");
		while(result!=null) {
			System.out.println(result.value);
			result = result.next;
		}
	}
}
