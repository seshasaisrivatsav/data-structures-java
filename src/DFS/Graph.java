package DFS;

import java.util.LinkedList;

public class Graph {
	private int v; // number of vertices
	private LinkedList<Integer> adj[];// adjacency list
	
	//constructor
	public Graph(int v){
		this.v = v ;
		adj = new LinkedList[v];
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	// returns graph size = number of nodes
	public int size() {
		return v;
	}
	
	//
	public LinkedList<Integer> getNeighbors(int node) {
		return adj[node];
	}
	
	// add an edge to w for a node v
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public void printGraph() {
		for (int i=0; i<adj.length; i++) {
			System.out.println("node "+ i + ": neighbors"+ adj[i]);
		}
	}
	 
	
}
