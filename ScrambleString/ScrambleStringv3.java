package ScrambleString;

import java.util.*;

/**
 * Time- and space-optimized scramble check:
 * - DFS + memo (Long->Byte) to reduce cubic array footprint.
 * - Prefix frequency tables (256 alphabet) for O(Σ) anagram pruning.
 * - Double rolling hash (two moduli) for O(1) substring equality checks.
 * - Index-only operations (no substring allocations).
 */
public class ScrambleStringv3 {

    public static void main(String[] args) {
        System.out.println(isScramble("great", "rgeat"));         // true
        System.out.println(isScramble("abcde", "caebd"));         // false
        System.out.println(isScramble("a", "a"));                 // true
        System.out.println(isScramble("abc", "bca"));             // true
        System.out.println(isScramble("abcdefghijklmnop",
                                      "efghijklmndopabc"));       // likely false
    }

    // -------- Public API --------
    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        final int n = s1.length();
        if (n != s2.length()) return false;
        if (s1.equals(s2)) return true;
        if (n == 0) return true;

        final char[] a = s1.toCharArray();
        final char[] b = s2.toCharArray();

        // Prefix frequency for pruning (alphabet size 256).
        int[][] prefA = buildPrefixFreq(a);
        int[][] prefB = buildPrefixFreq(b);

        // Double rolling hash for O(1) equality checks.
        Hasher hasherA = new Hasher(a);
        Hasher hasherB = new Hasher(b);

        // Compact memo: key = (i<<42) | (j<<21) | len ; value: 1=true, -1=false
        HashMap<Long, Byte> memo = new HashMap<>(n * n);
        return dfs(a, b, 0, 0, n, prefA, prefB, hasherA, hasherB, memo);
    }

    // -------- Core DFS with memo --------
    private static boolean dfs(char[] a, char[] b,
                               int i, int j, int len,
                               int[][] prefA, int[][] prefB,
                               Hasher hasherA, Hasher hasherB,
                               HashMap<Long, Byte> memo) {

        long key = (((long) i) << 42) | (((long) j) << 21) | (long) len;
        Byte cached = memo.get(key);
        if (cached != null) return cached == 1;

        // Fast path: exact equality via double hash
        if (hasherA.equals(hasherB, i, j, len)) {
            memo.put(key, (byte) 1);
            return true;
        }

        // Anagram pruning (characters mismatch -> impossible)
        if (!sameMultiset(prefA, prefB, i, j, len)) {
            memo.put(key, (byte) -1);
            return false;
        }

        // Try all split points with early prefix/suffix pruning
        for (int k = 1; k < len; k++) {
            // 1) No swap: a[i..i+k) ~ b[j..j+k) AND a[i+k..i+len) ~ b[j+k..j+len)
            if (sameMultiset(prefA, prefB, i, j, k) &&
                sameMultiset(prefA, prefB, i + k, j + k, len - k)) {

                if (dfs(a, b, i, j, k, prefA, prefB, hasherA, hasherB, memo) &&
                    dfs(a, b, i + k, j + k, len - k, prefA, prefB, hasherA, hasherB, memo)) {
                    memo.put(key, (byte) 1);
                    return true;
                }
            }

            // 2) Swap: a[i..i+k) ~ b[j+len-k..j+len) AND a[i+k..i+len) ~ b[j..j+len-k)
            if (sameMultiset(prefA, prefB, i, j + len - k, k) &&
                sameMultiset(prefA, prefB, i + k, j, len - k)) {

                if (dfs(a, b, i, j + len - k, k, prefA, prefB, hasherA, hasherB, memo) &&
                    dfs(a, b, i + k, j, len - k, prefA, prefB, hasherA, hasherB, memo)) {
                    memo.put(key, (byte) 1);
                    return true;
                }
            }
        }

        memo.put(key, (byte) -1);
        return false;
    }

    // -------- Frequency pruning (O(Σ)=256) --------
    private static int[][] buildPrefixFreq(char[] s) {
        int n = s.length;
        int[][] pref = new int[n + 1][256];
        for (int i = 0; i < n; i++) {
            int c = s[i] & 0xFF;
            System.arraycopy(pref[i], 0, pref[i + 1], 0, 256);
            pref[i + 1][c]++;
        }
        return pref;
    }

    private static boolean sameMultiset(int[][] prefA, int[][] prefB,
                                        int i, int j, int len) {
        int[] aC = prefA[i + len];
        int[] aP = prefA[i];
        int[] bC = prefB[j + len];
        int[] bP = prefB[j];
        // Compare counts for all 256 slots
        for (int c = 0; c < 256; c++) {
            if ((aC[c] - aP[c]) != (bC[c] - bP[c])) return false;
        }
        return true;
    }

    // -------- Double rolling hash (two moduli) --------
    private static final class Hasher {
        // Moduli are large primes that fit in signed 64-bit arithmetic.
        private static final long MOD1 = 1_000_000_007L;
        private static final long MOD2 = 1_000_000_009L;
        private static final long BASE1 = 911382323L;
        private static final long BASE2 = 972663749L;

        private final long[] h1, p1, h2, p2;

        Hasher(char[] s) {
            int n = s.length;
            h1 = new long[n + 1];
            p1 = new long[n + 1];
            h2 = new long[n + 1];
            p2 = new long[n + 1];
            p1[0] = 1; p2[0] = 1;
            for (int i = 0; i < n; i++) {
                int v = s[i] & 0xFF; // limit to 0..255
                h1[i + 1] = (h1[i] * BASE1 + v + 1) % MOD1;
                p1[i + 1] = (p1[i] * BASE1) % MOD1;
                h2[i + 1] = (h2[i] * BASE2 + v + 1) % MOD2;
                p2[i + 1] = (p2[i] * BASE2) % MOD2;
            }
        }

        // Compare substring equality in O(1)
        boolean equals(Hasher other, int i, int j, int len) {
            long x1 = subHash(h1, p1, i, len, MOD1);
            long y1 = subHash(other.h1, other.p1, j, len, MOD1);
            if (x1 != y1) return false;

            long x2 = subHash(h2, p2, i, len, MOD2);
            long y2 = subHash(other.h2, other.p2, j, len, MOD2);
            return x2 == y2;
        }

        private static long subHash(long[] h, long[] p, int i, int len, long mod) {
            long res = (h[i + len] - (h[i] * p[len]) % mod);
            if (res < 0) res += mod;
            return res;
        }
    }
}
