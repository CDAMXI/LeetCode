public class divideTwoIntegersv1 {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(7, -7));
        System.out.println(divide(7, 7));
        System.out.println(divide(7, 10));
    }

    public static int divide(int dividend, int divisor){
        if (divisor == 0) {return -1;}
        else if(dividend == 0 || divisor < 0 && dividend == 1 ||dividend < divisor){return 0;}
        else if(dividend == divisor ){return 1;}
        else if(divisor == 1){return dividend;}
        else if(divisor > 0){return divide(dividend - divisor,divisor)+1;}
        else{return divide(dividend + divisor,divisor)-1;}
    }
}
