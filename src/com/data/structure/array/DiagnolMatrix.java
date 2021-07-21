package com.data.structure.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DiagnolMatrix {
	
	public int[][] diagonalSort(int[][] mat) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                map.computeIfAbsent(i - j, p -> new PriorityQueue()).add(mat[i][j]);
        
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                mat[i][j] = map.get(i - j).poll();
        
        return mat;
    }
	
	public static void main(String[] args) {
		int[][] mat = new int[][]{{3,3,1,1},{2,2,1,2},{1,1,1,2}};
		new DiagnolMatrix().diagonalSort(mat);
		
		
	}

}
