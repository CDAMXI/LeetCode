public class WildCardMatchingv2 {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a")); // false
        System.out.println(isMatch("aa", "*")); // true
        System.out.println(isMatch("adceb", "*a*b")); // true
    }

    public static boolean isMatch(String s, String p) {
        int sIndex = 0; // Index for the string `s`
        int pIndex = 0; // Index for the pattern `p`
        int starIndex = -1; // Index where the last '*' was found in the pattern
        int matchIndex = 0; // Index in `s` that matches the part after '*' in `p`

        // Iterate through the string `s`
        while (sIndex < s.length()) {
            // If the pattern character matches the string character or it's a '?', move both pointers
            if (pIndex < p.length() && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
                sIndex++;
                pIndex++;
            }
            // If the pattern character is '*', record the position and move the pattern pointer
            else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
                starIndex = pIndex;
                matchIndex = sIndex;
                pIndex++;
            }
            // If a '*' was found earlier, try to match the rest of the string with the pattern after '*'
            else if (starIndex != -1) {
                pIndex = starIndex + 1;
                matchIndex++;
                sIndex = matchIndex;
            }
            // If none of the above conditions are met, the pattern does not match
            else {
                return false;
            }
        }

        // After processing the string, check if the remaining pattern characters are all '*'
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        // If the pattern pointer reached the end, the pattern matches the string
        return pIndex == p.length();
    }
}
