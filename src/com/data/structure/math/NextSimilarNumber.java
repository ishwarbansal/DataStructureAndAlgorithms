package com.data.structure.math;

import java.util.Arrays;

public class NextSimilarNumber {

	public int solve(int e) {
		String A = e+"";
		char ar[] = A.toCharArray();
		int n = A.length();

		int i; 

		// I) Start from the right most digit  
		// and find the first digit that is smaller  
		// than the digit next to it. 
		for (i = n - 1; i > 0; i--)  
		{ 
			if (ar[i] > ar[i - 1]) { 
				break; 
			} 
		} 

		// If no such digit is found, then all  
		// digits are in descending order means  
		// there cannot be a greater number with  
		// same set of digits 
		if (i == 0)  
		{ 
			//			System.out.println("Not possible"); 
			return -1;
		}  
		else 
		{ 
			int x = ar[i - 1], min = i; 

			// II) Find the smallest digit on right  
			// side of (i-1)'th digit that is greater  
			// than number[i-1] 
			for (int j = i + 1; j < n; j++)  
			{ 
				if (ar[j] > x && ar[j] < ar[min])  
				{ 
					min = j; 
				} 
			} 

			// III) Swap the above found smallest  
			// digit with number[i-1] 
			swap(ar, i - 1, min); 

			// IV) Sort the digits after (i-1)  
			// in ascending order 
			Arrays.sort(ar, i, n); 

			StringBuilder st = new StringBuilder();
			for(int j=0; j<ar.length; j++){
				st.append(ar[j]);
			}
			return Integer.parseInt(st.toString());
		}
	}
	private void swap(char ar[], int i, int j) { 
		char temp = ar[i]; 
		ar[i] = ar[j]; 
		ar[j] = temp; 
	}  


	public static void main(String[] args) {
		NextSimilarNumber nextSimilarNumber = new NextSimilarNumber();
		System.out.println(nextSimilarNumber.solve(576));
	}
}




