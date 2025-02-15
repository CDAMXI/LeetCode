package IndexOfFirstOccurrence;

public class IndexOfFirstOccurrencev3 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad","sad"));
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strStr("hello","ll"));
    }
    
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Needle vacío siempre está presente en cualquier string
        }
        if (haystack.length() < needle.length()) {
            return -1; // Haystack más corto no puede contener Needle
        }
    
        // Recorremos haystack hasta un punto donde needle puede caber
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
    
            // Comparamos carácter por carácter entre haystack y needle
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
    
            // Si todos los caracteres coinciden, devolvemos el índice
            if (found) {
                return i;
            }
        }
    
        return -1; // Si no encontramos needle en haystack
    }
    
}
