package com.patterns.dynamic.programming.aditya.verma.mcm;

public class EggDropping {

	int[][] matrix;

	public EggDropping(int m, int n) {
		matrix = new int[m][n];
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix.length; j++) {
				matrix[i][j] = -1;
			}
		}
	}

	public int isEggBreaking(int floor, int egg) {

		if(floor==0 || floor==1)
			return floor;

		if(egg==1)
			return floor;

		int mn = Integer.MAX_VALUE;

		for(int k=1; k<=floor; k++) {
			int temp = 1 + (Math.max(isEggBreaking(k-1, egg-1), isEggBreaking(floor-k, egg)));

			mn = Math.min(mn,  temp);
		}
		return mn;

	}

	public int isEggBreakingUsingDP(int floor, int egg) {

		if(floor==0 || floor==1)
			return floor;

		if(egg==1)
			return floor;

		if(matrix[floor][egg]!=-1){
			return matrix[floor][egg];
		}
		int mn = Integer.MAX_VALUE;

		for(int k=1; k<=floor; k++) {
			int low = 0;
			if(matrix[k-1][egg-1]==-1) {
				low = isEggBreaking(k-1, egg-1);
				matrix[k-1][egg-1] = low;
			}else {
				low = matrix[k-1][egg-1];
			}

			int high = 0;
			if(matrix[floor-k][egg]==-1) {
				high = isEggBreaking(floor-k, egg);
				matrix[floor-k][egg] = high;
			}else {
				high = matrix[floor-k][egg];
			}

			int temp = 1 + (Math.max(low, high));

			mn = Math.min(mn,  temp);
		}
		return mn;

	}



	public static void main(String[] args) {
		int floor = 12;
		int egg = 3;
		EggDropping eggDropping = new EggDropping(floor, egg);
		System.out.println(eggDropping.isEggBreaking(floor, egg));
	}

}
