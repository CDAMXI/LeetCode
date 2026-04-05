package ValidAnagrams;

import java.util.*;

public class ValidAnagramsv1 {
    public static void main(String[] args){
        System.out.println("Input: s = \"anagram\", t = \"nagaram\"");
        System.out.println("Output: " + isAnagram("anagram", "nagaram")); // Expected: true
    }

    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length() || s.length() < 1 || t.length() < 1){return false;}
        List<Character> sList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {sList.add(s.charAt(i));}
        for (int i = 0; i < t.length(); i++) {
            if (!sList.contains(t.charAt(i))) {return false;}
        }
        return true;
    }
}
