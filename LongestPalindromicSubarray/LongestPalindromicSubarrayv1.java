package LongestPalindromicSubarray;

public class LongestPalindromicSubarrayv1 {
    public static void main(String[] args) {
        System.out.println("For \"abccba\", the longest palindromic subarray is: " + longestPalindrome("abccba"));
        System.out.println("For \"babad\", the longest palindromic subarray is: " + longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s){
        if(s == null || s.length() < 1) {return "";}
        else if(s.length() == 1){return s;}
        String leftHalf = s.substring(0, s.length() / 2);
        String rightHalf = s.substring(s.length() / 2);
        if(rightHalf.length() > leftHalf.length()) {
            rightHalf = rightHalf.substring(1);
        } else if(leftHalf.length() > rightHalf.length()) {
            leftHalf = leftHalf.substring(0, leftHalf.length() - 1);
        }
        rightHalf = new StringBuilder(rightHalf).reverse().toString();
        if(leftHalf.equals(rightHalf)) {return s;}
        else {
            String leftPalindrome = longestPalindrome(leftHalf);
            String rightPalindrome = longestPalindrome(rightHalf);
            return leftPalindrome.length() > rightPalindrome.length() ? leftPalindrome : rightPalindrome;
        }
    }
}
