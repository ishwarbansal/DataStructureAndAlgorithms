package com.pattern.two.pointers;

public class RemoveElement {
	
	public static int[] remove(int[] arr, int key) {
		int dupIndex = 1;
		
		for(int i=1; i<arr.length; i++) {
			if(arr[dupIndex-1] != arr[i] && arr[dupIndex-1]==key) {
				int swapValue = arr[dupIndex-1];
				arr[dupIndex-1] = arr[i];
				arr[i] = swapValue;
				dupIndex++;
			}
		}
		
		return arr;
	  }
	

	  public static void main(String[] args) {
	    int[] arr = new int[] { 3, 2, 3, 6, 3, 10, 9, 3 };
	    int list[] = RemoveElement.remove(arr, 3);
	    for(int i : list) {
	    	System.out.print(i);
	    	System.out.println(" ");
	    }
	    System.out.println("");
	    int[] arr2 = new int[] { 2, 11, 2, 2, 1 };
	    int list2[] = RemoveElement.remove(arr2, 2);
	    for(int i : list2) {
	    	System.out.print(i);
	    	System.out.println(" ");
	    }
	  }
	}
