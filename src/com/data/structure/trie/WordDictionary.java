package com.data.structure.trie;

public class WordDictionary {

	/** Initialize your data structure here. */
	WordDictionary[] trie = null;
	boolean endOfWord;

	public WordDictionary() {
		trie = new WordDictionary[26];
		endOfWord = false;
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		WordDictionary curr = this;

		for(char ch: word.toCharArray()){
			if(curr.trie[ch - 'a']==null)
				curr.trie[ch - 'a'] = new WordDictionary();

			curr = curr.trie[ch-'a'];
		}
		curr.endOfWord = true;

	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		WordDictionary curr = this;

		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);
			if(ch=='.'){
				for(WordDictionary wd : curr.trie){
					if(wd != null && wd.search(word.substring(i+1)))
						return true;
				}
				return false;
			}

			if(curr.trie[ch-'a']==null)
				return false;
			curr = curr.trie[ch-'a'];
		}
		return curr!=null && curr.endOfWord;
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		wordDictionary.addWord("made");
		System.out.println("pad : " + wordDictionary.search("pad")); // return False
		System.out.println("bad : " + wordDictionary.search("bad")); // return True
		System.out.println(".ad : " + wordDictionary.search(".ad")); // return True
		System.out.println("b.. : " + wordDictionary.search("b..")); // return True
	}

}
