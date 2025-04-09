import java.util.*;

public class IntegerToBinaryv3 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int n = 0;

        do {
            System.out.print("Enter a positive integer (negative number to quit): ");
            String input = kbd.next(); // Read the input as a string
            try {
                n = Integer.parseInt(input); // Try to parse the input as an integer
                if (n > 0) {
                    System.out.println("The binary representation of " + n + " is: " + Integer.toBinaryString(n));
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: \"" + input + "\" is not a valid integer.");
            }
        } while (!(n < 0));
        
        kbd.close();
    }
}
