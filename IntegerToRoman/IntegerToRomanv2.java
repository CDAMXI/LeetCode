public class IntegerToRomanv2 {
    public static void main(String[] args) {
        System.out.println("Result: " + intToRoman(3749)); // MMMDCCXLIX
        System.out.println("Result: " + intToRoman(58));   // LVIII
        System.out.println("Result: " + intToRoman(1));    // I
        System.out.println("Result: " + intToRoman(3999)); // MMMCMXCIX
        System.out.println("Result: " + intToRoman(3998)); // MMMCMXCVIII
    }

    public static String intToRoman(int num) {
        // Arreglos con valores y símbolos romanos correspondientes
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        // Iterar sobre los valores y símbolos
        for (int i = 0; i < values.length; i++) {
            // Mientras el número sea mayor o igual al valor actual
            while (num >= values[i]) {
                num -= values[i]; // Restar el valor del número
                result.append(symbols[i]); // Concatenar el símbolo correspondiente
            }
        }

        return result.toString();
    }
}
