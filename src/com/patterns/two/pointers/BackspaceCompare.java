package com.patterns.two.pointers;

public class BackspaceCompare {

	public static boolean compare(String str1, String str2) {
		
		int str1Len = str1.length()-1;
		int str2Len = str2.length()-1;
		
		int backspacFoundStr1 = 0;
		int backspacFoundStr2 = 0;
		
		while(str1Len >= 0 && str2Len >= 0 ) {
			
			while(str1.charAt(str1Len)=='#'){
				backspacFoundStr1++;
				str1Len--;
			}
			
			while(str2.charAt(str2Len)=='#') {
				backspacFoundStr2++;
				str2Len--;
			}
			
			str1Len = str1Len -  backspacFoundStr1 ;
			str2Len = str2Len -  backspacFoundStr2 ;
			
			if(str1.charAt(str1Len)!=str2.charAt(str2Len))
				return false;
			
			backspacFoundStr1 = 0;
			backspacFoundStr2 = 0;
			
			str1Len--;
			str2Len--;
		}

		return true;
	}

	public static void main(String[] args) {
//		String str1="xy#z", str2="xzz#"; // true
//		String str1="xy#z", str2="xyz#"; // false
		String str1="xp#", str2="xyz##"; // true
//		String str1="xywrrmp", str2="xywrrmu#p"; // true
		System.out.println(compare(str1, str2));

	}

}
