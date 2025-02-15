package LengthOfLastWord;

public class LengthOfLastWordv1 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World")); //5
        System.out.println(lengthOfLastWord("   fly me   to   the moon  ")); //4
        System.out.println(lengthOfLastWord("luffy is still joyboy")); //6
    }

    public static int lengthOfLastWord(String s) {
        int cont = 0;
        if (s.length() == 1 && s.charAt(0) != ' ') {return 1;}
        if (s.length() <= 1 && s.charAt(0) == ' ') {return 0;}
        s = s.trim();
        for (int i = s.length() - 1; s.charAt(i) != ' ' && i > 0; i--) {
            if (s.charAt(i) != ' ') {cont++;}
            else{break;}
        }
        return cont;
    }
}
