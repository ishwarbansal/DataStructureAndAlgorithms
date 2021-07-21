package com.data.structure.math;

public class UglyNumber {

	int getNthUglyNoII(int n) 
	{ 
		int ugly[] = new int[n];  // To store ugly numbers 
		
		int i2 = 0, i3 = 0, i5 = 0; 
		
		int next_multiple_of_2 = 2; 
		int next_multiple_of_3 = 3; 
		int next_multiple_of_5 = 5; 
		
		int next_ugly_no = 1; 

		ugly[0] = 1; 

		for(int i = 1; i < n; i++) 
		{ 
			next_ugly_no = Math.min(next_multiple_of_2, 
					Math.min(next_multiple_of_3, 
							next_multiple_of_5)); 

			ugly[i] = next_ugly_no; 
			if (next_ugly_no == next_multiple_of_2) 
			{ 
				i2 = i2+1; 
				next_multiple_of_2 = ugly[i2]*2; 
			} 
			if (next_ugly_no == next_multiple_of_3) 
			{ 
				i3 = i3+1; 
				next_multiple_of_3 = ugly[i3]*3; 
			} 
			if (next_ugly_no == next_multiple_of_5) 
			{ 
				i5 = i5+1; 
				next_multiple_of_5 = ugly[i5]*5; 
			} 
		} /*End of for loop (i=1; i<n; i++) */
		return next_ugly_no; 
	}
	
	public int nthUglyNumber(int n, int a, int b, int c) {
        int ugly[] = new int[n+1];  // To store ugly numbers 
		
		int ia = 0, ib = 0, ic = 0; 
		
		int next_multiple_of_a = a; 
		int next_multiple_of_b = b; 
		int next_multiple_of_c = c; 

        int next_ugly_no = 1;
        ugly[0] = 1;
		for(int i = 1; i <= n; i++) 
		{ 
			next_ugly_no = Math.min(next_multiple_of_a, 
					Math.min(next_multiple_of_b, 
							next_multiple_of_c)); 

			ugly[i] = next_ugly_no; 
			if (next_ugly_no == next_multiple_of_a) 
			{ 
				ia = ia+1; 
				next_multiple_of_a = ugly[ia]*a; 
			} 
			if (next_ugly_no == next_multiple_of_b) 
			{ 
				ib = ib+1; 
				next_multiple_of_b = ugly[ib]*b; 
			} 
			if (next_ugly_no == next_multiple_of_c) 
			{ 
				ic = ic+1; 
				next_multiple_of_c = ugly[ic]*c; 
			} 
		} /*End of for loop (i=1; i<n; i++) */
		return next_ugly_no; 
    }
	
	public static void main(String[] args) {
		UglyNumber number = new UglyNumber();
//		System.out.println(number.getNthUglyNoII(7));
		System.out.println(number.nthUglyNumber(3,2,3,5));
	}
}
