package SelfDividingNumbers;

import java.util.*;

public class SelfDividingNumbersv1 {
    public static void main(String[] args){
        System.out.println(SelfDividingNumbers(1,22)); // Example usage
        System.out.println(SelfDividingNumbers(47,85));  // Example usage
    }

    public static List<Integer> SelfDividingNumbers(int left, int right){
        List<Integer> result = new ArrayList<>(); // Create a list to store self-dividing numbers

        for (int i = left; i <= right; i++) { // Iterate through the range from left to right
            if (isSelfDividing(i)) { // Check if the number is self-dividing
                result.add(i); // Add it to the result list
            }
        }

        return result; // Return the list of self-dividing numbers
    }

    public static boolean isSelfDividing(int num) {
        int originalNum = num; // Store the original number for comparison later

        while (num > 0) { // Loop until all digits are processed
            int digit = num % 10; // Get the last digit

            if (digit == 0 || originalNum % digit != 0) { // Check if digit is 0 or not a divisor
                return false; // Not self-dividing
            }

            num /= 10; // Remove the last digit
        }

        return true; // All digits are divisors, so it's self-dividing
    }
}
