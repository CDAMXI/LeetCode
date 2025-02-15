package LengthOfLastWord;

public class LengthOfLastWordv4 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(lengthOfLastWord("a")); // 1
        System.out.println(lengthOfLastWord(" ")); // 0
    }

    public static int lengthOfLastWord(String s) {
        int length = 0; // Longitud de la última palabra
        s = s.trim();
        int i = s.length() - 1;

        // Contar la longitud de la última palabra
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}
