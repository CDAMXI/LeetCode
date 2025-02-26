public class IntegerToRomanv2 {
    public static void main(String[] args) {
        System.out.println("Result: " + intToRoman(3749)); // MMMDCCXLIX
        System.out.println("Result: " + intToRoman(58));   // LVIII
        System.out.println("Result: " + intToRoman(1));    // I
        System.out.println("Result: " + intToRoman(3999)); // MMMCMXCIX
        System.out.println("Result: " + intToRoman(3998)); // MMMCMXCVIII
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
// Time Complexity: O(1) since the number of Roman symbols is constant
// Space Complexity: O(1) since the number of Roman symbols is constant
