package AddBinary;

import java.math.*;
import java.util.*;

public class addBinaryv4 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String a, b;
        do {
            System.out.print("Enter the first value in binary: ");
            a = kbd.next();
        } while (!a.chars().allMatch(Character::isDigit)); // Lambda expressions are being used

        do {
            System.out.print("Enter the second value in binary: ");
            b = kbd.next();
        } while (!b.chars().allMatch(Character::isDigit)); // Lambda expressions are being used

        System.out.println("The result in binary is: " + addBinary(a, b));
        kbd.close();
    }

    public static String addBinary(String a, String b) {
        // Validate that the strings contain only zeros and ones
        if (!a.matches("[01]+") || !b.matches("[01]+")) {
            return "At least one of the numbers is not in binary";
        }

        // Add the values
        BigInteger result = new BigInteger(a, 2).add(new BigInteger(b, 2));
        // When creating the BigInteger, the 2 passed as a parameter will convert the value to binary
        
        // Convert the result back to binary
        return result.toString(2);
        // Converts result to a string composed of characters corresponding to binary values
    }

    public static String convertToBinary(String a) {
        BigInteger bi = new BigInteger(a);
        return bi.toString(2);
    }
}
