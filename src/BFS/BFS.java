package BFS;

import java.util.LinkedList;

import DFS.Graph;


/*
 * Complexity = O(V+E)
 */

public class BFS {
	
	public static void main(String[] args) {
		Graph g = new Graph(8);
		

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
		
		bfs(g, 2);
	}
	
	public static void  bfs(Graph g, int start) {
		
		// Keep a visited array that initially has visited = false for each node
		boolean[] visited = new boolean[g.size()];
		
		// mark visited=true for the starting node
		visited[start] = true;
		System.out.println(start);
		
		// Initialize a queue;
		LinkedList<Integer> q = new LinkedList<>();
		
		// Add the start node to the LinkedList
		q.add(start);
		
		// As long as a queue is not empty
		while(!q.isEmpty()) {
			// Hold the element of the queue
			int element = q.pop();
			
			int i=0; // loop variable
			
			// For each neighbor of the element
			while(i < g.getNeighbors(element).size()) {
				// If a neighbor is not visited
				if(!visited[g.getNeighbors(element).get(i)]) {
					System.out.println(g.getNeighbors(element).get(i)); // Return the element
					q.add(g.getNeighbors(element).get(i)); // Add the element to the queue
					visited[g.getNeighbors(element).get(i)] = true; // and mark it as visited
				}
				i++; // loop ends
			}
		}
		
		
	}
	
	
	

}
