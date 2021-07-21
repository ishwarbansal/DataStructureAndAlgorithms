package com.data.structure.number;

public class SmallestStringGivenNumber {

	public String getSmallestString(int n, int k) {

		char[] result = new char[n];
        int idx = n-1;

        while(k-26 > idx){
            result[idx--] = 'z';
            k-=26;
        }
        
        result[idx] = (char)(k - idx + 'a' - 1 );
        
        for(int num=0; num<idx; num++){
			result[num] = 'a';
		}
        
		return new String(result);  
	        
	}


	public static void main(String[] args) {
		System.out.println(new SmallestStringGivenNumber().getSmallestString(5,73));
	}

}
