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
		boolean[] visited = new boolean[g.size()];
		
		visited[start] = true;
		System.out.println(start);
		LinkedList<Integer> q = new LinkedList();
		q.add(start);
		
		while(!q.isEmpty()) {
			int i=0;
			int element = q.pop();
			while(i < g.getNeighbors(element).size()) {
				if(!visited[g.getNeighbors(element).get(i)]) {
					System.out.println(g.getNeighbors(element).get(i));
					q.add(g.getNeighbors(element).get(i));
					visited[g.getNeighbors(element).get(i)] = true;
				}
				i++;
			}
		}
		
		
	}
	
	
	

}
