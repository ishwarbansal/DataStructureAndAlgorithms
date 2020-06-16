package com.patterns.modify.binary.search;

public class RotationCountOfRotatedArray {

	public static int countRotations(int[] arr) {
		int start=0; int end = arr.length-1;

		while(start < end) {
			int mid = start + (end-start)/2;
			
			if(arr[mid]<arr[mid+1] && arr[mid]<arr[mid-1]) {
				return mid;
			}else if(arr[mid] <arr[mid+1] && arr[mid]>arr[mid-1]){
				start = mid+1;
			}
		}
		return start==arr.length-1?0:start;	
	}

	public static void main(String[] args) {
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
		System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
	}


}
