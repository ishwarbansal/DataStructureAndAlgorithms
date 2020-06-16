package com.data.structure.graph;

import java.util.ArrayList;
import java.util.LinkedList;

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
		graph.DFS(2);
	} 
} 
