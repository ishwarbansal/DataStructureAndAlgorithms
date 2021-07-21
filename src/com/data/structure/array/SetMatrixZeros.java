package com.data.structure.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros {

//	Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.

//	Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.

//	Input Format:

//	The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
//	Output Format:

//	Return a 2-d matrix that satisfies the given conditions.
//	Constraints:

//	1 <= N, M <= 1000
//	0 <= A[i][j] <= 1
//	Examples:

//	Input 1:
//	    [   [1, 0, 1],
//	        [1, 1, 1], 
//	        [1, 1, 1]   ]

//	Output 1:
//	    [   [0, 0, 0],
//	        [1, 0, 1],
//	        [1, 0, 1]   ]

//	Input 2:
//	    [   [1, 0, 1],
//	        [1, 1, 1],
//	        [1, 0, 1]   ]

//	Output 2:
//	    [   [0, 0, 0],
//	        [1, 0, 1],
//	        [0, 0, 0]   ]
	        		
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {

		Set<Integer> cols = new HashSet<>();
		Set<Integer> rows = new HashSet<>();

		for(int i = 0; i < a.size(); i++){
			for(int j = 0; j < a.get(0).size(); j++){
				if(a.get(i).get(j) == 0){
					rows.add(i);
					cols.add(j);
				}
			}
		}

		for(int row: rows){
			updateRow(a, row);
		}

		for(int col: cols){
			updateCol(a, col);
		}
	}

	public void updateRow(ArrayList<ArrayList<Integer>> a, int index){
		for(int j = 0; j < a.get(0).size(); j++)
			a.get(index).set(j, 0);
	}

	public void updateCol(ArrayList<ArrayList<Integer>> a, int index){
		for(int i = 0; i < a.size(); i++)
			a.get(i).set(index,0);
	}

}
