package ReverseInteger;

public class ReverseIntegerv2 {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        boolean isNegative = (x < 0);
        x = Math.abs(x);
        
        int reverse = 0;
        while (x != 0) {
            // Make sure the next step will cause an overflow
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && x % 10 > 7)) {
                return 0;  // Return 0 if there is an overflow
            }
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && x % 10 > 7)) {
                return 0;  // Return 0 if there is an overflow
            }
            
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        
        return isNegative ? -reverse : reverse;
    }
    
}
