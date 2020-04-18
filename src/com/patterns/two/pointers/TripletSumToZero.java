package com.patterns.two.pointers;

import java.util.ArrayList;
import java.util.List;

public class TripletSumToZero {

	public static List<Integer[]> searchTriplets(int[] arr) {
		int left=1, right = arr.length-1;
		int sum = Integer.MIN_VALUE;
		List<Integer[]> indexes = new ArrayList<Integer[]>();

		for(int mid=0; mid<arr.length-2; mid++) {
			while(left<right) {
				sum = arr[left] + arr[right];
				if(sum==-(arr[mid])) {
					Integer []val = {arr[mid], arr[left], arr[right]};
					//					System.out.println(mid + "  " + left + "  "+ right);
					indexes.add(val);
					break;
				}else if(sum > -arr[mid]) {
					right--;
				}else {
					if(mid == left+1) {
						left = left + 2;
					}else {
						left++;
					}
				}
			}
			left = 0;
			right = arr.length-1;
		}
		return indexes;
	}



	public static List<Integer[]> searchTripletsDoc(int[] arr) {
		List<Integer[]> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
				continue;
			searchPair(arr, -arr[i], i + 1, triplets);
		}

		return triplets;
	}


	public static void searchPair(int[] arr, int target, int left, List<Integer[]> triplets) {
		int right = arr.length-1;
		while (left < right) {
			int diff = target - arr[left];
			if(diff==arr[right]) {
				Integer triplet [] = {-target, arr[left], arr[right]};
				triplets.add(triplet);
				left++;
				right--;
				while(left<right && arr[left]==arr[left-1]) {
					left++;
				}
				while(left<right && arr[right]==arr[right+1]) {
					right--;
				}
			}else if (diff > arr[right]) {
				left++;
			}else {
				right--;
			}
		}
	}

	public static void swap(int[] listToSort, int iIndex, int jIndex) {
		int temp = listToSort[iIndex];
		listToSort[iIndex] = listToSort[jIndex];
		listToSort[jIndex] = temp;
	}

	public static void selectionSort(int[] listToSort) {
		for (int i = 0; i < listToSort.length; i++) {
			for (int j = i + 1; j < listToSort.length; j++) {
				if (listToSort[i] > listToSort[j]) {
					swap(listToSort, i, j);
				}
			}
		}
	}

	public static void main(String[] args) {
		int [] list = {-3, 0, 1, 2, -1, 1, -2};
		selectionSort(list);
		print(TripletSumToZero.searchTripletsDoc(list));
	}

	public static void print(List<Integer[]> result) {
		for(Integer[] in : result) {
			for(int i=0; i<in.length; i++) {
				System.out.print(in[i] + " ");
			}
			System.out.println("");
		}
	}

}
