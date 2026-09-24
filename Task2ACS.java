
import java.util.*;

public class Task2ACS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            freq.put(id, freq.getOrDefault(id, 0) + 1);
        }

        int maxFrequency = 0;
        int productId = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int id = entry.getKey();
            int count = entry.getValue();

            if (count > maxFrequency ||
                (count == maxFrequency && id < productId)) {
                maxFrequency = count;
                productId = id;
            }
        }

        System.out.println(productId + " " + maxFrequency);

        sc.close();
    }
}
```

**Sample Input:**
10
12 5 12 7 5 12 8 5 7 5


**Output:**
5 4
