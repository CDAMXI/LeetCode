package ShortestPalindrome;

public class ShortestPalindromev6 {
    public static void main(String[] args) {
        System.out.println("Final answer: " + ShortestPalindrome("aacecaaa")); // "aaacecaaa"
        System.out.println("Final answer: " + ShortestPalindrome("abcd")); // "dcbabcd"
        System.out.println("Final answer: " + ShortestPalindrome("abb")); // "bbabb"
        System.out.println("Final answer: " + ShortestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

    public static String ShortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;

        // Calcular la tabla LPS
        int[] lps = computeLPS(combined);

        // Encontrar la longitud del prefijo palíndromo más largo
        int longestPrefixPalindrome = lps[lps.length - 1];

        // Sufijo que falta para hacer la cadena un palíndromo
        String suffix = s.substring(longestPrefixPalindrome);
        StringBuilder prefix = new StringBuilder(suffix).reverse();

        // Crear el palíndromo más corto
        return prefix + s;
    }

    private static int[] computeLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int length = 0;
        int i = 1;

        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
