package com.leetcode.challenge.may2020.week2;

public class Trie {

	 /** Initialize your data structure here. */
	Trie[] children;
	boolean isEndOfWord;
    public Trie() {
       children = new Trie[26];
       isEndOfWord = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie curr = this;
    	for(char c : word.toCharArray()) {
    		if(curr.children[c - 'a']==null) {
    			curr.children[c - 'a'] = new Trie();
    		}
    		curr = curr.children[c - 'a'];
    	}
    	curr.isEndOfWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie curr = this;
    	for(char c : word.toCharArray()) {
    		curr = curr.children[c - 'a'];
    		if(curr==null) {
    			return false;
    		}
    	}
    	if(curr.isEndOfWord) {
    		return true;
    	}
    	return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie curr = this;
    	for(char c : prefix.toCharArray()) {
    		curr = curr.children[c - 'a'];
    		if(curr==null) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	Trie trie = new Trie();
    	trie.insert("apple");
    	System.out.println(trie.search("apple"));   // returns true
    	System.out.println(trie.search("app"));     // returns false
    	System.out.println(trie.startsWith("app")); // returns true
    	trie.insert("app");   
    	System.out.println(trie.search("app"));     // returns true
	}
}




 