package ValidParentheses;

import java.util.*;

public class ValidParenthesesv2 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s) {
    // Use a stack to keep track of open parentheses
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        // Insert into stack when there is an opening parenthesis
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            // Verify if the stack is empty before attempting to pop
            if (stack.isEmpty()) {
                return false;
            }
            // Check if the closing parenthesis matches the one at the top of the stack
            char top = stack.pop();
            if ((c == ')' && top != '(') ||
                (c == ']' && top != '[') ||
                (c == '}' && top != '{')) {
                return false;
            }
        }
    }
    // The stack should be empty if the sequence is valid
    return stack.isEmpty();
}

}
