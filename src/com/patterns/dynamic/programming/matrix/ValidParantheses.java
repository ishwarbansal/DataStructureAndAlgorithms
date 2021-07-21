package com.patterns.dynamic.programming.matrix;

import java.util.Stack;

public class ValidParantheses {

	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<Character>(); 

		for(char ch : s.toCharArray()){
			if(ch=='(' || ch=='{' || ch=='['){
				stack.push(ch);
			}else if(!stack.isEmpty()) {
				char pop = stack.pop();
				if(
						(ch==')' && pop=='(') ||
						(ch=='}' && pop=='{') ||
						(ch==']' && pop=='[')
						){
					continue;
				}else {
					return false;
				}
			}else {
				return false;
			}
		}
		return stack.isEmpty();  
	}

	public static void main(String[] args) {
		System.out.println(new ValidParantheses().isValid("]"));
	}
}
