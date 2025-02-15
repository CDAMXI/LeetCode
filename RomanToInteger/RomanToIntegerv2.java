package RomanToInteger;

import java.util.Map;

public class RomanToIntegerv2 {
    // Mapa estático para almacenar los valores de los números romanos
    private static final Map<Character, Integer> ROMAN_VALUES = Map.of(
        'I', 1, 'V', 5, 'X', 10,
        'L', 50, 'C', 100, 'D', 500, 'M', 1000
    );

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // 3
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
    }

    public static int romanToInt(String s) {
        int num = 0;

        // Iteramos sobre la cadena de izquierda a derecha
        for (int i = 0; i < s.length(); i++) {
            int current = ROMAN_VALUES.get(s.charAt(i));
            int next = (i < s.length() - 1) ? ROMAN_VALUES.get(s.charAt(i + 1)) : 0;

            // Si el valor actual es menor que el siguiente, lo restamos; de lo contrario, lo sumamos
            if (current < next) {
                num -= current;
            } else {
                num += current;
            }
        }

        return num;
    }
}
