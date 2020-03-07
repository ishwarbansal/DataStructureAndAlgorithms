package com.pattern.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pattern.second.TripletSumCloseToTarget.SmallestValue;

public class TripletWithSmallerSum {

	//Not working
	public static List<Integer[]> searchTriplets(int[] arr, int target) {
		int left=1, right = arr.length-1;
		int sum = Integer.MIN_VALUE;
		List<Integer[]> map = new ArrayList<Integer[]>();

		selectionSort(arr);

		for(int mid=0; mid<arr.length-2; mid++) {
			left = mid + 1;
			right = arr.length-1;
			while(left<right) {
				sum = arr[left] + arr[right] + arr[mid];
				Integer []val = {arr[mid], arr[left], arr[right]};

				if(sum >= target) {
					right--;
				}else {
					map.add(val);
					left++;
				}
			}
		}
		return map;
	}

	//working
	public static int searchTriplet(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			count += searchPair(arr, target - arr[i], i);
		}
		return count;
	}

	private static int searchPair(int[] arr, int targetSum, int first) {
		int count = 0;
		int left = first + 1, right = arr.length - 1;
		while (left < right) {
			if (arr[left] + arr[right] < targetSum) { // found the triplet
				// since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between 
				// left and right to get a sum less than the target sum
				System.out.println(arr[first] + "  " + arr[left] + "   " + arr[right]);
				count += right - left;
				int  r=right-1;
				while(left<r) {
					System.out.println(arr[first]+ "  " +arr[left] + "   "+ arr[r]);
					r-=1;	        
				}
				left++;
			} else {
				right--; // we need a pair with a smaller sum
			}
		}
		return count;
	}


	//working
	public static int searchTripletsDocVir(int[] arr, int target) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			count += searchPairDocVir(arr, target - arr[i], i, arr[i]);
		}
		return count;
	}

	private static int searchPairDocVir(int[] arr, int targetSum, int first, int mid) {
		int count = 0;
		int left = first + 1, right = arr.length - 1;
		while (left < right) {
			if (arr[left] + arr[right] < targetSum) { // found the triplet
				// since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between 
				// left and right to get a sum less than the target sum
				count += right - left;
				System.out.println(mid+ " " +arr[left] + " "+ arr[right]);
				int  r=right-1;
				while(left<r) {
					System.out.println(mid+ " " +arr[left] + " "+ arr[r]);
					r-=1;	        
				}
				left++;
			} else {
				right--; // we need a pair with a smaller sum
			}
		}
		return count;
	}

	public static void main(String[] args) {
			    System.out.println(TripletWithSmallerSum.searchTriplet(new int[] {-1, 4, 2, 1, 3 }, 5));
//		System.out.println(TripletWithSmallerSum.searchTripletsDocVir(new int[] { -1, 4, 2, 1, 3 }, 5));
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

	//	public static void main(String[] args) {
	////		int [] list = {-1, 0, 2, 3};
	//		int [] list2 = {-1, 4, 2, 1, 3};
	//		//-1 1 2 3 4 
	//		selectionSort(list2);
	//		TripletWithSmallerSum.searchTripletsDoc(list2, 5);
	//	}


	public static void print(int result[]) {
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + "  >>  ");
		}
		System.out.println("------------");

	}

}
