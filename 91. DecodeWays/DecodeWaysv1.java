package DecodeWays;

public class DecodeWaysv1 {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }


    public static int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){return 0;}
        if(s.length() == 1){return 1;}
        int res = s.length() >= 2 && Integer.parseInt(s.substring(0, 2)) <= 26 && s.charAt(1) != '0' ? 2 : 1;
        return res;
    }
}
