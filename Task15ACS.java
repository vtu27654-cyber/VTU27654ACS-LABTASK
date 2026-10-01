import java.util.*;

public class Task15ExpeditionResourceOptimizationSystem {
    static class Item {
        String name;
        int weight;
        int value;

        Item(String name, int weight, int value) {
            this.name = name;
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of resources: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter resource as: name weight value");
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int weight = sc.nextInt();
            int value = sc.nextInt();
            items[i] = new Item(name, weight, value);
        }

        System.out.print("Enter maximum carrying capacity: ");
        int capacity = sc.nextInt();

        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                dp[i][w] = dp[i - 1][w];

                if (items[i - 1].weight <= w) {
                    dp[i][w] = Math.max(
                            dp[i][w],
                            dp[i - 1][w - items[i - 1].weight]
                                    + items[i - 1].value
                    );
                }
            }
        }

        System.out.println("Maximum resource value: " + dp[n][capacity]);

        List<String> selected = new ArrayList<>();
        int w = capacity;

        for (int i = n; i >= 1; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selected.add(items[i - 1].name);
                w -= items[i - 1].weight;
            }
        }

        Collections.reverse(selected);

        System.out.println("Selected resources:");
        for (String name : selected) {
            System.out.println(name);
        }
    }
}
