package treesAndGraphs;

import treesAndGraphs.Graph;

import java.util.List;
import java.util.Stack;


/*
 * Time Complexity = O(V+E) => when adjacency list is used
 */
public class DFS_DepthFirstSearch_Graph {
	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
//		dfs(2, g );

		/*
				1

			4  2    3  5
		      6			8
		      7			  9
		 */
		Graph g2 = new Graph(9); // graph with 9 vertices
		g2.addEdge(1, 4);g2.addEdge(1, 2);g2.addEdge(1, 3); g2.addEdge(1, 5);
		g2.addEdge(4, 6);g2.addEdge(2, 6);
		g2.addEdge(6, 7);
		g2.addEdge(5, 8);
		g2.addEdge(8, 9);

		dfs_iterative(1, g2.size(), g2);
	}
	
	// Create a Util function, send a node, visited array
	// In Util Function - First mark the node as visited, for each neighbor, if not visited send it to Util again
	public static void dfs(int node, Graph g) {
		boolean[] visited = new boolean[g.size()]; // set all nodes to not visited (false)
		dfsUtil(node, visited, g); // pass the start node, visited array and graph to dfsUtil
	}
	
	public static void dfsUtil(int node, boolean[] visited, Graph g) {
		visited[node] = true; // Mark the node as visited
		System.out.print(node + " "); // Return the node
		int i=0; // Loop variable
		// for each neighbor of the input node
		while(i< g.getNeighbors(node).size()) {
			// if neighbor is not visited
			if(!visited[g.getNeighbors(node).get(i)]) {
				// Send it to the dfsUtil function
				dfsUtil(g.getNeighbors(node).get(i), visited, g);
			}
			i++; // Increment loop variable
		}
	}

	public static void dfs_iterative(int n, int v, Graph graph) {
		boolean[] visited = new boolean[v+1]; // initialize visited
		Stack<Integer> stack = new Stack<>();
		stack.push(n);

		while (!stack.isEmpty()) {
			n = stack.pop();

			// if a current node is not visited
			if (!visited[n]) {
				visited[n] = true;
				System.out.println(n);
			}
			// Iterate through neighbors of each and add unvisited to boolean array
			List<Integer> neighbors = graph.getNeighbors(n);
			if (neighbors !=null && !neighbors.isEmpty()) {
				for (int neighbor : neighbors) {
					// if a neighbors is not visited
					if (!visited[neighbor]) {
						stack.push(neighbor);
					}
				}
			}
		}
	}
}
