package ValidAnagrams;

public class ValidAnagramsv2 {
    public static void main(String[] args){
        System.out.println("Input: s = \"anagram\", t = \"nagaram\"");
        System.out.println("Output: " + isAnagram("anagram", "nagaram")); // Expected: true
    }

    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){return false;}

        int[] count = new int[26]; // Assumes lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0){return false;}
        }
        
        return true;
    }
}
