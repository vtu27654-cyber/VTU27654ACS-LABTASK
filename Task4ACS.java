Task 4 — Server Request Validator
import java.util.*;

public class Task4ACS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        boolean valid = true;

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{') ||
                    (ch == '>' && top != '<')) {
                    valid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty())
            valid = false;

        System.out.println(valid ? "VALID" : "INVALID");

        sc.close();
    }
}
Sample 1:
({[]})
Output:
VALID
Sample 2:
([{})
Output:
INVALID
Compile and run:
javac Task4ACS.java
java Task4ACS