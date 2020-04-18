package com.patterns.two.pointers;

public class Test {

	//Remove Duplicates (easy)
	public static int[] removeDuplicates(int [] list) {
		int left = 0, right = 1;

		while (right <= list.length-1) {
			if(list[left] == list[right]) {
				right++;
			}else {
				list[left+1] = list [right];
				left++;
				right++;
			}
		}
		return list;
	}

	//Remove Duplicates with Key
	public static int[] removeDuplicatesWithKey(int [] list, int key) {
		int left = 0, right = 0;

		while (right <= list.length-1) {
			if(list[right]!=key) {
				list[left] = list[right];
				left++;
			}
			right++;
		}
		return list;
	}



	public static void main(String[] args) {
		//		int [] list2 = {3, 2, 3, 6, 3, 10, 9, 3};
		//		int[] result2 = Test.removeDuplicatesWithKey(list2, 3);
		//
		//		for(int i=0; i<result2.length; i++) {
		//			System.out.println(result2[i]);
		//		}


		//		int [] list = {-2, -1, 0, 2, 3};
		//		int result[] = Test.makeSquares(list);
		//
		//		print(result);

	}

	/*
	 * private static void printList(List<Integer[]> result) { for(Integer[] in :
	 * result) { for(int a : in) { System.out.print(a + "  "); }
	 * System.out.println(""); } }
	 */

	public static void print(int result[]) {
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("------------");

	}
}