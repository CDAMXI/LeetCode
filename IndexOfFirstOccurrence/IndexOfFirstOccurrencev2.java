package IndexOfFirstOccurrence;

public class IndexOfFirstOccurrencev2 {
    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));  // Output: 0
        System.out.println(strStr("leetcode", "leeto")); // Output: -1
        System.out.println(strStr("hello", "ll"));       // Output: 2
    }
    
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0; // If needle is empty, return 0 by definition
        }
        if (haystack.length() < needle.length()) {
            return -1; // If haystack is shorter than needle, it cannot contain it
        }
    
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i; // Return the index where needle starts in haystack
            }
        }
    
        return -1; // If not found, return -1
    }
}
// Time Complexity: O(n*m) where n is the length of the input string haystack and m is the length of the input string needle
// Space Complexity: O(1)
