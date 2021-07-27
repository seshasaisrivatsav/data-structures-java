package graphs;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphUnidirected {
	 
	// Creating a map to store Integer and it's vertex list
	// Note: This is an Integer graph and it will have integer neighbors
	private Map<Integer, List<Integer>> adj_list;
	
	
	public GraphUnidirected(int num_of_vertices) {
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
	}
	
	// Get neighbors of input vertex
	public List<Integer> getNeighbors(int s){
		if(s>adj_list.size()) {
			System.out.println("the given vertex is not present");
		}
		return adj_list.get(s);
	}
	
	
	public int getSize() {
		return adj_list.size();	
	}
	
	
	
}
