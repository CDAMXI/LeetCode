public class MyAtoiv2 {
    public static void main(String[] args) {
        System.out.println("Result: " + myAtoi("42"));          // Result: 42
        System.out.println("Result: " + myAtoi("-042"));       // Result: -42
        System.out.println("Result: " + myAtoi("1337c0d3"));   // Result: 1337
        System.out.println("Result: " + myAtoi("   -42"));     // Result: -42
        System.out.println("Result: " + myAtoi("words and 987")); // Result: 0
        System.out.println("Result: " + myAtoi("+-12"));       // Result: 0
    }

    public static int myAtoi(String s) {
        if (s == null || s.length() == 0) {return 0;}

        int index = 0;
        int sign = 1;
        int result = 0;

        // 1. Ignore empty spaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        // 2. Manage sign
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // 3. Read digits until you find a non-numeric character
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // 4. Verify overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
