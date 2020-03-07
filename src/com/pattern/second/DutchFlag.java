package com.pattern.second;

public class DutchFlag {

	public static void main(String[] args) {
		int list[] = {2, 2, 0, 1, 2, 0};
//		print(sort(list));
		print(sortDoc(list));

	}

	public static int[] sort(int[] arr) {
		int left = 0, right=arr.length-1;
		int swap = 0;
		while(left<arr.length-2) {
			right=arr.length-1;
			while(left<right) {
				if(arr[left]>arr[right]) {
					swap = arr[left];
					arr[left] = arr[right];
					arr[right] = swap;
				}
				right--;
			}
			left++;
		}
		return arr;
	}

	public static int[] sortDoc(int[] arr) {
		// all elements < low are 0 and all elements > high are 2
		// all elements from >= low < i are 1
		int low = 0, high = arr.length - 1;
		for (int i = 0; i <= high;) {
			if (arr[i] == 0) {
				swap(arr, i, low);
				// increment 'i' and 'low'
				i++;
				low++;
			} else if (arr[i] == 1) {
				i++;
			} else { // the case for arr[i] == 2
				swap(arr, i, high);
				// decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
				high--;
			}
		}
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}





	public static void print(int[] result) {
		for(int in : result) 
			System.out.print(in + " ");
		System.out.println("");
	}
}
