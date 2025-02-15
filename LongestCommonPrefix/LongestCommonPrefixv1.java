package LongestCommonPrefix;

public class LongestCommonPrefixv1 {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        boolean isValid = true;
        for (int i = 0; i < strs.length; i++) {
            isValid = true;
            for (int j = 1; j < strs.length && isValid; j++) {
                if (!strs[j].startsWith(first)) {
                    first = first.substring(0, first.length() - 1);
                    isValid = false;
                }
            }
        }
        return first;
    }
}
