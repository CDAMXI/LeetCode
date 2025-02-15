package CountAndSay;

public class CountAndSayv1 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n){
        if (n < 1 || n > 30) {return "NAN (not an answer)";}
        if (n == 1) {return "1";}
        String result = "1";
        int contador = 1;
        for (int i = 1; i <= n; i++) {
            result += "1";
            char first = result.charAt(0);
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(i) == first) {contador++;}
                else{break;}
            }
            result = result.substring(contador);
            result = contador + "" + first + result;
        }
        return result;
    }
}
