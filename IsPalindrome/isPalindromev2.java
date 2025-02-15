package IsPalindrome;

public class isPalindromev2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("No 'x' in Nixon"));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("x"));
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
