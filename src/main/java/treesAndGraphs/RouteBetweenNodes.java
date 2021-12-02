package treesAndGraphs;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class RouteBetweenNodes {

    /**
     * Approach: Uses breadth first search as
     *  - can be useful to find shortest path
     *  - where as DFS will traverse adjacent node deeply before ever going to neighbors
     *
     *  Space Complexity: O(V) - Number of vertices/nodes - for the queue
     *  Time Complexity: O(V+E) - Vertices + Edges
     * @param graph Graph
     * @param source Integer
     * @param destination Integer
     * @return true if path exists between source and destination
     */
    public static boolean routeExists(Graph graph, int source, int destination) {
        boolean visited[] = new boolean[graph.getSize()]; // Created a visited array with Nodes number size

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[source] = true;
        queue.add(source);

        Iterator<Integer> adjIterator;

        while(!queue.isEmpty()) {
            source = queue.poll(); // get a vertex from queue
            adjIterator = graph.adj[source].listIterator(); // use iterator to iterate over adjacent vertices of dequeued vertex
            int neighbor;
            while(adjIterator.hasNext()) {
                neighbor = adjIterator.next();
                if (neighbor == destination) {
                    return true;
                }

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
    /*
        0----> 1
        ^      |
        |      |
        |      v
        3 ---->2

        Graph Example:   graph with 4 nodes, 4 edges
            0: 1
            1: 2
            2:
            3: 2, 0

     */
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("route exists between 1 and 3: " + routeExists(g, 1, 3));
        System.out.println("route doesn't exist between 3 and 1: " + routeExists(g, 3, 1));

    }

    static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer> adj[];

        int getSize() { return V;}
        Graph(int v) {
            V =v;
            adj = new LinkedList[v];
            for (int i=0; i<v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int a, int b) { adj[a].add(b); }
    }

    /**
     * Check if a valid path exists given 2d array of edges
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return
     */
    public boolean validPath(int n, int[][] edges, int start, int end) {

        if (start == end) {
            return true;
        }

        /*

        [0, 1], [0, 2]

        Adjacency
            0: 1, 2
            1: 2, 3
            2: 0
            3:
         */
        // Create adjacency List array of linked list.
        LinkedList<Integer>[] adjList = new LinkedList[n];
        for (int i=0; i<n; i++) {
            adjList[i] = new LinkedList<>();
        }

        // Create an Adjacency List (NOTE: two way arrow for bidirectional)
        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]); // A -> B
            adjList[edge[1]].add(edge[0]); // B -> A
        }


        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<Integer>();


        queue.add(start);
        visited[start] = true;

        Iterator<Integer> adjIterator;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            adjIterator = adjList[currentNode].listIterator();

            while(adjIterator.hasNext()) {
                int neighbor = adjIterator.next();
                if (neighbor == end) {
                    return true;
                }
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return false;


    }
	
}
