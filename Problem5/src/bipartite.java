import java.util.*;

public class bipartite {
    
    public static boolean isBipartite(int[][] edges, int n) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }
        
        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 1; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 0; 
                queue.offer(i);
                
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    
                    for (int v : adjacencyList.get(u)) {
                        if (colors[v] == -1) {
                            colors[v] = 1 - colors[u];
                            queue.offer(v);
                        } else if (colors[v] == colors[u]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();
        
        int[][] edges = new int[m][2];
        System.out.println("Enter the edges (u v):");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges[i][0] = u;
            edges[i][1] = v;
        }
        
        if (isBipartite(edges, n)) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
        
        scanner.close();
    }
}
