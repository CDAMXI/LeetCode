package IsPalindrome;

public class isPalindromev1 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s){
        s = s.trim();
        s = s.toLowerCase();
        s = s.replaceAll("[\\W_]+", " ");
        if (s.length() <= 1) {return true;}
        for (int i = 0, j = s.length() - 1; i <= j; i++,j--) {
            if (s.charAt(i) == ' ') {i++;}
            if (s.charAt(j) == ' ') {j--;}
            if (s.charAt(i) != s.charAt(j)) {return false;}
        }
        return true;
    }
}
