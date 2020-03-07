package com.pattern.first;
import java.util.HashMap;
import java.util.Map;
public class Test {
	public static int findSubstring  (char[] arr, char []k) {
		Map<Character,Integer> uniqueChar = new HashMap<Character, Integer>();
		int windowEnd = 0, windowStart = 0, matched = 0;

		for(char c: k)
			uniqueChar.put(c, 1);

		while(windowEnd < arr.length) { 
			char rightChar = arr[windowEnd];

			if(uniqueChar.containsKey(rightChar)) {
				uniqueChar.put(rightChar, uniqueChar.get(rightChar)-1);
				if(uniqueChar.get(rightChar)>=0) {
					matched++;
				}else {
					resetChar(uniqueChar);
					windowStart=windowEnd;
					matched=1;
				}
			}
			if(matched == k.length) {
				return windowEnd-windowStart+1; 
			} 
			windowEnd++; 
		}
		return -1;
	}

	public static int findSubstring2 (char[] arr, char []k) {
		Map<Character,Integer> uniqueChar = new HashMap<Character, Integer>();
		int windowEnd = 0, windowStart = 0, matched = 0, smallestSubStrLen = Integer.MAX_VALUE;

		for(char c: k)
			uniqueChar.put(c, 1);

		while(windowEnd < arr.length) { 
			char rightChar = arr[windowEnd];

			if(uniqueChar.containsKey(rightChar)) {
				uniqueChar.put(rightChar, uniqueChar.get(rightChar)-1);
				if(uniqueChar.get(rightChar)==0) {
					matched++;
				}
			}

			while(matched == k.length) {
				smallestSubStrLen =  Math.min(smallestSubStrLen, windowEnd-windowStart+1); 

				char leftChar = arr[windowStart];
				if(uniqueChar.containsKey(leftChar)) {
					if(uniqueChar.get(leftChar) == 0) {
						matched--;
					}
					uniqueChar.put(leftChar, uniqueChar.get(leftChar)+1);
				}
				windowStart++;
			}

			windowEnd++; 
		}
		return smallestSubStrLen;
	}

	public static void resetChar(Map<Character,Integer> uniqueChar) {
		for(Map.Entry<Character, Integer> entry : uniqueChar.entrySet()) {
			uniqueChar.put(entry.getKey(),1);
		}

	}

	public static void findWordConcatenation(String arr, String []k) {
		Map<String,Integer> uniqueStr = new HashMap<String, Integer>();
		int windowEnd = 0, windowStart = 0, matched = 0;
		int searchWordLen = 3;

		for(String st: k) 
			uniqueStr.put(st, 1);

		while(windowEnd < arr.length()-searchWordLen+1) {
			String rightStr = arr.substring(windowEnd,windowEnd+searchWordLen);

			if(uniqueStr.containsKey(rightStr)) {
				uniqueStr.put(rightStr, uniqueStr.get(rightStr)-1);
				if(uniqueStr.get(rightStr)==0) {
					matched++;
				}
				windowEnd = windowEnd + searchWordLen-1;
			}

			if(matched == k.length) {
				System.out.println(windowStart + " -- " + windowEnd);
			}

			if(windowEnd >= (k.length * searchWordLen -1)) {
				String leftStr = arr.substring(windowStart, windowStart + searchWordLen);
				if(uniqueStr.containsKey(leftStr)) {
					if(uniqueStr.get(leftStr)==0)
						matched--;	
					uniqueStr.put(leftStr, uniqueStr.get(leftStr)+1);
					windowStart = windowStart + searchWordLen;
				}else {
					windowStart++;
				}
			}

			windowEnd++;
		}


	}

	public static void main(String[] args) {
		String destStr = "catfoxcat";
		String targetStr[] = {"fox","cat"};
		Test.findWordConcatenation(destStr,targetStr);
	}

	public static void findWordConcatenation(char[] arr, char []k) { Map<Character,Integer> uniqueChar = new HashMap<Character, Integer>(); int windowEnd = 0, windowStart = 0, matched = 0;

	for(char c: k)
		uniqueChar.put(c, 1);

	while(windowEnd < arr.length) {
		char rightChar = arr[windowEnd];

		if(uniqueChar.containsKey(rightChar)) {
			uniqueChar.put(rightChar, uniqueChar.get(rightChar)-1);
			if(uniqueChar.get(rightChar)==0) {
				matched++;
			}
		}

		if(matched == k.length) {
			System.out.println(windowStart + " - - " + windowEnd); }

		if(k.length == windowEnd - windowStart + 1) { for(int i=0; i<3; i++) { char leftChar = arr[windowStart];
		if(uniqueChar.containsKey(leftChar)) {
			if(uniqueChar.get(leftChar) == 0) {
				matched--;
			}
			uniqueChar.put(leftChar, uniqueChar.get(leftChar)+1); }
		windowStart++;
		}
		}

		windowEnd++;
	}

	}
	//	public static void main(String[] args) {
	//		//		String destStr = "aabdec";
	//		//		String destStr = "abdabca";
	//		//		String destStr = "adcad";
	//		String destStr = "catfoxcat";
	//		char ch[] =destStr.toCharArray(); 
	//		String targetStr = "foxcat";
	//		char k[] = targetStr.toCharArray();
	//		Test.findWordConcatenation(ch,k);
	//	}

}
