package com.data.structure.number;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapIteration {

	public MapIteration() {
		Map<Integer, String> hashMap = new HashMap<>();
		hashMap.put(1, "Apple");
		hashMap.put(2, "Banana");
		hashMap.put(3, "Orange");
		hashMap.put(4, "Pineapple");
		hashMap.put(5, "Qiwi");
		
		System.out.println("------------- Using KeySet -----------");
		for(Integer key : hashMap.keySet()) {
			System.out.println("Value of key " + key +" is "+hashMap.get(key));
		}
		
		System.out.println("");
		System.out.println("------------- Using Entry using Iterator-----------");
		Iterator<Map.Entry<Integer, String>> entries = hashMap.entrySet().iterator();
		while(entries.hasNext()) {
			Entry<Integer, String> entry = entries.next();
			System.out.println("Value of key " + entry.getKey() +" is "+ entry.getValue());
		}
		
		System.out.println("");
		System.out.println("------------- Using Entry Set without using Iterator-----------");
		for(Map.Entry<Integer, String> entry : hashMap.entrySet()) {
			System.out.println("Value of key " + entry.getKey() +" is "+ entry.getValue());
		}
		
	}
	
	public static void main(String[] args) {
		MapIteration obj = new MapIteration();
	}

}
