public class PalindromePartitioningIIv2 {

    public static void main(String[] args) {
        // Test cases
        System.out.println(minCut("aab"));    // Output: 1
        System.out.println(minCut("a"));      // Output: 0
        System.out.println(minCut("ab"));     // Output: 1
        System.out.println(minCut("bb"));    // Output: 0
        System.out.println(minCut("abbab"));  // Output: 1
    }

    /**
     * Calculates the minimum number of cuts needed to partition the string into palindromic substrings.
     *
     * @param s The input string.
     * @return The minimum number of cuts.
     */
    public static int minCut(String s) {
        int n = s.length();

        // dp[i] stores the minimum number of cuts for the substring s[0..i]
        int[] dp = new int[n];

        // We assume the worst case: each character requires a cut
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // We use a center-expansion approach to find all palindromic substrings
        for (int center = 0; center < n; center++) {
            // Odd-length palindromes
            expandAroundCenter(s, center, center, dp);
            // Even-length palindromes
            expandAroundCenter(s, center, center + 1, dp);
        }

        return dp[n - 1];
    }

    /**
     * Expands around a center to find palindromic substrings and updates the dp array.
     *
     * @param s      The input string.
     * @param left   The left index of the center.
     * @param right  The right index of the center.
     * @param dp     The dp array storing the minimum cuts.
     */
    private static void expandAroundCenter(String s, int left, int right, int[] dp) {
        int n = s.length();

        // Expand while the characters are equal and within bounds
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (left == 0) {
                // If the palindrome starts at index 0, no cuts are needed
                dp[right] = 0;
            } else {
                // Update the minimum cuts for the current position
                dp[right] = Math.min(dp[right], dp[left - 1] + 1);
            }

            // Move the pointers outward
            left--;
            right++;
        }
    }
}
