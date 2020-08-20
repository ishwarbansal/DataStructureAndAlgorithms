package com.data.structure.string;

import java.util.LinkedList;
import java.util.Queue;

/*Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.


Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 */

class CombinationIterator {

	private String s;
	private Queue<String> queue;

	public CombinationIterator(String characters, int combinationLength) {
		s = characters;
		queue = new LinkedList<String>();
		getCombination(0, combinationLength, new StringBuilder());
	}

	private void getCombination(int start, int length, StringBuilder txt){
		if(length==0){
			queue.add(txt.toString());
			return;
		}

		for(int i=start; i<=s.length()-length; i++){
			txt.append(s.charAt(i));
			getCombination(i+1, length-1, txt);
			txt.deleteCharAt(txt.length()-1);
		}
	}

	public String next() {
		return queue.poll();
	}

	public boolean hasNext() {
		return !queue.isEmpty();
	}
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */