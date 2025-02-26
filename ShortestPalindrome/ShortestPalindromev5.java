package ShortestPalindrome;

public class ShortestPalindromev5 {
    public static void main(String[] args) {
        System.out.println("Final answer: " + ShortestPalindrome("aacecaaa"));
        System.out.println("Final answer: " + ShortestPalindrome("abcd"));
        System.out.println("Final answer: " + ShortestPalindrome("abb"));
    }

    public static String ShortestPalindrome(String s) {
        if (s.length() <= 1 || isPalindrome(s)) {
            return s;
        }

        s = s.toLowerCase();
        int n = s.length();
        int longestPrefixPalindrome = n - 1;

        // Find the longest index that forms a palindrome
        while (longestPrefixPalindrome > 0 && !isPalindrome(s, 0, longestPrefixPalindrome)) {
            longestPrefixPalindrome--;
        }

        // Builder the prefix needed to convert into a palindrome
        StringBuilder prefix = new StringBuilder(s.substring(longestPrefixPalindrome + 1));
        prefix.reverse();

        // Return the shortest palindrome
        return prefix + s;
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            // Compare characters directly
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
