package PalindromeNumbers;
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(55));
        System.out.println(isPalindrome(12));
        System.out.println(isPalindrome(120));
        System.out.println(isPalindrome(120021));
    }

    public static boolean isPalindrome(int x){
        if (0 <= x && x <= 9) {return true;}
        String value = String.valueOf(x);
        for (int i = 0, j = value.length() - 1; i <= j; i++, j--) {
            if (value.charAt(i) != value.charAt(j)) {return false;}
        }
        return true;
    }
}
