package com.leetcode.challenge.april2020.week2;

import java.util.Collections;
import java.util.PriorityQueue;

public class DayFourth {

	public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(int val : stones)
			queue.add(val);
			
		while (!queue.isEmpty()) {
            int firstElement = queue.poll();
            if(queue.isEmpty())
            	return firstElement;
            
            int secondElement = queue.poll();
            
            if(firstElement > secondElement)
            	queue.offer(firstElement-secondElement);
            else
            	queue.offer(secondElement-firstElement);
            
        }
		
		return 0;
	}

	public static void main(String[] args) {
		DayFourth dayFourth = new DayFourth();
		System.out.println(dayFourth.lastStoneWeight(new int[] {2,7,4,1,8,1}));
	}

}
