package ReverseInteger;

public class ReverseIntegerv1 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
    }

    public static int reverse(int x){
        boolean isNegative = (x < 0);
        if(isNegative){x = Math.abs(x);}
        int reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x%10;
            x/=10;
        }
        if (isNegative) {return reverse * (-1);}
        else{return reverse;}
    }
}
