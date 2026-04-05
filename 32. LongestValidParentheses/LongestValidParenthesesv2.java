import java.util.*;

public class LongestValidParenthesesv2{
    public static void main(String[] args) {
        System.out.println("Longest Valid Parentheses [\"(()\"]: " + longestValidParentheses("(()")); // Expected: 2
        System.out.println("Longest Valid Parentheses [\")()())\"]: " + longestValidParentheses(")()())")); // Expected: 4
    }

    /**
     * Finds the length of the longest valid parentheses substring.
     * Time Complexity: O(n) - Single pass through the string.
     * Space Complexity: O(n) - Stack can grow up to size n.
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()){return 0;}

        Stack<Integer> stack = new Stack<>();
        stack.push(-1); // Initialize stack with a base index for boundary calculation
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i); // Push the index of '('
            } else {
                stack.pop(); // Pop the last '(' index (or boundary)
                if (stack.isEmpty()) {
                    stack.push(i); // Push new boundary if stack is empty
                } else {
                    // Calculate current valid length and update max
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}
