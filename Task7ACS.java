import java.util.*;

public class Task7ACS {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int height(Node root) {
        if (root == null)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            if (a[i] != -1)
                nodes[i] = new Node(a[i]);
        }

        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left < n)
                    nodes[i].left = nodes[left];

                if (right < n)
                    nodes[i].right = nodes[right];
            }
        }

        int h = height(nodes[0]);

        System.out.println("Height = " + h);
        System.out.println("Levels = " + (h + 1));

        sc.close();
    }
}