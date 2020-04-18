package com.patterns.modify.binary.search;

public class NextLetter {

	public static char searchNextLetter(char[] letters, char key) {
		if (key >= letters[letters.length - 1]) // if the 'key' is bigger than the biggest element
		      return letters[0];
	
		int start = 0; int end = letters.length-1;
		
		while(start<=end) {
			int mid = start + (end-start)/2;
			
			if(key == letters[mid])
				return mid >= letters.length-1 ? letters[0] : letters[mid+1];
			
			if(key>letters[mid])
				start = mid + 1;
			else
				end = mid - 1;
		}
		
		return letters[start];
	}

	public static void main(String[] args) {
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
		System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
	}


}
