package com.data.structure.number;

public class Employee {

	Integer id;
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		if(id<=5)
			return 1;
		if(id<=10)
			return 2;
		return id;
	}	
	
}
