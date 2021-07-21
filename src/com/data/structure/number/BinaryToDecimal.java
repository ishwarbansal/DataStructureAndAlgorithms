package com.data.structure.number;

public class BinaryToDecimal {

	public void convertBinaryToDecimal(String binaryString) {
		int decimal=Integer.parseInt(binaryString,2);  
		System.out.println("convertBinaryToDecimal");
		System.out.println("Decimal of binary "+ binaryString + " is " +decimal);  
		System.out.println("");
	}
	
	public void convertBinaryToDecimalCustom1(String binaryString) {
		int decimal = 0;
		char ch [] = binaryString.toCharArray();
		int pow=0;
		for(int index=ch.length-1; index>=0; index--) {
			decimal+= Math.pow(2, pow++) * (ch[index]-48);
		}
		System.out.println("convertBinaryToDecimalCustom1");
		System.out.println("Decimal of binary "+ binaryString + " is " +decimal);
		System.out.println("");
	}

	public void convertBinaryToDecimalCustom2(String binaryString) {
		int decimal = 0;
		
		for(char ch: binaryString.toCharArray()) {
			decimal = decimal * 2 + (ch - 48);
		}
		System.out.println("convertBinaryToDecimalCustom2");
		System.out.println("Decimal of binary "+ binaryString + " is " +decimal);
		
	}
	
	public static void main(String[] args) {
		new BinaryToDecimal().convertBinaryToDecimal("1011");
		new BinaryToDecimal().convertBinaryToDecimalCustom1("1010");
		new BinaryToDecimal().convertBinaryToDecimalCustom2("1110");
	}

}
