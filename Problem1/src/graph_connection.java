import java.util.LinkedList;
public class graph_connection {
	
	private int vertex;
	private LinkedList<Integer> edges[];
	
	public graph_connection(int v) {
		this.vertex = v;
		edges = new LinkedList[vertex];
		for (int i = 0; i < vertex; i++)
			edges[i] = new LinkedList<>();
	}
	
	public void Add_Edge(int u, int v) {
		edges[u - 1].add(v - 1);
		edges[v - 1].add(u - 1);
	}
	
	public boolean Connected() {
		boolean visited[] = new boolean[vertex];
		dfs(1, visited);
		for (int i = 0; i < vertex; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}
	
	public int Count_Connected_Components() {
		boolean visited[] = new boolean[vertex];
		int count = 0;
		for (int i = 0; i < vertex; i++) {
			if (!visited[i]) {
				dfs(i, visited);
				count++;
			}
		}
		return count;
	}
	
	private void dfs (int u, boolean visited[]) {
		visited[u]= true;
		for (int v : edges[u]) {
			if (!visited[v])
				dfs(v,visited);
		}
	}
}
