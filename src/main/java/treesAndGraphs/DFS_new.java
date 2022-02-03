package treesAndGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS_new {
    class Edge {
        int source;
        int dest;
        public Edge(int source, int edge) {
            this.source = source;
            this.dest = dest;
        }
    }

    class Graph {
        List<List<Integer>> adjList;
        Graph(List<Edge> edges, int n) {
            adjList = new ArrayList<>();
            // For each vertex, create adjacency
            for (int i=0; i<n; i++) {
                adjList.add(new ArrayList<>());
            }

            // Construct the adjacency list
            for (Edge edge: edges) {
                int src = edge.source;
                int dest = edge.dest;
                // Here we're doing 2 way
                adjList.get(src).add(dest);
                adjList.get(dest).add(src);
            }
        }
    }


    public static void dfs_iterative(Graph g, int startNode, int V) {
        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while(!stack.isEmpty()) {
            startNode = stack.pop(); // pull each one off stack

            // if not visited
            if (!visited[startNode]) {
                visited[startNode] = true;
                System.out.println(startNode);
            }

            // for eeach edge of it
            List<Integer> adjList = g.adjList.get(startNode);
            for (int i=adjList.size()-1; i>=0; i--) {
                int neighbor = adjList.get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
