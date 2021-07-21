package com.data.structure.linked.list;

public class MergeTwoSortedList {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
        ListNode curr = result;
        
        while(true){
            
            if(l1==null){
                curr.next = l2;
                break;
            }
            if(l2==null){
                curr.next = l1;
                break;
            }
                        
            if(l1.value > l2.value){
                curr.next = l2;
                l2 = l2.next;
            }else{
                curr.next = l1; 
                l1 = l1.next;
            }
            curr = curr.next;
        }
        
        return result.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedList list = new MergeTwoSortedList();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);

		list.mergeTwoLists(l1, l2);

		while(l1!=null) {
			System.out.println(l1.value);
			l1=l1.next;
		}
	}



}
