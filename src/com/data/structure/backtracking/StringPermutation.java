package com.data.structure.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutation {

	public static List<char[]> permutationList = new ArrayList<char[]>();
	
	public void getStringPermutation(char[] arr, char[] result, int[] count, int level) {
		if(level==count.length) {
			permutationList.add(Arrays.copyOf(result, result.length));
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(count[i]==1) {
				count[i]--;
//				System.out.println(arr[i]);
				result[level] = arr[i];
				getStringPermutation(arr, result, count, level+1);
				count[i]++;
			}
		}
	}
	
	public static void main(String[] args) {
		StringPermutation permutation = new StringPermutation();
		permutation.getStringPermutation(new char[] {'A','B','C','D'}, new char[4], new int[] {1,1,1,1}, 0);
		
		for(char[] charArr : permutationList) {
			for(char ch: charArr) {
				System.out.print(ch + " ");
			}
			System.out.println("");
		}
	}

}
