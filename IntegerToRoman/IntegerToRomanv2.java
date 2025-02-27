import java.util.Scanner;

public class IntegerToRomanv2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int value = 0;
        String input;

        while (true) {
            System.out.print("Enter a number (or 'quit' to exit): ");
            input = kbd.nextLine().trim().toLowerCase(); // Lee la entrada y la convierte a minúsculas

            // Verifica si el usuario quiere salir
            if (input.equals("quit")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            try {
                // Intenta convertir la entrada a un número
                value = Integer.parseInt(input);
                if (value > 0) {
                    System.out.println(value + " in Roman Numerals is: " + intToRoman(value));
                } else {
                    System.out.println("Invalid input. Please enter a number greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'quit' to exit.");
            }
        }

        kbd.close();
    }

    public static String intToRoman(int num) {
        // Arrays with values and their corresponding Roman symbols
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // Iterate over the values and symbols
        for (int i = 0; i < values.length; i++) {
            // While the number is greater than or equal to the current value
            while (num >= values[i]) {
                num -= values[i]; // Subtract the value from the number
                result.append(symbols[i]); // Append the corresponding symbol
            }
        }

        return result.toString();
    }
}
