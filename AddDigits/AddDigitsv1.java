package AddDigits;

import java.util.*;

public class AddDigitsv1 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see the sum of its digits: ");
                int num = kbd.nextInt();

                System.out.println("If you add all the digits in " + num + " you get: " + addDigits(num));

                isValid = true; // A valid value is entered, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consume the invalid token
            }
        }
        kbd.close();
    }

    public static int addDigits(int num) {
        if (num < 0) { num = -num; } // Convert negative numbers to positive
        if (num < 10) { return num; } // Base case: single-digit number
        while (num > 9) {
            if (num < 0) { num = -num; } // Ensure the number is positive
            if (num < 10) { return num % 10; } // Return the last digit
            num = (num % 10) + addDigits(num / 10); // Recursively add digits
        }
        return num;
    }
}
