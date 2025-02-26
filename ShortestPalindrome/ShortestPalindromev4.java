package ShortestPalindrome;

public class ShortestPalindromev4 {
    public static void main(String[] args) {
        System.out.println("Final answer: " + ShortestPalindrome("aacecaaa"));
        System.out.println("Final answer: " + ShortestPalindrome("abcd"));
        System.out.println("Final answer: " + ShortestPalindrome("abb"));
        System.out.println("Final answer: " + ShortestPalindrome("abbacd"));
    }

    public static String ShortestPalindrome(String s) {
        if (s.length() <= 1 || isPalindrome(s)) {
            return s;
        }
        
        s = s.toLowerCase();
        String aux = "";
        String s1 = s;

        // Find the longest segment at the beginning that is a palindrome
        while (!isPalindrome(s1)) {
            aux = aux + s.charAt(s1.length() - 1); // Add the last character of s1 to aux
            s1 = s1.substring(0, s1.length() - 1); // Reduce s1 by one character
        }
        
        // Concatenate aux at the beginning to form the shortest palindrome
        return aux + s;
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
