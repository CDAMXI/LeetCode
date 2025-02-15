package Pow;

public class powv2 {
    public static void main(String[] args) {
        System.out.println(Double.parseDouble(String.format("%.5f", myPow(2,10))));
        System.out.println(Double.parseDouble(String.format("%.5f", myPow(2,3))));
        System.out.println(Double.parseDouble(String.format("%.5f", myPow(2,-2))));
    }

    public static double myPow(double x, int n){
        if (x == 1) {return x;}
        boolean isNegative = n < 0;
        n = Math.abs(n);
        double result = 1;
        for (int i = 0; i < n; i++) {
            result*=x;
        }
        return isNegative ? 1/result:result;
    }
}
