import java.util.*;

public class Task10CampusNetworkConnectivityChecker {
    static void dfs(int u, List<List<Integer>> graph, boolean[] visited) {
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) dfs(v, graph, visited);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of network nodes: ");
        int n = sc.nextInt();

        System.out.print("Enter number of connections: ");
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        System.out.println("Enter connections as: u v");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, graph, visited);
            }
        }

        System.out.println("Connected components: " + components);
        System.out.println(components == 1
                ? "Campus network is fully connected."
                : "Campus network has disconnected sections.");
    }
}
