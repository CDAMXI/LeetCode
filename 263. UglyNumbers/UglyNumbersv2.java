package UglyNumbers;

public class UglyNumbersv2 {
    public static void main(String[] args) {
        System.out.println(isUgly(6));   // true
        System.out.println(isUgly(8));   // true
        System.out.println(isUgly(1));   // true
        System.out.println(isUgly(14));  // false
    }

    public static boolean isUgly(int n) {
        if (n <= 0){return false;} // Numbers <= 0 are not ugly

        // Divide n by 2, 3, and 5 until it is no longer divisible by them
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        // If after removing factors 2, 3, and 5 it is 1, it is ugly
        return n == 1;
    }
}
