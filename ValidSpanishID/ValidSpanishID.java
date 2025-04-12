public class ValidSpanishID{
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        while(true){
            System.out.print("Enter a Spanish ID (or 'exit' to quit): ");
            String id = kbd.nextLine();
            if (id.equalsIgnoreCase("exit")) {
                break; // Exit the loop if user types 'exit'
            }
            System.out.println(isValidSpanishID(id)); // Output: true or false based on validity
        }
    }

    public static boolean isValidSpanishID(String id){
        if (id == null || id.length() != 9) {
            return false; // Invalid length
        }

        String numberPart = id.substring(0, 8);
        char letterPart = id.charAt(8);

        // Check if the first 8 characters are digits
        if (!numberPart.matches("\\d{8}")) {
            return false; // Invalid number part
        }

        // Check if the last character is a letter
        if (!Character.isLetter(letterPart)) {
            return false; // Invalid letter part
        }

        // Validate the letter against the number using the formula
        int number = Integer.parseInt(numberPart);
        char expectedLetter = calculateLetter(number);

        return letterPart == expectedLetter; // Return true if they match, false otherwise
    }
}
