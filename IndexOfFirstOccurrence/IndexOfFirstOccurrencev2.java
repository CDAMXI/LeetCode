package IndexOfFirstOccurrence;

public class IndexOfFirstOccurrencev2 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad","sad"));
        System.out.println(strStr("leetcode","leeto"));
        System.out.println(strStr("hello","ll"));
    }
    
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // Si needle está vacío, devuelve 0 por definición
        }
        if (haystack.length() < needle.length()) {
            return -1; // Si haystack es más corto que needle, no puede contenerlo
        }
    
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Retorna el índice donde comienza needle en haystack
            }
        }
    
        return -1; // Si no se encuentra, retorna -1
    }
    
}
