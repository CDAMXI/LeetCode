import java.util.*;

public class GenerateParenthesisv2 {
    public static void main(String[] args) {
        System.out.println("For 1: " + generateParenthesis(1) + "\n");
        System.out.println("For 2: " + generateParenthesis(2) + "\n");
        System.out.println("For 3: " + generateParenthesis(3) + "\n");
        System.out.println("For 4: " + generateParenthesis(4) + "\n");
        System.out.println("For 5: " + generateParenthesis(5) + "\n");
        System.out.println("For 6: " + generateParenthesis(6) + "\n");
        System.out.println("For 7: " + generateParenthesis(7) + "\n");
        System.out.println("For 8: " + generateParenthesis(8) + "\n");
        System.out.println("For 9: " + generateParenthesis(9) + "\n");
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // If the length of the combination is equal to 2 * n, it is valid.
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // Add an opening parenthesis if we haven't reached the limit.
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // Add a closing parenthesis if there are enough opened to close.
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }
}
// Time Complexity: O(4^n/sqrt(n)) where n is the number of pairs of parentheses
// Space Complexity: O(4^n/sqrt(n)) where n is the number of pairs of parentheses
