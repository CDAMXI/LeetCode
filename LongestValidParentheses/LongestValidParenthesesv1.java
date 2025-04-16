import java.util.*;

public class LongestValidParenthesesv1{
    public static void main(String[] args){
        System.out.println("Longest Valid Parentheses [\"(()\"]: " + longestValidParentheses("(()")); // Expected output: 2
        System.out.println("Longest Valid Parentheses [\")()())\"]: " + longestValidParentheses(")()())")); // Expected output: 4
    }

    public static int longestValidParentheses(String s) {
        int count = 0;
        if (s == null || s.length() == 0 || !s.matches("^[()]*$")) {return 0;}
        do {
            if (!isValid(s)) {
                // If the string is not valid, remove the first invalid character
                s = s.replaceFirst("[^()]", "");
            }
            // Remove the first invalid character from the string
            s = s.replaceFirst("[^()]", "");
            count +=2;
        } while (count < s.length());
        return count;
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
