package ValidParentheses;

public class ValidParenthesesv1 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("([)]"));
    }

    public static boolean isValid(String s){
        int contPar = 0, contBrack = 0, contKey = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {contPar++;}
            if (s.charAt(i) == ')') {contPar--;}
            if (s.charAt(i) == '[') {contBrack++;}
            if (s.charAt(i) == ']') {contBrack--;}
            if (s.charAt(i) == '{') {contKey++;}
            if (s.charAt(i) == '}') {contKey--;}
        }
        if (contPar == contBrack && contBrack == contKey && contKey == 0) {return true;}
        return false;
    }
}
