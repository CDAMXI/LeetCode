package WordPattern;

public class WordPatternv1 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String s){
        if(pattern.length() != s.split(" ").length || pattern.length() == 0 || s.length() == 0){return false;}
        return isArrayPalindrome(s.split(" ")) && isPalindromeExact(pattern);
    }

    public static boolean isPalindromeExact(String s) {
        if (s == null) return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static boolean isArrayPalindrome(String[] arr) {
        if (arr == null) return false;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] == null || arr[j] == null) return false;
            if (!arr[i].equals(arr[j])) return false;
            i++;
            j--;
        }
        return true;
    }
}
