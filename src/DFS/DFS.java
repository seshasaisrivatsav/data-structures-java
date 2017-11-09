package DFS;

import java.util.Iterator;


/*
 * Complexity = O(V+E)
 */
public class DFS {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		 
		g.printGraph();
		//g.printGraph();
		 dfs(2, g );
		
	}
	
	public static void dfs(int node, Graph g) {
		boolean[] visited = new boolean[g.size()]; // set all nodes to not visited (false)
		dfsUtil(node, visited, g);
		
	}
	
	public static void dfsUtil(int node, boolean[] visited, Graph g) {
		visited[node] = true;
		System.out.print(node + " ");
		
		// Neighbors of node 
		int i=0;
		
		// for each neighbor
		while(i< g.getNeighbors(node).size()) {
			// if neighbor is not visited
			if(!visited[g.getNeighbors(node).get(i)]) {
				dfsUtil(g.getNeighbors(node).get(i), visited, g);
			}
			i++;
		}
		 
		
	}
}
