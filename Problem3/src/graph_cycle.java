import java.util.*;
public class graph_cycle {
	private int vertices;
	private List<List<Integer>> adj;
	
	public graph_cycle(int v) {
		this.vertices = v;
		adj = new ArrayList<>(vertices);
		for (int i = 0; i < vertices; i++)
			adj.add(new ArrayList<>());
	}
	
	public void addEdge(int u, int v) {
		adj.get(u - 1).add(v - 1);
		adj.get(v - 1).add(u - 1);
	}
	
	private boolean isCyclicUtil(int v, boolean[] visited, int parent) {
		visited[v] = true;
		for (Integer neighbor : adj.get(v)) {
			if (!visited[neighbor]) {
				if (isCyclicUtil(neighbor, visited, v))
					return true;
			} else if (neighbor != parent) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasCycle() {
		boolean[] visited = new boolean[vertices];
		for (int i = 0; i < vertices; i++) {
			if (!visited[i] && isCyclicUtil(i, visited, -1))
				return true;
		}
		return false;
	}
}
