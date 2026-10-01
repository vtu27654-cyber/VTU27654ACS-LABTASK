### Task 6 — Intelligent CPU Task Scheduler


import java.util.*;

public class Task6ACS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        HashMap<String, Integer> frequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String task = sc.next();
            frequency.put(task, frequency.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int count : frequency.values()) {
            pq.offer(count);
        }

        int time = 0;

        while (!pq.isEmpty()) {
            ArrayList<Integer> used = new ArrayList<>();

            int cycle = k + 1;

            while (cycle > 0 && !pq.isEmpty()) {
                int count = pq.poll();

                if (count - 1 > 0) {
                    used.add(count - 1);
                }

                time++;
                cycle--;
            }

            for (int count : used) {
                pq.offer(count);
            }

            if (!pq.isEmpty() && cycle > 0) {
                time += cycle;
            }
        }

        System.out.println(time);

        sc.close();
    }
}

**Sample Input**
8 2
A A A B B C D D
```

**Output**

8

