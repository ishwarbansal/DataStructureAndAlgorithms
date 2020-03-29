package com.pattern.two.pointers;

import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicates {

	public static int remove(int[] arr) {
		int nextNonDuplicate = 1; // index of the next non-duplicate element
		for (int i = 1; i < arr.length; i++) {
			if (arr[nextNonDuplicate - 1] != arr[i]) {
				arr[nextNonDuplicate] = arr[i];
				nextNonDuplicate++;
			}
		}

		return nextNonDuplicate;
	}

	public static int removeDup(List<Integer> arr) {
		int nextNonDuplicate = 1; // index of the next non-duplicate element
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(nextNonDuplicate - 1) != arr.get(i)) {
				arr.set(nextNonDuplicate, arr.get(i));
				nextNonDuplicate++;
			}
		}
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i) + "  >>  ");
		}
		return nextNonDuplicate;
	}
	
	public static void main(String[] args) {
//		int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
//		System.out.println(RemoveDuplicates.remove(arr));
//
//		arr = new int[] { 2, 2, 2, 11 };
//		System.out.println(RemoveDuplicates.remove(arr));
		
		List<Integer> arr = new LinkedList<Integer>();
		arr.add(2);
		arr.add(3);
		arr.add(3);
		arr.add(3);
		arr.add(6);
		arr.add(9);
		arr.add(9);
		
		RemoveDuplicates.removeDup(arr);
	} 



}
