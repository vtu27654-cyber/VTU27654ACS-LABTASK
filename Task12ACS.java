import java.util.*;

public class Task12SmartCoursePlannerAndDependencyAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of courses: ");
        int n = sc.nextInt();

        System.out.print("Enter number of prerequisites: ");
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        System.out.println("Enter prerequisites as: prerequisite course");
        for (int i = 0; i < m; i++) {
            int prerequisite = sc.nextInt();
            int course = sc.nextInt();
            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : graph.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) queue.offer(v);
            }
        }

        if (order.size() != n) {
            System.out.println("Cannot create a course plan: dependency cycle detected.");
        } else {
            System.out.println("Valid course order:");
            for (int course : order) {
                System.out.print(course + " ");
            }
            System.out.println();
        }
    }
}
