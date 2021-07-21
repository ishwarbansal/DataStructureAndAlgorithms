package com.data.structure.linked.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.patterns.fast.slow.pointers.ListNode;

public class MergeKSortedList {

	public ListNode mergeKLists(ListNode[] lists) {

		if(lists.length==0)
			return null;

		List<Integer> elements = new ArrayList<Integer>();

		for(ListNode node : lists) {
			while(node!=null) {
				elements.add(node.value);
				node = node.next;
			}
		}

		Collections.sort(elements);
		
		ListNode result = new ListNode(0);
		ListNode curr = result;
		for(Integer val : elements) {
			curr.next = new ListNode(val);
			curr = curr.next;
		}

		return result.next;
	}

	public static void main(String[] args) {
		MergeKSortedList list = new MergeKSortedList();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(6);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(5);

		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(4);
		l3.next.next = new ListNode(8);

		ListNode result = list.mergeKLists(new ListNode[] {l1,l2,l3});

		System.out.println(result.value);

	}

}
