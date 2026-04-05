public class RegularExpressionMatchingv2 {

    public static void main(String[] args) {
        System.out.println("For s = \"aab\", p = \"c*a*b\", isMatch(s, p) = " + isMatch("aab", "c*a*b"));
        System.out.println("For s = \"mississippi\", p = \"mis*is*p*.\" isMatch(s, p) = " + isMatch("mississippi", "mis*is*p*."));
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true; // empty string matches empty pattern

        // Initialize dp for patterns like a*, a*b*, a*b*c*, etc.
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char prev = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2] || ((prev == '.' || prev == sc) && dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}
