import java.util.*;

public class Task8EmergencyRouteMeetingPoint {
    static void bfs(int start, List<List<Integer>> graph, int[] distance) {
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : graph.get(u)) {
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    queue.offer(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of locations: ");
        int n = sc.nextInt();

        System.out.print("Enter number of roads: ");
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        System.out.println("Enter roads as: u v");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.print("Enter emergency locations A and B: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] da = new int[n];
        int[] db = new int[n];
        bfs(a, graph, da);
        bfs(b, graph, db);

        int meetingPoint = -1;
        int bestDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (da[i] != -1 && db[i] != -1) {
                int total = da[i] + db[i];
                if (total < bestDistance) {
                    bestDistance = total;
                    meetingPoint = i;
                }
            }
        }

        if (meetingPoint == -1)
            System.out.println("No common reachable meeting point.");
        else
            System.out.println("Recommended meeting point by minimum total road distance: "
                    + meetingPoint);
    }
}
