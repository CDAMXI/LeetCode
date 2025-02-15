package LongestCommonPrefix;

public class LongestCommonPrefixv3 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        String[] strs1 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs1));
        String[] strs2 = {"florida","floridaman","flor"};
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0];  // Initialize prefix with the first string
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the start of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";  // Return early if no common prefix exists
            }
        }
        return prefix;
    }
}
