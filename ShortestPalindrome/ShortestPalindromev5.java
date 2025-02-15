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

        // Encontrar el índice más largo que forma un palíndromo
        while (longestPrefixPalindrome > 0 && !isPalindrome(s, 0, longestPrefixPalindrome)) {
            longestPrefixPalindrome--;
        }

        // Construir el prefijo necesario para convertir en palíndromo
        StringBuilder prefix = new StringBuilder(s.substring(longestPrefixPalindrome + 1));
        prefix.reverse();

        // Devolver el palíndromo más corto
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
            // Comparar caracteres directamente
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
