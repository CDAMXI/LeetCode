public class PalindromePartitioningIIv3 {

    public static void main(String[] args) {
        // Test cases
        System.out.println(minCut("aab"));    // Output: 1
        System.out.println(minCut("a"));      // Output: 0
        System.out.println(minCut("ab"));     // Output: 1
        System.out.println(minCut("bb"));    // Output: 0
        System.out.println(minCut("abbab"));  // Output: 1
        System.out.println(minCut("abcba"));  // Output: 0
        System.out.println(minCut("abacaba"));  // Output: 0
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

        // Initialize dp array with the worst-case scenario: each character requires a cut
        for (int i = 0; i < n; i++) {
            dp[i] = i;
        }

        // Use center-expansion to find all palindromic substrings and update dp
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;

            // Expand around the center while the characters are equal
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

        return dp[n - 1];
    }
}
