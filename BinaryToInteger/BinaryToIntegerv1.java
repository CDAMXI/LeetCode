package BinaryToInteger;

public class BinaryToIntegerv1 {
    public static void main(String[] args) {
        java.util.Scanner kbd = new java.util.Scanner(System.in);
        String binaryString = null;
        int decimalValue = 0;

        do {
            System.out.print("Enter a binary number (or 'exit' to quit): ");
            binaryString = kbd.nextLine();

            if (!binaryString.equalsIgnoreCase("exit")) {
                try {
                    decimalValue = Integer.parseInt(binaryString, 2);
                    System.out.println("The decimal value of " + binaryString + " is: " + decimalValue);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid binary number: \"" + binaryString + "\" is not a valid binary number.");
                }
            }
        } while (!binaryString.equalsIgnoreCase("exit"));

        kbd.close();
        System.out.println("Program terminated. Goodbye!");
    }
}
