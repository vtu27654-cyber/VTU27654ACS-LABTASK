import java.util.*;

public class Task3ACS {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static void removeCycle(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle)
            return;

        slow = head;

        if (slow == fast) {
            while (fast.next != slow)
                fast = fast.next;
            fast.next = null;
            return;
        }

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
    }

    static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1)
            return head;

        Node current = head;
        Node previous = null;
        Node next = null;

        int count = 0;
        Node temp = head;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (count < k)
            return head;

        count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
            count++;
        }

        head.next = reverseKGroup(current, k);

        return previous;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Node head = null;
        Node tail = null;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(sc.nextInt());

            if (head == null) {
                head = nodes[i];
                tail = nodes[i];
            } else {
                tail.next = nodes[i];
                tail = nodes[i];
            }
        }

        int cyclePosition = sc.nextInt();

        if (cyclePosition != -1) {
            tail.next = nodes[cyclePosition];
        }

        removeCycle(head);

        head = reverseKGroup(head, k);

        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null)
                System.out.print(" ");

            current = current.next;
        }

        sc.close();
    }
}
Sample Output:
30 20 10 60 50 40 80 70
Compile and run:
javac Task3ACS.java
java Task3ACS


