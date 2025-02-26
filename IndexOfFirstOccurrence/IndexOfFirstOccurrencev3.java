package IndexOfFirstOccurrence;

public class IndexOfFirstOccurrencev3 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));  // Output: 0
        System.out.println(strStr("leetcode", "leeto")); // Output: -1
        System.out.println(strStr("hello", "ll"));       // Output: 2
    }
    
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // An empty needle is always present in any string
        }
        if (haystack.length() < needle.length()) {
            return -1; // A shorter haystack cannot contain the needle
        }
    
        // Iterate through haystack up to the point where needle can fit
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;
    
            // Compare character by character between haystack and needle
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
    
            // If all characters match, return the index
            if (found) {
                return i;
            }
        }
    
        return -1; // If the needle is not found in haystack
    }
}
// Time Complexity: O(n*m) where n is the length of the input string haystack and m is the length of the input string needle
// Space Complexity: O(1)
