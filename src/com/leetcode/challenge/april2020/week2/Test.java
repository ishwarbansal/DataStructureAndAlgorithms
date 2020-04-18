package com.leetcode.challenge.april2020.week2;

public class Test {

	public static void main(String[] args) 
    { 
        MyStack s = new MyStack(); 
        s.push(3); 
        s.push(5); 
        s.getMin(); 
        s.push(2); 
        s.push(1);
        s.push(-3); 
        s.push(-5); 
        s.getMin(); 
        s.pop(); 
        s.getMin(); 
        s.pop(); 
        s.peek(); 
    } 
}
