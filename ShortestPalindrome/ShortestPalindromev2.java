package ShortestPalindrome;

public class ShortestPalindromev2 {
    public static void main(String[] args) {
        System.out.println("Final answer: " + ShortestPalindrome("aacecaaa"));
        System.out.println("Final answer: " + ShortestPalindrome("abcd"));
        System.out.println("Final answer: " + ShortestPalindrome("abb"));
        System.out.println("Final answer: " + ShortestPalindrome("abbacd"));
    }

    public static String ShortestPalindrome(String s){
        if (s.length() <= 1 || isPalindrome(s)) {return s;}
        s = s.toLowerCase();
        String aux = s;
        if (s.startsWith(aux.charAt(0) + "")) {
            aux = aux.substring(1);
        }
        while (!isPalindrome(s) && aux.length() > 0) {
            s = aux.charAt(0) + "" + s;
            aux = aux.substring(1);
        }
        return s;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        // Convertir la cadena a minúsculas y eliminar caracteres no alfabéticos
        s = s.toLowerCase();
        
        while (i < j) {
            // Saltar caracteres no alfabéticos en la izquierda
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Saltar caracteres no alfabéticos en la derecha
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Comparar los caracteres restantes
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            // Avanzar ambos índices
            i++;
            j--;
        }

        return true;
    }
}
