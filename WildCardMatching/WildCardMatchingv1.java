public class WildCardMatchingv1{
    public static void main(String[] args){
        System.out.println(isMatch("aa","a")); // false
        System.out.println(isMatch("aa","*")); // true
    }

    public static boolean isMatch(String s, String p){
        if (s.length() < p.length()) {
            String aux = s;
            s = p;
            p = aux;
        }

        if (p.equals("*")) {return true;}
        if (p.equals("")) {return s.equals("");}
        if (s.equals("")) {return p.equals("");}
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) == '?') {
                return isMatch(s.substring(i), p.substring(i + 1)) || isMatch(s.substring(i + 1), p.substring(i));
            }
        }
        return false;
    }
}
