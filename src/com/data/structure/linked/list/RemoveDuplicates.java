package com.data.structure.linked.list;

import java.util.HashSet;
import java.util.Set;

import com.patterns.fast.slow.pointers.ListNode;

//Remove Dups: Write code to remove duplicates from an unsorted linked list.
public class RemoveDuplicates {

	//Approach #2
	//Using extra memory
	//This solution takes O(n) time, where n is the number of elements in the linked list
	
	/*
	 	In the below solution, we simply iterate through the linked list, 
		adding each element to a hash table. when we discover a duplicate element, 
		we remove the element and continue iterating. 
		We can do this all in one pass since we are using a linke list
	*/
	void deleteDups(ListNode head) {
		Set<Integer> valSet = new HashSet<>();
		ListNode previous = null;

		while(head!=null) {
			if(valSet.contains(head.value)) {
				previous.next = head.next;
			}else {
				valSet.add(head.value);
				previous = head;
			}
			head = head.next;
		}

	}

	//Approach #2
	//Without extra memory
	//This code runs O(1) space, but O(n square) time.
	
	/*
	 * If we don't have a buffer, we can iterate with two pointers: 
		current which iterate through the linked list,
		and runner which checks all subsequent nodes for duplicates.
	*/
	
	void deleteDupsWithoutExtaMemory(ListNode head) {
		ListNode current = head;

		while(current!=null) {
			ListNode runner = current;
			while(runner.next!=null) {
				if(runner.next.value == current.value) {
					runner.next = runner.next.next;
				}else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
	
	/*
	 * We can delete the node without using any extra memory and recursion.
	 * 
	 * */
	void deleteAtRuntime(ListNode head) {
		while(head!=null && head.next!=null) {
			if(head.value==head.next.value)
				head.next=head.next.next;
			
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(8);
		node.next = new ListNode(2);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(3);

//		new RemoveDuplicates().deleteDups(node);
//
//		while(node!=null) {
//			System.out.println(node.value);
//			node = node.next;
//		}
		
//		new RemoveDuplicates().deleteDupsWithoutExtaMemory(node);
//
//		while(node!=null) {
//			System.out.println(node.value);
//			node = node.next;
//		}
		
		new RemoveDuplicates().deleteAtRuntime(node);

		while(node!=null) {
			System.out.println(node.value);
			node = node.next;
		}
		
		
	}

}
