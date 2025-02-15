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

        // Encontrar el segmento más largo al principio que es palíndromo
        while (!isPalindrome(s1)) {
            aux = aux + s.charAt(s1.length() - 1); // Añadir el último carácter de s1 a aux
            s1 = s1.substring(0, s1.length() - 1); // Reducir s1
        }
        
        // Concatenar aux al inicio para formar el palíndromo más corto
        return aux + s;
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
