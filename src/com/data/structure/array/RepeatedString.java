package com.data.structure.array;

public class RepeatedString {

	static long repeatedString(String s, long n) {
		long size = s.length(), repeated = n/size;
		long left = n - (size * repeated);
		int extra = 0;
	
		int count = 0;
		for(int i = 0; i < size; i++){
			if(s.charAt(i) == 'a'){
				++count;
			}
		}
	
		for(int i = 0; i < left; i++){
			if(s.charAt(i) == 'a'){
				++extra;
			}
		}
	
		repeated = (repeated * count) + extra;
	
		return repeated;
	}
	public static void main(String[] args) {
		System.out.println(repeatedString("aba", 10));
	}

}
