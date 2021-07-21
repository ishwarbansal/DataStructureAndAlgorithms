package com.data.structure.array;

public class PathWithMinimumEffort {

	public int minimumEffortPath(int[][] heights) {

		int startIndex=0, endIndex=Integer.MAX_VALUE, ans=Integer.MAX_VALUE, row=heights.length, col=heights[0].length;

		while(startIndex<=endIndex){
			int mid = startIndex + (endIndex - startIndex)/2;
			int[][] visited = new int[100][100];
			if(findEffort(0, 0 , mid, heights, visited, row, col)){
				endIndex = mid-1;
				ans = Math.min(ans, mid);
			}else{
				startIndex = mid+1;
			}
		}
		return ans;
	}

	public boolean findEffort(int startIndex, int endIndex, int mid, int[][] heights, int[][] visited, int row, int col){
		if(startIndex==row-1 && endIndex==col-1){
			return true;
		}
		visited[startIndex][endIndex]=1;
		boolean op = false;
		if(startIndex>0 && visited[startIndex-1][endIndex]==0 && Math.abs(heights[startIndex][endIndex]-heights[startIndex-1][endIndex])<=mid){
			op = op || findEffort(startIndex-1, endIndex , mid, heights, visited, row, col);
		}
		if(endIndex>0 && visited[startIndex][endIndex-1]==0 && Math.abs(heights[startIndex][endIndex]-heights[startIndex][endIndex-1])<=mid){
			op = op || findEffort(startIndex, endIndex-1 , mid, heights, visited, row, col);
		}
		if(startIndex<row-1 && visited[startIndex+1][endIndex]==0 && Math.abs(heights[startIndex][endIndex]-heights[startIndex+1][endIndex])<=mid){
			op = op || findEffort(startIndex+1, endIndex , mid, heights, visited, row, col);
		}
		if(endIndex<col-1 && visited[startIndex][endIndex+1]==0 && Math.abs(heights[startIndex][endIndex]-heights[startIndex][endIndex+1])<=mid){
			op = op || findEffort(startIndex, endIndex+1 , mid, heights, visited, row, col);
		}

		return op;
	}

	public static void main(String[] args) {
		int[][] heights = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
		new PathWithMinimumEffort().minimumEffortPath(heights);
	}

}
