public class ValidSpanishID{
    public static void main(String[] args) {
        String id = "12345678Z"; // Example ID
        System.out.println(isValidSpanishID(id)); // Output: true or false based on validity
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
