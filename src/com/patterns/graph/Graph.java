package com.patterns.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {

	private int V;   // No. of vertices 

	public ArrayList<ArrayList<Integer>> adj = null;

	// Constructor 
	Graph(int v){ 
		V = v; 
		adj = new ArrayList<ArrayList<Integer> >(V);
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 
	} 

	// A utility function to add an edge in an 
	// undirected graph 
	void addEdge(int u, int v) { 
		adj.get(u).add(v); 
		adj.get(v).add(u); 
	} 

	// A utility function to print the adjacency list 
	// representation of graph 
	void printGraph(ArrayList<ArrayList<Integer> > adj){ 
		for (int i = 0; i < adj.size(); i++) { 
			System.out.println("\nAdjacency list of vertex" + i); 
			for (int j = 0; j < adj.get(i).size(); j++) { 
				System.out.print(" -> "+adj.get(i).get(j)); 
			} 
			System.out.println(); 
		} 
	} 

	// prints BFS traversal from a given source s 
	public void BFS(int s)  { 
		// Mark all the vertices as not visited(By default 
		// set as false) 
		boolean visited[] = new boolean[V]; 

		// Create a queue for BFS 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 

		// Mark the current node as visited and enqueue it 
		visited[s]=true; 
		queue.add(s); 

		while (!queue.isEmpty()) 
		{ 
			// Dequeue a vertex from queue and print it 
			s = queue.poll(); 
			System.out.print(s+" "); 

			// Get all adjacent vertices of the dequeued vertex s 
			// If a adjacent has not been visited, then mark it 
			// visited and enqueue it 
			ArrayList<Integer> adjacentList = adj.get(s); 
			for(Integer n : adjacentList) 
			{ 
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 
	} 


	// A function used by DFS 
	void DFSUtil(int v,boolean visited[]) 
	{ 
		// Mark the current node as visited and print it 
		visited[v] = true; 
		System.out.print(v+" "); 

		// Recur for all the vertices adjacent to this vertex 
		ArrayList<Integer> adjacentList = adj.get(v); 
		for(Integer n : adjacentList) 
		{ 
			if (!visited[n]) 
				DFSUtil(n, visited); 
		} 
	} 

	// The function to do DFS traversal. It uses recursive DFSUtil() 
	void DFS(int v) 
	{ 
		// Mark all the vertices as not visited(set as 
		// false by default in java) 
		boolean visited[] = new boolean[V]; 

		// Call the recursive helper function to print DFS traversal 
		DFSUtil(v, visited); 
	} 

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
		for (int[] f : flights) {
			if (!prices.containsKey(f[0])) 
				prices.put(f[0], new HashMap<>());

			prices.get(f[0]).put(f[1], f[2]);
		}

		Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (Integer.compare(a[0], b[0])));

		pq.add(new int[] {0, src, k + 1});

		while (!pq.isEmpty()) {
			int[] top = pq.remove();
			int price = top[0];
			int city = top[1];
			int stops = top[2];

			if (city == dst) 
				return price;

			if (stops > 0) {
				Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());

				for (int a : adj.keySet()) {
					pq.add(new int[] {price + adj.get(a), a, stops - 1});
				}
			}
		}
		return -1;
	}

	class Node{
		int id;
		int cost;
		public Node(int id, int cost) {
			super();
			this.id = id;
			this.cost = cost;
		}
	}

	public int networkDelayTime(int[][] times, int N, int K) {
		Map<Integer, List<Node>> map = new HashMap<>();
		for(int[] time : times){
			map.putIfAbsent(time[0], new ArrayList<>());
			map.get(time[0]).add(new Node(time[1],time[2]));          
		}

		//distance, node into pq
		Queue<Node> pq = new PriorityQueue<>((a,b) -> (a.cost - b.cost));

		pq.add(new Node(K,0));

		boolean[] visited = new boolean[N+1];
		int res = 0;

		while(!pq.isEmpty()){
			Node cur = pq.remove();
			int curNode = cur.id;
			int curDist = cur.cost;
			if(visited[curNode]) continue;
			visited[curNode] = true;
			res = curDist;
			N--;
			if(map.containsKey(curNode)){
				for(Node next : map.get(curNode)){
					pq.add(new Node(next.id,curDist+next.cost));
				}
			}
		}
		return N == 0 ? res : -1;
	}
	// Driver Code 
	public static void main(String[] args){
		// Creating a graph with 5 vertices
		Graph graph = new Graph(5);

		// Adding edges one by one 
		graph.addEdge(0, 1); 
		graph.addEdge(0, 4); 
		graph.addEdge(1, 2); 
		graph.addEdge(1, 3); 
		graph.addEdge(1, 4); 
		graph.addEdge(2, 3); 
		graph.addEdge(3, 4); 

		//		graph.BFS(2);
		//		graph.DFS(2);

		//		System.out.println(graph.findCheapestPrice(3, new int[][] {{0,1,100},{1,2,100},{0,2,500}},0,2,1));

		//		System.out.println(graph.findCheapestPrice(7, new int[][] {{0,4,240},{0,1,50},{1,5,180},{5,2,300},{4,3,90},{3,2,20}},0,2,2));

		System.out.println(graph.networkDelayTime(new int[][] {{1,2,1},{2,3,2},{1,3,2}},3,1));

	} 
} 
