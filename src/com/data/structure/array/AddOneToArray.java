package com.data.structure.array;

import java.util.ArrayList;

public class AddOneToArray {

//	Given a non-negative number represented as an array of digits,
//	add 1 to the number ( increment the number represented by the digits ).
//	The digits are stored such that the most significant digit is at the head of the list.
//
//	Example:
//	If the vector has [1, 2, 3]
//	the returned vector should be [1, 2, 4]
//	as 123 + 1 = 124.
	
	public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

		int n = A.size()-1;

		A.set(n, A.get(n) + 1); 
		int carry = A.get(n) / 10; 
		A.set(n, A.get(n) % 10);

		for(int i=n-1; i>=0; i--){
			if (carry == 1) 
			{ 
				A.set(i, A.get(i) + 1); 
				carry = A.get(i) / 10; 
				A.set(i, A.get(i) % 10); 
			} else{
				break;
			}
		}

		if(carry==1){
			A.add(0,1);
		}

		while(A.size()>0 && A.get(0)==0){
			A.remove(0);
		}

		return A;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(9);
		
		System.out.println(new AddOneToArray().plusOne(list));
	}

}
