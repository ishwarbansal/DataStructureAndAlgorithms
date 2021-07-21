package com.data.structure.stack;

import java.util.LinkedList;

abstract class Animal{
	private int order;
	private String name;

	public Animal(String name) {
		this.name = name;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
	
	public String getName() {
		return this.name;
	}
}

class Dog extends Animal{
	public Dog(String name) {
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name) {
		super(name);
	}
}

public class AnimalShelter {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order =0;

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;

		if(a instanceof Dog)
			dogs.addLast((Dog)a);
		else if (a instanceof Cat)
			cats.addLast((Cat)a);
	}

	public Animal dequeueAny() {
		if(dogs.size()==0)
			return cats.pop();
		else if (cats.size()==0)
			return dogs.pop();

		if(dogs.peek().isOlderThan(cats.peek())){
			return dogs.poll();
		}else {
			return cats.poll();
		}
	}

	public static void main(String[] args) {
		Animal dog = new Dog("Oreo");
		Animal cat = new Cat("Lily");
		Animal cat2 = new Cat("Marry");
		Animal dog2 = new Dog("Sheru");
		
		AnimalShelter obj = new AnimalShelter();
		obj.enqueue(dog);
		obj.enqueue(cat2);
		obj.enqueue(cat);
		obj.enqueue(dog2);
		
		Animal animal = obj.dequeueAny();
		System.out.println(animal.getName());
		
		
		animal = obj.dequeueAny();
		System.out.println(animal.getName());
		
		animal = obj.dequeueAny();
		System.out.println(animal.getName());
	}
}