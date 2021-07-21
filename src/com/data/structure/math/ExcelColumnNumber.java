package com.data.structure.math;

public class ExcelColumnNumber {

	public int titleToNumber(String A) {

		char[] ch = A.toCharArray();

		int val = 0;


		for(int i=0; i<ch.length; i++){
			val*=26;
			val+=ch[i]-'A'+1;
			System.out.println(val);
		}

		return val;
	}

	public int titleToNumber2(String A) {

		char[] ch = A.toCharArray();

		int val = 0;
		int len = A.length()-1;

		for(int i=0; i<ch.length; i++){
			val+=Math.pow(26, len--)*(ch[i]-'A'+1);
		}

		return val;
	}

	
	public static void main(String[] args) {
		System.out.println(new ExcelColumnNumber().titleToNumber("AZA"));
	}

}
