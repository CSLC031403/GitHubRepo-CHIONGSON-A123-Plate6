import java.util.*;

public class adjacency_matrix {
    private int[][] adjacencyMatrix;
    private int vertices;

    public adjacency_matrix(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices + 1][vertices + 1];
    }

    public void add_edge(int source, int destination) {
        adjacencyMatrix[source][destination] += 1;
    }

    public void display() {
        for (int i = 1; i <= vertices; i++) {
            for (int j = 1; j <= vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        adjacency_matrix graph = new adjacency_matrix(vertices);

        System.out.print("Enter the number of edges: ");
        int numEdges = sc.nextInt();

        System.out.println("Enter the vertex pairs associated with the edges:");
        for (int i = 0; i < numEdges; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.add_edge(source, destination);
        }

        System.out.println("Adjacency Matrix:");
        graph.display();
    }
}
