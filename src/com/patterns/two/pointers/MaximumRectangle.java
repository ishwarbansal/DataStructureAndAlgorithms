package com.patterns.two.pointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumRectangle {

	public int maximalRectangleDP(char[][] matrix) {
		if(matrix.length==0) return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[] left = new int[n];
		int[] right= new int[n];
		int[] height = new int[n];

		int maxA = 0;
		for(int i=0; i<m; i++) {
			int cur_left=0, cur_right=n; 
			for(int j=0; j<n; j++) { // compute height (can do this from either side)
				if(matrix[i][j]=='1') 
					height[j]++; 
				else 
					height[j]=0;
			}
			for(int j=0; j<n; j++) { // compute left (from left to right)
				if(matrix[i][j]=='1') {
//					cur_left = cur_left == 0 ? 1 : cur_left;
					left[j]=Math.max(left[j],cur_left);
				}else {
					left[j]=0; cur_left=j+1;
				}
			}
			// compute right (from right to left)
			for(int j=n-1; j>=0; j--) {
				if(matrix[i][j]=='1') {
//					right[j] = right[j] == 0 ? 1 : right[j];
					right[j]=Math.min(right[j],cur_right);
				} else {
					right[j]=n; cur_right=j;
				}    
			}
			// compute the area of rectangle (can do this from either side)
			for(int j=0; j<n; j++)
				maxA = Math.max(maxA,(right[j]-left[j])*height[j]);
		}
		return maxA;
	}

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0)
			return 0;

		int arr[] = new int[matrix[0].length];
		int maxRectangle = 0;        
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				if(matrix[row][col]=='1'){
					arr[col]++;
				}else {
					arr[col] = 0;
				}
			}
			maxRectangle = Math.max(largestRectangleArea(arr), maxRectangle);
		}

		return maxRectangle;
	}

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
		MaximumRectangle maximumRectangle = new MaximumRectangle();
		System.out.println(maximumRectangle.largestRectangleAreaViru(new int[] {6,2,5,4,5,1,6}));
	}
	
	
	public int largestRectangleAreaViru(int[] height)
	{
		if (height == null || height.length < 1)
			return 0;
		int[] stack = new int[height.length + 1];
		int len = 0, max = 0;
		for (int i = 0; i <= height.length; i++)
		{
			int h = (i == height.length) ? 0 : height[i];
			while (len != 0 && (i == height.length || height[stack[len - 1]] > h))
			{
				if (len == 1)
					max = Math.max(height[stack[--len]] * i, max);
				else
					max = Math.max(height[stack[--len]] * (i - stack[len - 1] - 1), max);
			}
			stack[len++] = i;
		}
		return max;
	}


}

