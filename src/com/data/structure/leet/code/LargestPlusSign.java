package com.data.structure.leet.code;

import java.util.HashSet;
import java.util.Set;

public class LargestPlusSign {

	public int orderOfLargestPlusSign(int N, int[][] mines) {
		int[][] matrix = new int[N][N];
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				matrix[row][col] = 1;
			}
		}
		for(int[] mine : mines){
			matrix[mine[0]][mine[1]]=0;
		}

		int maxOrder = 0;
		
		for(int row=0; row<matrix.length; row++){
			for(int col=0; col<matrix[row].length; col++){
				int cell = 1;
				int tempOrder = 1;
				if(matrix[row][col]==1){
					maxOrder = Math.max(maxOrder, tempOrder);
					while (row-cell >=0 && matrix[row-cell][col] ==1
						&& row+cell < matrix.length && matrix[row+cell][col] == 1
						&& col-cell >=0 && matrix[row][col-cell] == 1
						&& col+cell < matrix[row].length && matrix[row][col+cell] == 1
					) {
						cell++;
						tempOrder++;
						maxOrder = Math.max(maxOrder, tempOrder);
					}
					
				}
			}
		}
		return maxOrder;
	}
	
	public int orderOfLargestPlusSignDP(int N, int[][] mines) {
        Set<Integer> banned = new HashSet<Integer>();
        int[][] dp = new int[N][N];
        
        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;
        
        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            
            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        
        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            
            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }
        
        return ans;
    }
	
	public static void main(String[] args) {
		LargestPlusSign plusSign = new LargestPlusSign();
//		System.out.println(plusSign.orderOfLargestPlusSign(5, new int[][] {{4,2}}));
		System.out.println(plusSign.orderOfLargestPlusSignDP(5, new int[][] {{4,2}}));
	}

}
