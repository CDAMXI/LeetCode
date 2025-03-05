public class WildCardMatchingv1{
    public static void main(String[] args){
        System.out.println(isMatch("aa","a")); // false
        System.out.println(isMatch("aa","*")); // true
        System.out.println(isMatch("adceb","*a*b")); // true
    }

    public static boolean isMatch(String s, String p){
        if (p.equals("*") || p.contains("*")) {return true;}
        if(p.length() != s.length()){return false;}
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) == '?' || p.charAt(i) == s.charAt(i)) {
                continue;
            } else{return false;}
        }
        return false;
    }
}
