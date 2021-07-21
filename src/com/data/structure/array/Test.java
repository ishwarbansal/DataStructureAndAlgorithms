package com.data.structure.array;

public class Test {
	
	
	public int getMoneyAmount(int n) {
        int[][] table = new int[n+1][n+1];
        int ans =  DP(table, 1, n);
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		System.out.print(table[i][j] + "     ");
        	}
        	System.out.println("");
        }
        System.out.println("");
        return ans;
	}
    
    int DP(int[][] t, int s, int e){
        if(s >= e) return 0;
        if(t[s][e] != 0) return t[s][e];
        int res = Integer.MAX_VALUE;
        for(int x=s; x<=e; x++){
            int tmp = x + Math.max(DP(t, s, x-1), DP(t, x+1, e));
            res = Math.min(res, tmp);
        }
        t[s][e] = res;
        return res;
    }
    
	public static void main(String[] args) {
		
		Test test = new Test();
		System.out.println(test.getMoneyAmount(3));
	}

}