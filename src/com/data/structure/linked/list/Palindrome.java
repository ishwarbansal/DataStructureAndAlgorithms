package com.data.structure.linked.list;

import java.util.Stack;

import com.patterns.fast.slow.pointers.ListNode;

/*
 * Implement a function to check if a linked list is a plindrome. 
 * 
 */
public class Palindrome {

	/*
	 * Solution #1: Reverse and Compare
	 * */
	boolean isPalindrome(ListNode head) {
		ListNode reverse = null;
		ListNode node = head;
		
		while(node!=null) {
			ListNode n = new ListNode(node.value);
			n.next = reverse;
			reverse = n;			
			node = node.next;
		}
		
		while(head!=null && reverse!=null) {
			if(head.value!=reverse.value)
				return false;
			head = head.next;
			reverse = reverse.next;
		}
		
		return true;
	}
	
	/*
	 * Solution #1: Iterative approach
	 * */
	boolean isPalindromeUsingStack(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		
		Stack<Integer> stack = new Stack<>();
		
		while(fast!=null && fast.next!=null) {
			stack.push(slow.value);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		// Has odd number of elements, so skip the middle element.
		if(fast!=null) {
			slow = slow.next;
		}
		
		while(slow!=null) {
			int top = stack.pop();
			
			// If the value are different, then it's not a plaindrome.
			
			if(top!=slow.value)
				return false;
						
			slow = slow.next;
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(5);
		node.next.next = new ListNode(8);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(3);
		
		Palindrome obj = new Palindrome();
		System.out.println(obj.isPalindrome(node));
		System.out.println(obj.isPalindromeUsingStack(node));
	}

}
