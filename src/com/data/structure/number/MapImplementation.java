package com.data.structure.number;

import java.util.HashMap;

public class MapImplementation {

	public MapImplementation() {
		
		HashMap<Employee, Integer> map = new HashMap<>();
		Employee e1 = new Employee(1, "A");
		map.put(e1, 1);
		
		Employee e6 = new Employee(6, "F");
		map.put(e6, 6);
		
		Employee e3 = new Employee(3, "C");
		map.put(e3, 3);
		
		System.out.println(map.size());
	}
	
	public static void main(String[] args) {
		MapImplementation obj = new MapImplementation();
	}

}
