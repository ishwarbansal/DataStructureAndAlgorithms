package com.data.structure.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Palindrome {

public String solve(String A) {
        
        int isPalindrome = isPalindrome(A);
        char[] result ;
        char[] ch = A.toCharArray();
        if(isPalindrome==9)
            result = new char[A.length()+1];
        else
            result = new char[A.length()];
            
        int start=0, end=result.length-1;
        
        if(isPalindrome==9){
            result[start++]='1';
            result[end--]='1';
            
            while(start<=end){
                result[start++] = '0';
            }    
        } else if (isPalindrome==1){
            int n = result.length;
            int carry = 1;
            int left = (n/2)-1;
            int right = n/2;
            if(n%2!=0){
                int val = Character.getNumericValue(ch[n/2])+1;
                carry = val/10;
                result[n/2] = (char)(val%10 + '0');
                right++;
            }
             
            while(left>=0){
                int val = Character.getNumericValue(ch[left])+carry;
                carry = val/10;
                result[left] = (char)(val%10 + '0');
                result[right++] = result[left--];
            }
        }  else {
            int n = A.length();
            int left = (n/2)-1;
            int right = n/2;
            
            if(n%2!=0){
                result = new char[A.length()+1];
                int val = Character.getNumericValue(ch[n/2]);
                result[n/2] = (char)(val + '0');
                right++;
            }
            
            int carry = 1;
            while(left>=0){
                int val = Character.getNumericValue(ch[left]) + carry;
                carry = val / 10;
                result[left] = (char)(val%10 + '0');
                result[right++] = result[left--];
            }
        }
        return new String(result);
    }
    
    public int isPalindrome(String A){
        int start=0, end=A.length()-1;
        char[] ch = A.toCharArray();
        
        boolean allNine = true;
        
        while(start<end){
            if(ch[start++]!=ch[end--])
                return 0;
                
            if(ch[start]!='9')
                allNine = false;
        }
        
        return allNine? 9 : 1;
    }    
    public static void main(String[] args) {
//		System.out.println(new Test().solve("12134"));
//    	System.out.println(new Test().minOperations(new int[] {3, 2,20,1,1,3}, 10));
//    	
//    	Map<Integer, Character> map = new HashMap<>();
//    	map.put(1, 'c');
//    	map.put(2, 'd');
//    	map.put(1, 'r');
//    	System.out.println(map.size());
    	
//    	System.out.println(closeStrings("cabbba", "abbccc"));
    	char ch = 'A';
    	int val = ch;
    	System.out.println(val);
    	val = ch - 65;
    	System.out.println(val);
	}
    
    public static boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        
        int[] f1 = new int[26];
        int[] v1 = new int[26];
        for(char c : word1.toCharArray()) {
            f1[c - 'a']++;
            v1[c - 'a'] = 1;   
        }
        
        int[] f2 = new int[26];
        int[] v2 = new int[26];
        for(char c : word2.toCharArray()) {
            f2[c - 'a']++;
            v2[c - 'a'] = 1;
        }
        
        Arrays.sort(f1);
        Arrays.sort(f2);
        
        return Arrays.equals(f1, f2) && Arrays.equals(v1, v2);
    }
    
    
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x;
        int n = nums.length, windowSize = -1, current = 0;
        
        for (int right = 0, left = 0; right < n; right++) {
            current += nums[right];
            while (current > target && left <= right)
                current -= nums[left++];
            
            if (current == target)
                windowSize = Math.max(windowSize, right - left + 1);
        }
        return windowSize != -1 ? n - windowSize : -1;
    }
    
    
}

