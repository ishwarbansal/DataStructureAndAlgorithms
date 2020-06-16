package com.patterns.top.k.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

	public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
	    PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a,b)-> a-b);
	    
	    for(int i=0; i<arr.length; i++) {
	    	if(arr[i] <= X) {
	    		if(i<K) {
	    			pQueue.add(arr[i]);
	    		}else {
	    			pQueue.add(arr[i]);
	    			pQueue.poll();
	    		}
	    	}
	    }
	    List<Integer> result = new ArrayList<>(pQueue);
	    Collections.sort(result);
	    return result;
	  }

	  public static void main(String[] args) {
	    List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
	    System.out.println("'K' closest numbers to 'X' are: " + result);

	    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
	    System.out.println("'K' closest numbers to 'X' are: " + result);

	    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
	    System.out.println("'K' closest numbers to 'X' are: " + result);
	  }


}
