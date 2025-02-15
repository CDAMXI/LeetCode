import java.math.*;
import java.util.*;

public class GenerateParenthesisv1 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n){
        List<String> list = new ArrayList<>();
        if(n < 1 || n > 8){return list;}
        if (n == 1) {
            list.add("()");
            return list;
        }

        for (int i = 0; i < catalanNumber(n).intValue(); i++) {
            
        }

        return list;
    }

    public static BigInteger catalanNumber(int n) {
        BigInteger fact2n = factorial(2 * n);
        BigInteger factnPlus1 = factorial(n + 1);
        BigInteger factn = factorial(n);

        return fact2n.divide(factnPlus1.multiply(factn));
    }

    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
