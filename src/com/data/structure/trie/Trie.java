package com.data.structure.trie;

import java.util.ArrayList;
import java.util.List;

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
		return curr.isEndOfWord;
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

	/** Returns all the word in the trie that starts with the given prefix. */
	public List<String> findAllWordStartsWith(String prefix) {
		Trie curr = this;
		for(char c : prefix.toCharArray()) {
			curr = curr.children[c - 'a'];
			if(curr==null) {
				return null;
			}
		}
		List<String> wordList = new ArrayList<>();
		search(curr, prefix, wordList);
		return wordList;
	}

	/** Returns List of word from the trie which start with word. */
	public void search(Trie curr, String word, List<String> wordList) {
		for(int index=0; index<26; index++) {
			Trie subChild = curr.children[index];
			if(subChild!=null) {
				if(subChild.isEndOfWord) {
					wordList.add(word + (char) (index + 97));
				}
				search(subChild, word + (char) (index + 97), wordList);
			}
		}
	}

	public static void main(String[] args) {
		/*
		 *Trie trie = new Trie();
    	trie.insert("apple");
    	trie.search("apple");   // return True
    	trie.search("app");     // return False
    	trie.startsWith("app"); // return True
    	trie.insert("app");
    	trie.search("app");     // return True
		 */	

		Trie trie = new Trie();
		trie.insert("man");
		trie.insert("mango");
		trie.insert("manager");
		trie.insert("many");

		List<String> list = trie.findAllWordStartsWith("man");
		if(list==null) {
			System.out.println("No word found which starts with Man");
		}else {
			for(String word : list) {
				System.out.println(word);
			}
		}

	}
}
