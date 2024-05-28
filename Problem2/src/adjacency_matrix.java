import java.util.*;
public class adjacency_matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		int vertices = sc.nextInt();
		
		int[][] adjacencyMatrix = new int[vertices][vertices];
		System.out.println("Enter the number of adjacency matrix:");
		
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				adjacencyMatrix[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Edges and their occurences:");
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (adjacencyMatrix[i][j] == 1) {
					System.out.println("Edge (" + (i + 1) + ", " + (j + 1) + ")");
				}
			}	
		}
		sc.close();
	}
}
