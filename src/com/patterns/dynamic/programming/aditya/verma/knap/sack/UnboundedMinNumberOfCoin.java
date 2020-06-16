package com.patterns.dynamic.programming.aditya.verma.knap.sack;

public class UnboundedMinNumberOfCoin {

	int[][] b;

	public UnboundedMinNumberOfCoin(int n, int w) {
		b = new int[n][w];
	}

	public int getCoinChangeUsingRecurssion(int[] arr, int sum, int n) {
		if(sum==0 || n==0)
			return 0;

		if(n==1) {
			return sum%arr[n-1]==0 ? sum/arr[n-1] : -1;
		};

		if(arr[n-1]<=sum) {
			int temp1 = getCoinChangeUsingRecurssion(arr, sum-arr[n-1], n-1);
			int temp2 = getCoinChangeUsingRecurssion(arr, sum, n-1);
			return Math.min(1+temp1 , temp2);
		}else {
			return getCoinChangeUsingRecurssion(arr, sum, n-1);
		}
	}

	public int getCoinChangeUsingDP(int[] arr, int sum, int n) {
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=sum; j++) {
				if(j==0)
					b[i][j] = 0;
				else if(i==0)
					b[i][j] = Integer.MAX_VALUE-1;
				else if(i==1) {
					if(j%arr[i-1]==0)
						b[i][j] = j/arr[i-1];
					else
						b[i][j] = Integer.MAX_VALUE-1;
				}
					
			}
		}

		for(int i=2; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(arr[i-1]<=j) {
					b[i][j] =  Math.min(1+b[i-1] [j-arr[i-1]] , b[i-1][j]);
				}else
					b[i][j]= b[i-1][j];
			}
		}		
		printSelectedElements(b, arr, sum);
		return b[n][sum];
	}
	
	private void printSelectedElements(int bp[][], int[] arr, int sum){
		System.out.println("-----------");
		
		for(int i=0; i<bp.length; i++) {
			for(int j=0; j<bp[i].length; j++) {
				System.out.print(bp[i][j] + "  ");
			}
			System.out.println("");
		}
		System.out.println("-----------");		
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};

		int sum = 5;

		UnboundedMinNumberOfCoin testDP = new UnboundedMinNumberOfCoin(arr.length+1, sum+1);
		System.out.println("getCoinChangeUsingRecurssion  "+ testDP.getCoinChangeUsingRecurssion(arr, sum, arr.length));
		System.out.println("getCoinChangeUsingDP  "+ testDP.getCoinChangeUsingDP(arr, sum, arr.length));
	}
}
