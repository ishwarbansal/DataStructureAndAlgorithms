package com.patterns.two.pointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumAreaHistogram {

	public int largestRectangleArea(int[] heights) {
		arrangeElementForRight(heights);
		arrangeElementForLeft(heights);
		return getMaximumAreaHistogram(heights);
	}

	Stack<Integer[]> nslStack = null;
	List<Integer> nslList = null;

	public void arrangeElementForLeft(int[] arr) {
		nslStack = new Stack<Integer[]>();
		nslList = new ArrayList<Integer>();

		for(int i=0; i<arr.length; i++) {
			if(nslStack.isEmpty()) {
				nslList.add(-1);
			}else if(nslStack.peek()[0]<arr[i]) {
				nslList.add(nslStack.peek()[1]);
			}else if(nslStack.peek()[0]>=arr[i]) {
				while(!nslStack.isEmpty() && nslStack.peek()[0]>=arr[i]) {
					nslStack.pop();
				}
				if(nslStack.isEmpty()) {
					nslList.add(-1);
				}else {
					nslList.add(nslStack.peek()[1]);
				}
			}
			nslStack.add(new Integer[] {arr[i],i});
		}
	}

	Stack<Integer[]> nsrStack = null;
	List<Integer> nsrList = null;

	public void arrangeElementForRight(int[] arr) {
		nsrStack = new Stack<Integer[]>();
		nsrList = new ArrayList<Integer>();

		for(int i=arr.length-1; i>=0; i--) {
			if(nsrStack.isEmpty()) {
				nsrList.add(arr.length);
			}else if(nsrStack.peek()[0]<arr[i]) {
				nsrList.add(nsrStack.peek()[1]);
			}else if(nsrStack.peek()[0]>=arr[i]) {
				while(!nsrStack.isEmpty() && nsrStack.peek()[0]>=arr[i]) {
					nsrStack.pop();
				}
				if(nsrStack.isEmpty()) {
					nsrList.add(arr.length);
				}else {
					nsrList.add(nsrStack.peek()[1]);
				}
			}
			nsrStack.add(new Integer[] {arr[i],i});
		}
	}

	public int getMaximumAreaHistogram(int[] heights) {
		int maxArea = 0;
		int j = nsrList.size()-1;
		for(int i=0; i<nslList.size(); i++) {
			maxArea = Math.max(maxArea, (nsrList.get(j) - nslList.get(i) - 1) * heights[i]);
			j--;
		}
		return maxArea;
	}

	public static void main(String[] args) {
		MaximumAreaHistogram areaHistogram = new MaximumAreaHistogram();
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 1 }));
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 1,1 }));
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 4,3 }));
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 7,1,5,6,7,7 }));
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 7,7,7,7,7,7 }));
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 7,7,7,6,7,7 }));
		System.out.println(areaHistogram.largestRectangleArea(new int[] { 6,2,5,4,5,1,6 }));
	}


}
