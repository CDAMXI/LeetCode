package ScrambleString;
import java.util.Random;
public class ScrambleStringv1 {
    public static void main(String[] args) {
        String s1 = "great", s2 = "rgeat";
        System.out.println("Is \"" + s1 + "\" a scramble of \"" + s2 + "\"? " + isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2){
        if(s1.length() != s2.length()) {return false;}
        if(s1.equalsIgnoreCase(s2) || (s1.length() == 1 && s2.length() == 1)) {return true;}
        Random random = new Random(s2.length());
        int splitIndex = random.nextInt(s2.length() - 1) + 1; // Ensure splitIndex is at least 1 and less than s2.length()
        String s2Left = s2.substring(0, splitIndex);
        String s2Right = s2.substring(splitIndex);
        return s1.equalsIgnoreCase(s2Right + s2Left)|| isScramble(s1, s2);
    }
}
