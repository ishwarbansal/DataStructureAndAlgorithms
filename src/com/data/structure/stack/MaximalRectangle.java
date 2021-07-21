package com.data.structure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/*
 85. Maximal Rectangle
 Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example 1:
Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

Example 2:
Input: matrix = []
Output: 0

Example 3:
Input: matrix = [["0"]]
Output: 0

Example 4:
Input: matrix = [["1"]]
Output: 1

Example 5:
Input: matrix = [["0","0"]]
Output: 0

Constraints:
rows == matrix.length
cols == matrix.length
0 <= row, cols <= 200
matrix[i][j] is '0' or '1'.
*/
public class MaximalRectangle {

	
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        //Declare array to make this problem similar to Next Greater Element to Right.
        //If we have 1 in same column of every row, we will sum up them all, otherwise we will update to zero.
        int arr[] = new int[matrix[0].length];
        int maxRectangle = 0;        
        for(int row=0; row<matrix.length; row++){
            for(int col=0; col<matrix[row].length; col++){
                if(matrix[row][col]=='1'){
                    arr[col]++;
                }  else {
					arr[col] = 0;
				}           
            }
            
            //Now will get Next Smaller Element to Left and Next Smaller Element to Right.
            //Once we have both above the array, we can jsut apply below logic
            //Next Smaller Element to Right minus Next Smaller element to Left minus 1
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
		MaximalRectangle rectangle = new MaximalRectangle();
		char[][] matrix = new char[][] {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(rectangle.maximalRectangle(matrix));
	}
}
