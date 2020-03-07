package com.pattern.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TripletSumCloseToTarget {

	public static class SmallestValue{
		public static int x = Integer.MAX_VALUE;
	}

	public static Map<Integer, Integer[]> searchTriplets(int[] arr, int target) {
		int left=1, right = arr.length-1;
		int sum = Integer.MIN_VALUE;
		Map<Integer, Integer[]> map = new HashMap<Integer,Integer[]>();
		int previousKey = 0;
		selectionSort(arr);

		for(int mid=0; mid<arr.length-2; mid++) {
			while(left<right) {
				sum = arr[left] + arr[right] + arr[mid];
				Integer []val = {arr[mid], arr[left], arr[right]};
				//				System.out.println(sum);
				if(map.size()==0) {
					previousKey = Math.abs(target - sum);
					map.put(previousKey, val);
				}else if (target == sum || previousKey > Math.abs(target - sum)) {
					map.remove(previousKey);
					previousKey = Math.abs(target - sum) ;
					map.put(previousKey, val);
				}

				if(sum > target) {
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
		return map;
	}

	public static int[] searchTripletsDoc(int[] arr, int targetSum) {
		int[] triplets= {};
		SmallestValue smallestValue = new SmallestValue();
		for (int i = 0; i < arr.length - 2; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) // skip same element to avoid duplicate triplets
				continue;
			triplets = searchPair(arr, targetSum, i, i + 1, triplets, smallestValue);
			if (smallestValue.x == 0)
				break;
		}
		System.out.println("smallestDiff "+ smallestValue.x);
		return triplets;
	}


	public static int[] searchPair(int[] arr, int target, int start, int left, int[] triplets,  SmallestValue smallestValue) {
		int right = arr.length-1;
		while (left < right) {
			int diff = target - arr[start] - arr[left] - arr[right];

			if(diff==0) {
				triplets = new int[]{arr[start], arr[left], arr[right]};
				smallestValue.x = diff;
				break;
			}

			if(Math.abs(smallestValue.x) > Math.abs(diff)) {
				smallestValue.x = diff;
				triplets = new int[]{arr[start], arr[left], arr[right]};
			}

			if (diff > 0) {
				left++;
			}else {
				right--;
			}
		}
		return triplets;
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
		int [] list = {-2,0,1,2};
		int [] list2 = {-3, -1, 1, 2};
		int [] list3 = {1, 0, 1, 1};

		selectionSort(list3);
		print(TripletSumCloseToTarget.searchTripletsDoc(list3, 100));


	}


	public static int searchTriplet(int[] arr, int targetSum) {
		Arrays.sort(arr);

		int smallestDifference = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 2; i++) {
			int left = i + 1, right = arr.length - 1;
			while (left < right) {
				// comparing the sum of three numbers to the 'targetSum' can cause overflow
				// so, we will try to find a target difference

				int targetDiff = targetSum - arr[i] - arr[left] - arr[right];
				if (targetDiff == 0) { //  we've found a triplet with an exact sum
					System.out.println(" >> " + arr[i] + "  " + arr[left] + " " + arr[right]);
					return targetSum - targetDiff; // return sum of all the numbers
				}
				if (Math.abs(targetDiff) < Math.abs(smallestDifference)) {
					smallestDifference = targetDiff; // save the closest difference
				}
				if (targetDiff > 0)
					left++; // we need a triplet with a bigger sum
				else
					right--; // we need a triplet with a smaller sum
			}
		}

		return targetSum - smallestDifference;
	}



	public static void print(int result[]) {
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + "  >>  ");
		}
		System.out.println("------------");

	}
}
