package IsPalindrome;

public class isPalindromev2 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
        System.out.println(isPalindrome("No 'x' in Nixon"));                // true
        System.out.println(isPalindrome(" "));                              // true
        System.out.println(isPalindrome("x"));                              // true
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        // Convert the string to lowercase and remove non-alphanumeric characters
        s = s.toLowerCase();
        
        while (i < j) {
            // Skip non-alphanumeric characters on the left
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            // Skip non-alphanumeric characters on the right
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            // Compare the remaining characters
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            // Move both pointers forward
            i++;
            j--;
        }

        return true;
    }
}
// Time Complexity: O(n) where n is the length of the input string s
// Space Complexity: O(1)
