package com.data.structure.number;

public class CharToInt {

	/*Java char to int Example: Get ASCII value
		Let's see the simple code to convert char to int in java.
	 */	public void CharToIntExample1(){  
		 char c='a';  
		 char c2='1';  
		 int a=c;       
		 int b=c2;  
		 System.out.println(a);  
		 System.out.println(b);  
	 }
	 //	 Output:
	 //		 97
	 //		 49


	 /*Java char to int Example: Character.getNumericValue()
		Let's see the simple code to convert char to int in java using Character.getNumericValue(char) method which returns an integer value.
	  */
	 public void CharToIntExample2(){  
		 char c='1';  
		 int a=Character.getNumericValue(c);  
		 System.out.println(a);  
	 }
	 //Output:
	 //1

	 /*Java char to int Example: String.valueOf()
	 Let's see another example which returns integer value of specified char value using String.valueOf(char) method.*/	 
	 public void CharToIntExample3(){  
		 char c='1';  
		 int a=Integer.parseInt(String.valueOf(c));  
		 System.out.println(a);  
	 }

	 //	 Output:
	 //	 1

}
