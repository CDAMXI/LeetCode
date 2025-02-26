public class PalindromePartitioningIIv1{
    public static void main(String[] args) {
        System.out.println(minCut("aab"));
        System.out.println(minCut("a"));
        System.out.println(minCut("ab"));
        System.out.println(minCut("bb"));
        System.out.println(minCut("abbab"));
    }

    public static int minCut(String s){
        if (s.length() == 1) {return 0;}
        if (isPalindrome(s)) {return ((int) s.length() /2) - 1;}
        return (int) s.length()/2;
    }

    public static boolean isPalindrome(String word){
        word = word.toLowerCase();
        
        int izquierda = 0;
        int derecha = word.length() - 1;

        while (izquierda < derecha) {
            if (word.charAt(izquierda) != word.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }
}
