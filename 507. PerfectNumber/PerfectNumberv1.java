package PerfectNumber;

public class PerfectNumberv1 {
    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28)); // Example usage
        System.out.println(checkPerfectNumber(7)); // Example usage
    }

    public static boolean checkPerfectNumber(int num) {
        if (num <= 0) return false; // Check if the number is less than or equal to 0

        int sum = 0; // Variable to store the sum of divisors

        for (int i = 1; i <= num / 2; i++) { // Iterate from 1 to num/2
            if (num % i == 0) { // If i is a divisor of num
                sum += i; // Add it to the sum
            }
        }

        return sum == num; // Return true if the sum of divisors equals the number, false otherwise
    }
}
