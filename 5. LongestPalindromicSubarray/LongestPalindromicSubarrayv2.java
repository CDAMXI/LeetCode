package LongestPalindromicSubarray;

public class LongestPalindromicSubarrayv2 {
    public static void main(String[] args) {
        System.out.println("For \"abccba\", the longest palindromic subarray is: " + longestPalindrome("abccba"));
        System.out.println("For \"babad\", the longest palindromic subarray is: " + longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1){return "";}

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);       // odd-length palindromes
            int len2 = expandFromCenter(s, i, i + 1);   // even-length palindromes
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of the palindrome
    }
}
