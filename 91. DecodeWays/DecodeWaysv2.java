package DecodeWays;

public class DecodeWaysv2 {
    public static void main(String[] args) {
        System.out.println(numDecodings("226"));   // 3 -> [2,2,6], [22,6], [2,26]
        System.out.println(numDecodings("12"));    // 2 -> [1,2], [12]
        System.out.println(numDecodings("06"));    // 0 -> invalid
        System.out.println(numDecodings("2101"));  // 1 -> [2,10,1]
        System.out.println(numDecodings("10"));    // 1 -> [10]
    }

    public static int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        // dp[i-2] and dp[i-1]
        int prev2 = 1; // dp[0] = 1 (empty string)
        int prev1 = 1; // dp[1] = 1 if s[0] != '0'

        for (int i = 1; i < s.length(); i++) {
            int cur = 0;

            char c = s.charAt(i);
            char p = s.charAt(i - 1);

            // A valid digit (1..9)
            if (c != '0') cur += prev1;

            // Two valid digits (10..26)
            int two = (p - '0') * 10 + (c - '0');
            if (two >= 10 && two <= 26) cur += prev2;

            // Advance window
            prev2 = prev1;
            prev1 = cur;

            // If cur == 0, we continue; the loop will handle if it becomes invalid later
        }
        return prev1;
    }
}
