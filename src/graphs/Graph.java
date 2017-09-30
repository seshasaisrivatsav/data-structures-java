package graphs;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Graph {
	 
	// Creating a map to store Integer and it's vertex list
	// Note: This is an Integer graph and it will have integer neighbors
	private Map<Integer, List<Integer>> adj_list;
	
	
	public Graph(int num_of_vertices) {
		adj_list = new HashMap<Integer, List<Integer>>();
		for(int i=1; i<=num_of_vertices; i++) {
			adj_list.put(i, new LinkedList<Integer>());
		}
	}
	
	// Add edges : For a bidirectional graph
	public void addEdge(int s, int d) {
		if(s > adj_list.size() || d > adj_list.size()) {
			System.out.println("The vertex is not present");
			return;
		}
		List<Integer> s_neighbors = adj_list.get(s);
		s_neighbors.add(d);
		List<Integer> d_neighbors = adj_list.get(d);
		d_neighbors.add(s);
	}
	
	// Get neighbors of input vertex
	public List<Integer> getNeighbors(int s){
		if(s>adj_list.size()) {
			System.out.println("the given vertex is not present");
		}
		return adj_list.get(s);
	}
	
	
	// Create a graph
	public static void main(String[] args) {
		int s, d, no_of_edges, no_of_vertices;
		int count =1 ;
		Scanner sc = new Scanner(System.in);
		
		
			// Read the number of edges and vertices
			System.out.println("Enter the number of vertices and edges with space");
			no_of_edges = sc.nextInt();
			no_of_vertices = sc.nextInt();
			Graph adj_list = new Graph(no_of_vertices);
			
			// Read the edges
			System.out.println("Enter the edges in <format source_index> <destination_index>");
			while(count < no_of_edges) {
				s = sc.nextInt();
				d = sc.nextInt();
				adj_list.addEdge(s,d);
				count++;
			}
			
			//TODO : PRINT
			// http://www.sanfoundry.com/java-program-describe-representation-graph-using-adjacency-list/
			// Print the graph
			for(int i=1; i<=no_of_vertices; i++) {
				System.out.println("Printing the graph:");
				List<Integer> edgeList = adj_list.getNeighbors(i);
                for (int j = 1 ; ; j++ )
                {
                    if (j != edgeList.size())
                    {
                        System.out.print(edgeList.get(j - 1 )+"->");
                    }else
                    {
                        System.out.print(edgeList.get(j - 1 ));
                        break;
                    }						 
                }
                System.out.println();		
				
			}
			
	}
	 
	
	
	
}
