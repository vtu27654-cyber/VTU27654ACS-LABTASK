import java.util.*;

public class Task14EventHallReservationManager {
    static class Reservation {
        String customer;
        int start;
        int end;

        Reservation(String customer, int start, int end) {
            this.customer = customer;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Reservation> reservations = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add reservation");
            System.out.println("2. Display reservations");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Customer name: ");
                String name = sc.next();

                System.out.print("Start time (integer hour): ");
                int start = sc.nextInt();

                System.out.print("End time (integer hour): ");
                int end = sc.nextInt();

                if (start >= end) {
                    System.out.println("Invalid time range.");
                    continue;
                }

                boolean conflict = false;

                for (Reservation r : reservations) {
                    if (start < r.end && end > r.start) {
                        conflict = true;
                        break;
                    }
                }

                if (conflict) {
                    System.out.println("Reservation rejected: time conflict.");
                } else {
                    reservations.add(new Reservation(name, start, end));
                    System.out.println("Reservation confirmed.");
                }

            } else if (choice == 2) {
                if (reservations.isEmpty()) {
                    System.out.println("No reservations.");
                } else {
                    System.out.println("Reservations:");
                    for (Reservation r : reservations) {
                        System.out.println(r.customer + " : "
                                + r.start + " - " + r.end);
                    }
                }

            } else if (choice == 3) {
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}
