package com.data.structure.array;

public class URLify {

	public void replaceSpaces(char[] str, int trueLength) {
		int countSpaces = countSpaces(str, 0, trueLength);
		int newIndex = trueLength - 1 + countSpaces * 2;
		
		if(newIndex+1<str.length)
			str[newIndex+1] = '\0';
		
		for(int oldIndex = trueLength-1; oldIndex>=0; oldIndex--) {
			if(str[oldIndex]==' ') {
				str[newIndex--]='0';
				str[newIndex--]='2';
				str[newIndex--]='%';
			}else {
				str[newIndex] = str[oldIndex];
				newIndex--;
			}
		}
	}
	
	private int countSpaces(char[] str, int startIndex, int lastIndex) {
		int count=0;
		for(int i=startIndex; i<lastIndex; i++) {
			if(str[i]==' ')
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		URLify urLify = new URLify();
		char[] str = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h',' ',' ',' ',' ',' ',' '};
		urLify.replaceSpaces(str, 13);
		for(char ch:str) {
			System.out.println(ch);
		}
		
	}
}
