package PowerOfFour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfFourv2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see if it´s a power of 4: ");
                int num = kbd.nextInt();
                
                if (num <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Ask for a valid value again
                }

                if (isPowerOfFour(num)) {
                    System.out.println(num + " is indeed a power of four.");
                } else {
                    System.out.println(num + " is not a power of four.");
                }

                isValid = true; // A valid value is entered, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consume invalid token
            }
        }
        kbd.close();
    }

    public static boolean isPowerOfFour(int n) {
        // n must be greater than 0 and must be divisible by 4 until it becomes 1
        if (n <= 0) {return false;}
    
        while (n % 4 == 0) {n /= 4;}
    
        return n == 1;
    }
    
}
