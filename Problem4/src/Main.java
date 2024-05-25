import java.util.*;

class Graph {
    int v;
    int e;
    int[][] dir;

    Graph(int v, int e) {
        this.v = v;
        this.e = e;
        this.dir = new int[v + 1][v + 1];
    }
}

public class Main {
    static int find_degree(Graph G, int ver) {
        int degree = 0;
        for (int i = 1; i <= G.v; i++) { 
            if (G.dir[ver][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        Graph graph = createGraph(vertices, edges);

        System.out.println("Enter edge (u v): ");
       
        for (int i = 1; i <= edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.dir[u][v] = 1;
            graph.dir[v][u] = 1;
        }

        System.out.println("Enter the vertex to find its degree: ");
        int ver = sc.nextInt();
        int degree = find_degree(graph, ver);
        System.out.println("Degree of vertex " + ver + ": " + degree);
        
        sc.close();
    }
   
    static Graph createGraph(int v, int e) {
        Graph graph = new Graph(v, e);
        return graph;
    }
}
