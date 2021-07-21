package com.data.structure.number;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIteration {

	public SetIteration() {
		Set<String> set = new HashSet();
		set.add("Apple");
		set.add("Banana");
		set.add("Orange");
		set.add("Pineapple");
		set.add("Qiwi");
		
		System.out.println("------------- Using Iterator -----------");
		Iterator<String> entries = set.iterator();
		while(entries.hasNext()) {
			System.out.println("Value is " + entries.next());
		}
		
		System.out.println("");
		System.out.println("------------- Iterator without using Iterator-----------");
		for(String val : set) {
			System.out.println("Value is " + val);
		}
		
		
	}
	
	public static void main(String[] args) {
		SetIteration obj = new SetIteration();
	}

}
