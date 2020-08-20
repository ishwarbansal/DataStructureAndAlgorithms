package com.data.structure.math;

public class ExcelSheetColumnNumber {

	
	/*
	 * Given a column title as appear in an Excel sheet, return its corresponding
	 * column number.
	 * 
	 * For example:
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... Example 1:
	 * 
	 * Input: "A" Output: 1 Example 2:
	 * 
	 * Input: "AB" Output: 28 Example 3:
	 * 
	 * Input: "ZY" Output: 701
	 */
	
	public static int titleToNumber(String s) {
		System.out.println("Input BCD ");
        int result = 0;
        int index = s.length()-1;
        for(char c: s.toCharArray()){
            int d = c - 'A' + 1;
            int mul = 1;
            for(int i=0; i<index; i++) {
            	mul*=26;
            }
            result = result + (mul  * d);
            index--;
        }
        return result;
    }
	
	public static void main(String[] args) {
		System.out.println(titleToNumber("BCD"));
//		System.out.println(titleToNumber("A"));
//		System.out.println(titleToNumber("AB"));
//		System.out.println(titleToNumber("ZY"));
	}

}
