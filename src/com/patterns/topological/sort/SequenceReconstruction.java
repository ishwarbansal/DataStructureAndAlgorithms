package com.patterns.topological.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SequenceReconstruction {

	public static boolean canConstruct(int[] originalSeq, int[][] sequences) {
		List<Integer> sortedOrder = new ArrayList<>();
		if (sequences.length <= 0)
			return false;

		// a. Initialize the graph
		HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
		HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph

		for(int[] sequence : sequences) {
			for (int i = 0; i < sequence.length; i++) {
				inDegree.put(sequence[i], 0);
				graph.put(sequence[i], new ArrayList<Integer>());
			}
		}

		// b. Build the graph
		for(int[] sequence : sequences) {
			for (int i = 0; i < sequence.length-1; i++) {
				int parent = sequence[i], child = sequence[i+1];
				graph.get(parent).add(child); // put the child into it's parent's list
				inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
			}
		}

		// c. Find all sources i.e., all vertices with 0 in-degrees
		Queue<Integer> sources = new LinkedList<>();
		for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
			if (entry.getValue() == 0)
				sources.add(entry.getKey());
		}

		// d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
		// if a child's in-degree becomes zero, add it to the sources queue
		while (!sources.isEmpty()) {
			if (sources.size() > 1)
				return false; 

			if (originalSeq[sortedOrder.size()] != sources.peek())
				return false; 

			int vertex = sources.poll();
			sortedOrder.add(vertex);
			List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
			for (int child : children) {
				inDegree.put(child, inDegree.get(child) - 1);
				if (inDegree.get(child) == 0)
					sources.add(child);
			}
		}

		if (sortedOrder.size() == originalSeq.length) {
			for(int i=0; i<sortedOrder.size(); i++) {
				if(sortedOrder.get(i)!=originalSeq[i]) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	public static void main(String[] args) {
		boolean result = false;

		result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 } });
		System.out.println("Can we uniquely construct the sequence: " + result);

		result = SequenceReconstruction.canConstruct(new int[] { 1, 2, 3, 4 },
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 2, 4 } });
		System.out.println("Can we uniquely construct the sequence: " + result);

		result = SequenceReconstruction.canConstruct(new int[] { 3, 1, 4, 2, 5 },
				new int[][] { new int[] { 3, 1, 5 }, new int[] { 1, 4, 2, 5 } });
		System.out.println("Can we uniquely construct the sequence: " + result);
	}


}
