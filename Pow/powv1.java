package Pow;

public class powv1 {
    public static void main(String[] args) {
        System.out.println(Double.parseDouble(String.format("%.5f", myPow(2,10))));
        System.out.println(Double.parseDouble(String.format("%.5f", myPow(2,3))));
        System.out.println(Double.parseDouble(String.format("%.5f", myPow(2,-2))));
    }

    public static double myPow(double x, int n){
        return Math.pow(x,n);
    }
}
