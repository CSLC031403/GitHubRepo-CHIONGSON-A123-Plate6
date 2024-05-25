import java.util.*;
public class cycle_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		int V = sc.nextInt();
		graph_cycle graph = new graph_cycle(V);
		
		System.out.println("Enter the edges (u, v):");
		while (sc.hasNextInt()) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			if (u == -1 && v == -1) {
				break;
			}
			graph.addEdge(u, v);
		}
		
		if (graph.hasCycle()) {
			System.out.println("The graph contains a cycle.");
		} else {
			System.out.println("The graph does not contain a cycle.");
		}
	}

}
