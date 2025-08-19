package ScrambleString;

public class ScrambleStringv2 {

    public static void main(String[] args) {
        // Basic sanity checks
        System.out.println(isScramble("great", "rgeat"));    // true
        System.out.println(isScramble("abcde", "caebd"));    // false
        System.out.println(isScramble("a", "a"));            // true
        System.out.println(isScramble("abc", "bca"));        // true
        System.out.println(isScramble("abcdefghijklmnop", "efghijklmndopabc")); // likely false
    }

    /**
     * Returns true if s2 is a scramble of s1 (case-sensitive).
     * Uses DFS with memoization and character-count pruning.
     */
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null){return false;}
        int n = s1.length();
        if (n != s2.length()) {return false;}
        if (s1.equals(s2)) {return true;}
        if (n == 0) {return true;}

        // Precompute char arrays to avoid substring creation
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        // memo[i][j][len] = -1 unknown, 0 false, 1 true
        byte[][][] memo = new byte[n][n][n + 1];
        return dfs(a, b, 0, 0, n, memo);
    }

    // Depth-first search with memoization over (i, j, len)
    private static boolean dfs(char[] a, char[] b, int i, int j, int len, byte[][][] memo) {
        if (memo[i][j][len] != 0) {
            return memo[i][j][len] == 1;
        }

        // Fast path: exact substring equality
        if (equalsRange(a, i, b, j, len)) {
            memo[i][j][len] = 1;
            return true;
        }

        // Prune by multiset of characters
        if (!sameMultiset(a, i, b, j, len)) {
            memo[i][j][len] = -1; // mark checked and false
            return false;
        }

        // Try all split points
        for (int k = 1; k < len; k++) {
            // Case 1: no swap
            if (dfs(a, b, i, j, k, memo) && dfs(a, b, i + k, j + k, len - k, memo)) {
                memo[i][j][len] = 1;
                return true;
            }
            // Case 2: swap
            if (dfs(a, b, i, j + (len - k), k, memo) && dfs(a, b, i + k, j, len - k, memo)) {
                memo[i][j][len] = 1;
                return true;
            }
        }

        memo[i][j][len] = -1;
        return false;
    }

    // Check if a[i..i+len) == b[j..j+len)
    private static boolean equalsRange(char[] a, int i, char[] b, int j, int len) {
        for (int t = 0; t < len; t++) {
            if (a[i + t] != b[j + t]) {return false;}
        }
        return true;
    }

    // Check if the two ranges have the same multiset of characters
    // Uses a small fixed-size frequency table for speed (covers basic Unicode BMP up to 256 extended ASCII).
    // For full Unicode robustness, replace with an Int2IntMap or a HashMap<Character,Integer>.
    private static boolean sameMultiset(char[] a, int i, char[] b, int j, int len) {
        int[] cnt = new int[256];
        for (int t = 0; t < len; t++) {
            cnt[a[i + t] & 0xFF]++;
            cnt[b[j + t] & 0xFF]--;
        }
        for (int c : cnt) if (c != 0) {return false;}
        return true;
    }
}
