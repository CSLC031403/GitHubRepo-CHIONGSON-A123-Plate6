import java.util.*;
public class graph_main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices:");
		int vertices = sc.nextInt();
		graph_connection graph = new graph_connection(vertices);
		
		System.out.println("Enter edges (format: u v). Enter -1 -1 to finish:");
		while (true) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (u == -1 && v == -1) {
				break;
			}
			graph.Add_Edge(u, v);
		}
		
		if (graph.Connected()) {
			System.out.println("The graph is connected.");
		} else {
			System.out.println("The graph is not connected.");
			System.out.println("Number of connected components: " + graph.Count_Connected_Components());
		}
		
		sc.close();
	}
}