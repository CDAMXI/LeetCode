public class RegularExpressionMatchingv1{
    public static void main(String[] args){
        System.out.println("For s = \"aab\", p = \"c*a*b\", isMatch(s, p) = " + isMatch("aab", "c*a*b"));
    }

    @SuppressWarnings("UnnecessaryContinue")
    public static boolean isMatch(String s, String p){
        if(s.length() == 0 || p.length() == 0){return false;}
        if(p.equals("*")){return true;}

        for(int i = 0; i < s.length(); i++){
            if(i < p.length() && (s.charAt(i) == p.charAt(i) || p.charAt(i) == '.')){
                continue;
            } else if(i < p.length() && p.charAt(i) == '*'){
                if(i > 0 && (s.charAt(i - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.')){
                    // Match zero or more of the previous character
                    continue;
                } else {
                    // Match zero occurrences of the previous character
                    continue;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
