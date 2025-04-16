public class LongestValidParenthesesv3 {
    public static void main(String[] args) {
        System.out.println("Longest Valid Parentheses [\"(()\"]: " + longestValidParentheses("(()")); // Expected: 2
        System.out.println("Longest Valid Parentheses [\")()())\"]: " + longestValidParentheses(")()())")); // Expected: 4
    }

    /**
     * Finds the length of the longest valid parentheses substring using two passes (left-to-right and right-to-left).
     * Time Complexity: O(n) - Two linear passes.
     * Space Complexity: O(1) - Uses only a few variables.
     */
    public static int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()){return 0;}

        int left = 0, right = 0, maxLen = 0;

        // Left-to-right pass (handles cases like "(()")
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){left++;}
            else{right++;}

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0; // Reset counters (invalid segment)
            }
        }

        left = right = 0;

        // Right-to-left pass (handles cases like "())")
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '('){left++;}
            else{right++;}

            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0; // Reset counters (invalid segment)
            }
        }

        return maxLen;
    }
}
