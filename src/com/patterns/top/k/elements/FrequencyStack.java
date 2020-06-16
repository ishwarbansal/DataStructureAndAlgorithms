package com.patterns.top.k.elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencyStack {

	int sequenceNumber = 0;
	PriorityQueue<Element> maxHeap = new PriorityQueue<Element>(new ElementComparator());
	Map<Integer, Integer> frequencyMap = new HashMap<>();

	public void push(int num) {
		frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		maxHeap.offer(new Element(num, frequencyMap.get(num)+1, sequenceNumber++));
	}

	public int pop() {
		int num = maxHeap.poll().number;

		// decrement the frequency or remove if this is the last number
		if (frequencyMap.get(num) > 1)
			frequencyMap.put(num, frequencyMap.get(num) - 1);
		else
			frequencyMap.remove(num);

		return num;
	}

	public static void main(String[] args) {
		FrequencyStack frequencyStack = new FrequencyStack();
		frequencyStack.push(1);
		frequencyStack.push(2);
		frequencyStack.push(3);
		frequencyStack.push(2);
		frequencyStack.push(1);
		frequencyStack.push(2);
		frequencyStack.push(5);
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
		System.out.println(frequencyStack.pop());
	}


}
