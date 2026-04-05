import java.util.*;

public class LongestSubStringWithoutRepeatingCharsv2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // Expected Output: 3
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
