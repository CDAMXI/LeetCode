package PowOfThree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfThreev2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see if it´s a power of 3: ");
                int num = kbd.nextInt();
                
                if (num <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Ask for a valid value again
                }

                if (isPowerOfThree(num)) {
                    System.out.println(num + " is indeed a power of three.");
                } else {
                    System.out.println(num + " is not a power of three.");
                }

                isValid = true; // A valid value is entered, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consumes the invalid token
            }
        }
        kbd.close();
    }

    public static boolean isPowerOfThree(int n) {
        // Base cases: n must be greater than 0 and must be divisible by 3 until it becomes 1
        if (n <= 0) {return false;}
    
        while (n % 3 == 0) {n /= 3;}
    
        return n == 1;
    }
    
}
