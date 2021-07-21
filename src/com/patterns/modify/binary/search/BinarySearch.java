package com.patterns.modify.binary.search;

import java.util.ArrayList;
import java.util.List;

import com.data.structure.linked.list.ListNode;

public class BinarySearch {

	public static int search(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		boolean isAscending = arr[start] < arr[end];
		while (start <= end) {
			// calculate the middle of the current range
			int mid = start + (end - start) / 2;

			if (key == arr[mid])
				return mid;

			if (isAscending) { // ascending order
				if (key < arr[mid]) {
					end = mid - 1; // the 'key' can be in the first half
				} else { // key > arr[mid]
					start = mid + 1; // the 'key' can be in the second half
				}
			} else { // descending order        
				if (key > arr[mid]) {
					end = mid - 1; // the 'key' can be in the first half
				} else { // key < arr[mid]
					start = mid + 1; // the 'key' can be in the second half
				}
			}
		}
		return -1; // element not found
	}

	public static void main(String[] args) {
		//		System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
		//		System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 7 }, 5));
		//		System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
		//		System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
		//		List<Integer> list = new ArrayList<Integer>();
		//		list.add(1);
		//		list.add(3);
		//		list.add(5);		
		//		System.out.println(BinarySearch.searchIndex(list, 2));

		//		System.out.println(BinarySearch.createSortedArray(new int[] {1,2,3,6,5,4}));

//		BinarySearch.merge2(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
//		BinarySearch.merge(new int[] {1}, 1, new int[] {}, 0);
		
		ListNode l1 = new ListNode(9);
		l1.next = new ListNode(9);
		l1.next.next = new ListNode(9);
		l1.next.next.next = new ListNode(9);
		l1.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next = new ListNode(9);
		l1.next.next.next.next.next.next = new ListNode(9);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(9);
		l2.next.next.next = new ListNode(9);
		
		ListNode l = BinarySearch.addTwoNumbers(l1, l2);
		while(l!=null) {
			System.out.println(l.value);
			l= l.next;
		}
		
	}


	public static int createSortedArray(int[] instructions) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(instructions[0]);
		int cost = 0;
		for(int i=1; i<instructions.length; i++){
			int index = result.indexOf(instructions[i]);
			int localCost = 0;
			if(index==-1) {
				index = searchIndex(result, instructions[i]);
				localCost = Math.min(index, result.size()-index);
			}else {
				localCost = Math.min(index, result.size()-result.lastIndexOf(instructions[i])-1);
			}
			cost+=localCost;
			result.add(index, instructions[i]);
		}
		return cost;
	}


	public static int searchIndex(List<Integer> arr, int key) {
		int start = 0, end = arr.size() - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if(key==arr.get(mid)) {
				return mid;
			}
			if (key < arr.get(mid)) {
				end = mid - 1;
			} else { 
				start = mid + 1; 
			}
		}
		return start; 
	}


	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] result = new int[m+n];

		int i=0, j=0, k=0;

		while(m>0 || n>0){
			if(m>0 && n>0 && nums1[i]<=nums2[j]){
				result[k++] = nums1[i++];
				m--;
			}else if (m>0 && n>0 && nums1[i]>nums2[j]){
				result[k++] = nums2[j++];
				n--;
			}else if (m>0){
				result[k++] = nums1[i++];
				m--;               
			}else{
				result[k++] = nums2[j++];
				n--;
			}            
		}
		nums1 = result;

		for(int val:nums1) {
			System.out.println(val);
		}
	}


	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int l = nums1.length - 1;
		m--; n--;
		while(m >= 0 && n >= 0) {
			if(nums1[m] > nums2[n]) 
				nums1[l--] = nums1[m--];
			else 
				nums1[l--] = nums2[n--];
		}

		while(n >= 0) 
			nums1[l--] = nums2[n--];
	}
	
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        
        int carry = 0;
        int sum =0;
        while(l1!=null && l2!=null){
            sum = carry + l1.value + l2.value;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            
            result  = result.next;            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1!=null){
            sum = carry + l1.value;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            
            result  = result.next;
            l1 = l1.next;
        }
        
         while(l2!=null){
            sum = carry + l2.value;
            carry = sum/10;
            result.next = new ListNode(sum%10);
        
            result  = result.next;            
            l2 = l2.next;
        }
        
        return head.next;
    }
}
