public class FirstUniqueCharInStringv3 {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("abcbc"));  // 0
        System.out.println(firstUniqueChar("aabbcc")); // -1
    }

    public static int firstUniqueChar(String s) {
        int[] freq = new int[26];

        // Count the frequency of each letter
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find the first with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
