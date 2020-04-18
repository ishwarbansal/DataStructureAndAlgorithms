package com.patterns.two.pointers;

public class SortedArraySquares {

	public static int[] makeSquares(int[] arr) {
		int right = arr.length-1;
		int leftSq, rightSq;

		for(int left=0; left<arr.length-1; left++) {
			leftSq = arr[left] * arr[left];
			rightSq = arr[right] * arr[right];
			while(left<=right) {
				if(leftSq > rightSq) {
					arr[right] = leftSq;
					arr[left] = rightSq;
					leftSq = rightSq;
				}else {
					arr[right] = rightSq;
				}
				right--;
				rightSq = arr[right] * arr[right];
			}
		}
		System.out.println("================");
		return arr;
	}

	public static int[] makeSquaresDoc(int[] arr) {
		int left = 0, right = arr.length-1, highIndex = arr.length-1;
		int square[] = new int[arr.length];
		int leftSq, rightSq;

		while(left<=right) {
			leftSq = arr[left] * arr[left];
			rightSq = arr[right] * arr[right];

			if(leftSq > rightSq) {
				square[highIndex--] = leftSq;
				left++;
			}else {
				square[highIndex--] = rightSq;
				right--;
			}
		}
		System.out.println("================");
		return square;
	}
	
	public static void main(String[] args) {
//		int [] list = {-3, -1, 0, 1, 2};
		int [] list = {-2, -1, 0, 2, 3};
		print(SortedArraySquares.makeSquares(list));
	}

	public static void print(int result[]) {
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("------------");

	}

}
