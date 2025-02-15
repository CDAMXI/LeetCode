package PalindromeNumbers;
public class PalindromeNumber2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(55));
        System.out.println(isPalindrome(12));
        System.out.println(isPalindrome(120));
        System.out.println(isPalindrome(120021));
    }

    public static boolean isPalindrome(int x){
        if(x < 0 || x % 10 == 0 && x != 0){return false;}
        int revertNum = 0;
        while(x > revertNum){
            revertNum = revertNum * 10 + x % 10;
            x/=10;
        }
        return x == revertNum || x == revertNum / 10;
    }
}
