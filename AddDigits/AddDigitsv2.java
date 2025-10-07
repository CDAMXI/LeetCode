package AddDigits;

import java.util.*;

public class AddDigitsv2 {
    public static void main(String[] args) {
        try (Scanner kbd = new Scanner(System.in)) {
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
        }
    }

    public static int addDigits(int num) {
        if (num == 0) return 0; // If the number is 0, return 0
        return 1 + (num - 1) % 9; // Mathematical formula to compute the sum of digits
    }
}
