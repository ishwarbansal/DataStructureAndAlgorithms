package com.leetcode.challenge.april2020.week3;

import java.util.List;

public class DaySixth {

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        
        int row = dimension.get(0);
        int column= dimension.get(1)-1;
		
        int index = -1;
        
		for(int i=0; i<row; i++) {
			while(binaryMatrix.get(i, column)==1) {
				index = column;
				column--;
			}
		}
        
        return index;
    }
	
	public static void main(String[] args) {
		DaySixth daySixth = new DaySixth();
		daySixth.leftMostColumnWithOne(new BinaryMatrix());
	}

}
