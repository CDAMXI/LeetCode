package ShortestPalindrome;

public class ShortestPalindromev1 {
    public static void main(String[] args) {
        System.out.println("Final answer: " + ShortestPalindrome("aacecaaa"));
        System.out.println("Final answer: " + ShortestPalindrome("abcd"));
    }

    public static String ShortestPalindrome(String s){
        if (s.length() <= 1 || isPalindrome(s)) {return s;}
        s = s.toLowerCase();
        String aux = s;
        while (!isPalindrome(s) && aux.length() != 0) {
            if (s.startsWith(aux.charAt(0) + "")) {
                aux = aux.substring(1);
            } else{
                s = aux.charAt(0) + "" + s;
                aux = aux.substring(1);
            }
        }
        return s;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            // Avoid non-alphabetic characters on the left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {i++;}
            // Avoid non-alphabetic characters on the right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {j--;}

            // Compare the remaining characters
            if (s.charAt(i) != s.charAt(j)) {return false;}

            // Increment both indexes
            i++;
            j--;
        }

        return true;
    }
}
