package LengthOfLastWord;

public class LengthOfLastWordv2 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); // 5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); // 6
        System.out.println(lengthOfLastWord("a")); // 1
        System.out.println(lengthOfLastWord(" ")); // 0
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();

        // Recorre la cadena de atrás hacia adelante
        int cont = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                cont++;
            } else {break; }
        }

        return cont;
    }
}
