package com.patterns.top.k.elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {

	public static int scheduleTasks(char[] tasks, int k) {
		Map<Character, Integer> taskMap = new HashMap<Character, Integer>();
		for(char ch : tasks)
			taskMap.put(ch, taskMap.getOrDefault(ch, 0)+1);

		PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<Map.Entry<Character, Integer>>(
				(e1, e2) -> e2.getValue() - e1.getValue());

		// add all characters to the max heap
		maxHeap.addAll(taskMap.entrySet());


		Queue<Map.Entry<Character, Integer>> queue = new LinkedList<Map.Entry<Character, Integer>>();
		int maxIntervalNeeded = 0 ;
		while(!maxHeap.isEmpty()) {
			while(!maxHeap.isEmpty() && queue.size()<=k) {
				queue.offer(maxHeap.poll());
			}
			int printIdeal = k + 1 - queue.size();
			maxIntervalNeeded += queue.size();

			while(!queue.isEmpty()){
				Map.Entry<Character, Integer> task = queue.poll();
				System.out.print(task.getKey() + "  ");
				task.setValue(task.getValue()-1);
				if(task.getValue()>0) {
					maxHeap.offer(task);
				}
			}
			if(maxHeap.size()>0) {
				maxIntervalNeeded += printIdeal;
				
				for(int i=0; i<printIdeal; i++)
					System.out.print("Ideal  ");
			}
			System.out.println("");
		}
		return maxIntervalNeeded > 0 ? maxIntervalNeeded : -1;
	}

	public static void main(String[] args) {
		char[] tasks = new char[] {'d','d','d','d','d','d','d', 'a','a','a', 'a', 'a', 'b', 'b', 'c', 'c','e' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

		tasks = new char[] { 'a', 'b', 'a' };
		System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
	}


}
