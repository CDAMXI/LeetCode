public class divideTwoIntegersv2 {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));    // 3
        System.out.println(divide(7, -3));   // -2
    }

    public static int divide(int dividend, int divisor) {
        // Handle special case of divisor being 0
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        
        // Handle special case of overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Avoid overflow
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Work with absolute values
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Initialize the quotient
        int result = 0;

        // Perform division using subtraction and binary shifts
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Increment the divisor using binary shifts
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest possible multiple of the divisor
            absDividend -= tempDivisor;
            result += multiple;
        }

        // Return the result with the correct sign
        return isNegative ? -result : result;
    }
}
