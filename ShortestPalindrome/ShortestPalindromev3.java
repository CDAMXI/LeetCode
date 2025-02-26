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
        
        // Convert the string to lowercase and remove non-alphabetic characters
        s = s.toLowerCase();
        
        while (i < j) {
            // Avoid non-alphabetic characters on the left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Avoid non-alphabetic characters on the right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare the remaining characters
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            // Increment both indexes
            i++;
            j--;
        }

        return true;
    }
}
