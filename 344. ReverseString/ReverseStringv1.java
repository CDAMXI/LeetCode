package ReverseString;

public class ReverseStringv1 {
    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s){
        for (int i = 0, j = s.length - 1; i <= j; i++, j--) {
            char aux = s[i];
            s[i] = s[j];
            s[j] = aux;
        }
    }
}
