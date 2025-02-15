package ShortestPalindrome;

public class ShortestPalindromev3 {
    public static void main(String[] args) {
        System.out.println("Final answer: " + ShortestPalindrome("aacecaaa"));
        System.out.println("Final answer: " + ShortestPalindrome("abcd"));
        System.out.println("Final answer: " + ShortestPalindrome("abb"));
        System.out.println("Final answer: " + ShortestPalindrome("abbacd"));
    }

    public static String ShortestPalindrome(String s){
        if (s.length() <= 1 || isPalindrome(s)) {return s;}
        s = s.toLowerCase();
        String s1 = s;
        String aux = "";
        if (s.startsWith(s1.charAt(0) + "")) {
            s1 = s1.substring(1);
        }
        while (!isPalindrome(s1) && s1.length() > 0) {
            aux =s1.charAt(0) +  aux;
            s1.substring(0,s1.length() - 1);
        }
        s = aux  + "" + s;
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
