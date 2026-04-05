import java.util.*;

public class FirstUniqueCharInStringv2 {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("abcbc"));  // 0
        System.out.println(firstUniqueChar("aabbcc")); // -1
    }

    public static int firstUniqueChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
