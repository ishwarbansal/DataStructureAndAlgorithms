package com.pattern.two.pointers;

public class ShortestWindowSort {

	public static void main(String[] args) {
		//		int[] arr = {1, 2, 5, 3, 7, 10, 9, 12};
//		int[] arr = {1, 3, 2, 11, 0, -1, 7, 10};
		int[] arr = {1,2,3,4,5};
		sort(arr);

	}

	public static int sort(int[] arr) {
		int left = 0, right = arr.length-1;
		int leftIndex = -1, rightIndex = -1;

		while(left < right) {
			if(arr[left] > arr[left + 1] && leftIndex < 0) {
				leftIndex = left + 1;
			}

			if(arr[right] < arr[right - 1] && rightIndex < 0) {
				rightIndex = right;
			}

			if(leftIndex >=0 && rightIndex > 0) {
				break;
			}

			left++;
			right--;
		}
		if(leftIndex >0 && rightIndex > -1) {
			int firstIndex = 0;
			while(firstIndex < left) {
				//Use the found small array min value
				if(arr[firstIndex++] >= -1) {
					leftIndex = firstIndex--;
					break;
				}
			}

			int lastIndex = arr.length-1;
			while(lastIndex > right) {
				//Use the found small array max value
				if(arr[lastIndex--] <= 11) {
					rightIndex = lastIndex++;
					break;
				}
			}
		}
		System.out.println(leftIndex + " " + rightIndex);
		return - 1;
	}


}
