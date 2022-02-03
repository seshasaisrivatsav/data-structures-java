package treesAndGraphs;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//addEdge (source, destination)
// getNeighbors (vertex)

public class PathExists {

	public static void main(String[] args) {
		GraphUnidirected newGraph = new GraphUnidirected(6);
		newGraph.addEdge(1, 2);
		newGraph.addEdge(2, 3);
		newGraph.addEdge(3, 5);
		newGraph.addEdge(4, 2);
		newGraph.addEdge(6, 4);
		newGraph.addEdge(5, 4);
		pathExists(2, 1, newGraph);
		
		
	}
	
	public static void pathExists(int s, int d, GraphUnidirected newGraph) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		Boolean[] visited_array = new Boolean[newGraph.getSize()];
		for(int i=0; i<visited_array.length;i++) {
			visited_array[i] = false;
		}
		
		
		int a;
		List<Integer> neighbors;
		while(!q.isEmpty()) {
			a= q.poll();
			if(a==d) {
				System.out.println("Path Exists");
				return;
			}else {
				neighbors = newGraph.getNeighbors(a);
				for(int i=0; i<neighbors.size();i++) {
					if(visited_array[neighbors.get(i)-1] != true) {
						q.add(neighbors.get(i));
					}
				}
				visited_array[a-1] = true;
			}
		}
		System.out.println("Path ain't not exist");
		
	}
}
